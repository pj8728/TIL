# JDBC 연동 관련 실습 및 SQL 테스트

* jdbc연동을 이용한 데이터 insert 실습

  ~~~java
  package jdbcexam;
  
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.SQLException;
  import java.text.ParseException;
  import java.text.SimpleDateFormat;
  import java.util.Scanner;
  
  public class InsertMeeting {
  
  	public static void main(String[] args) {
  		Connection conn = null;
  		PreparedStatement pstmt  = null;
  		Scanner sc1 = null;
  		try {
  		Class.forName("oracle.jdbc.driver.OracleDriver");
  		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
  		pstmt = conn.prepareStatement(
  				"INSERT into meeting values(meeting_seq.nextval, ?, ?, ?)");
  		sc1 = new Scanner(System.in);
  		System.out.print("이름 : ");
  		String name = sc1.nextLine();
  		System.out.print("메모를 입력하세요 : ");
  		String text = sc1.nextLine();
  		System.out.print("시간입력 (yyyy mm dd hh mi) :");
  		String date = sc1.nextLine();
  		
  		pstmt.setString(1, name);
  		pstmt.setString(2, text);
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm");
  		java.util.Date d = sdf.parse(date);
  		pstmt.setDate(3, new java.sql.Date(d.getTime()));
  		pstmt.executeUpdate();
  		System.out.println("데이터 저장 성공");
  	} catch (ParseException pe) {
  		pe.printStackTrace();
  		System.out.println("파싱 오류");
  	} catch (ClassNotFoundException cnfe) {
  		cnfe.printStackTrace();
  		System.out.println("드라이버 로딩 오류");
  	} catch (SQLException se) {
  		se.printStackTrace();
  		System.out.println("데이터 저장 실패");
  	} finally {
  		try {
  			if (sc1 != null) sc1.close();
  			if (pstmt != null) pstmt.close();
  			if (conn != null) conn.close();			
  		} catch (SQLException se) {
  			se.printStackTrace();			
  		}
  	}
  	}
  }
  ~~~

  

  

* sql test 및 jdbc 연동 test

* sql test

  1. employees 와 departments 데이터를 이용한 sql 구문 작성 테스트

  ~~~sql
  --1. employees 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.
  desc employees;
  
  --2. departments 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.
  desc departments;
  
  --3. 오늘의 날짜를 작성하는 SQL 명령을 작성하시오.
  --날짜의 작성 형식 : 2019년 5월 24일 
  select to_char(sysdate,'yyyy"년 "monthdd"일"') "오늘의 날짜" from dual;
  
  --4. 직원들이 총 몇명인지 출력합니다.
  select count(*) "직원 총원수" from employees;
  
  --5. 올해의 크리스마스가 무슨 요일인지 출력하시오.
  select to_char(to_date(20191225),'day') "올해 크리스마스" from dual;
  
  --6. 부서 배치가 아직 되지 않은 직원의 id(employee_id), 이름(first_name),
  --해당 직원을 담당하는 매니저 ID, 매니저의 이름을 조회하여 출력하시오. 
  --사번 사원 이름 매니저 사번 매니저 이름
  ---------------------------------------------------------------------
  --178 Kimberely 149 Eleni 
  
  select e2.employee_id 사번,e2.first_name "사원 이름",e2.manager_id "매니저 사번"
  ,e1.first_name "매니저 이름" from employees e1,employees e2
  where e2.manager_id=e1.employee_id and e2.department_id is null;
  
  --7. 입사월 별로 직원의 최고급여를 조회하여 출력하시오. 
  --단, 출력시 최고급여 내림차순으로 정렬되어 출력하며 최고급여가 10000 이상인 직원만 출력합니다. 
  --입사월	최고급여
  --------------------------
  --6월 24,000원
  --1월	17,000원
  --9월	17,000원
  --10월	14,000원
  --:
  --11월 10,500원
  
  select to_char(hire_date,'month') 입사월,max(salary) 최고급여
  from employees group by to_char(hire_date,'month')
  having max(salary)>=10000 order by 최고급여 desc;
  
  --8. 입사년도별 직원 수를 구하여 출력하시오. 단, 급여가 5000에서 10000 사이만 직원만
  --그리고 직원수가 7명 이상인 경우만 출력하시오. 또한 출력은 입사년도 순으로 정렬하시오.
  --입사년도 조건에 맞는 직원수
  -----------------------------------------------
  --05	11
  --06	9
  --07	8
  
  select to_char(hire_date,'yy') 입사년도,count(*) "직원 수" from employees
  where salary between 5000 and 10000
  group by to_char(hire_date,'yy') having count(*)>=7
  order by count(*) desc;
  
  --9. 입사일이 6월인 직원의 이름(first_name), 부서이름(department_name) 및 
  --‘축-입사기념달’을 출력하시오. 
  --직원이름 오름차순으로 정렬하여 출력 합니다.
  
  --이름 부서이름 축하메시지
  ---------------------------------------------------------------
  --David IT 축-입사기념달
  --Donald Shipping 축-입사기념달
  --:
  --William Accounting 축-입사기념달 
  
  select e.first_name 이름,d.department_name 부서이름,'축-입사기념달' 축하메시지
  from employees e,departments d
  where e.department_id=d.department_id and to_char(hire_date,'mm')=6
  order by 이름;
  
  --10. 'Den'과 동일 부서에서 근무하는 직원들의 최대월급, 최소월급 그리고 월급의 평균을 구하시오.
  --단, 평균값을 출력할때 백단위까지만 출력하시오.
  
  --최대월급 최소월급 월급평균
  ---------------------------------------------------
  --11000 2500 4150
  
  select max(salary) 최대월급,min(salary) 최소월급,trunc(avg(salary),-2) 월급평균
  from employees group by department_id
  having department_id=(select department_id from employees where first_name='Den');
  ~~~

  

* jdbc 연동 test

  1. employees 데이터에서 같은 성씨를 가진 직원의 이름,성,급여를 출력하는 문제
  2. sql 작성 구문에서 like '?%' 를 썼으나 오류 발생
  3. '?%' 를 ? 로 변경 후 setString 에서 fn 을 fn+"%"로 수정 후 성공

  ~~~java
  package jdbcexam;
  
  import java.sql.*;
  
  public class Prob {
  	public static void main(String[] args) throws SQLException, ClassNotFoundException {
  		Class.forName("oracle.jdbc.driver.OracleDriver");
  		kaja("E");
  	}
  	public static void kaja(String fn) {
  		try {
  			Connection conn = DriverManager.getConnection(
  					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
  			String sql = "select first_name 이름, '('||last_name||')' 성, to_char(salary,'999,999')||'원' 급여 "
  					+"from employees where first_name like ?";
  			PreparedStatement pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, fn+"%");
  			ResultSet rs = pstmt.executeQuery();	
  			if(rs.next()) {
  				do {
  				System.out.println(rs.getString("이름")+rs.getString("성")+rs.getString("급여"));
  			}while(rs.next());
  			}
  			else {
  				System.out.println(fn+" 를 first name 으로 쓰는 인원이 없습니다.");
  			}					
  		}catch(Exception e) {
  			System.out.println("DB연동 오류 발생 : "+e);
  		}
  	}
  }
  
  ~~~

  출력 결과

  Ellen(Abel) 11,000원
  Elizabeth(Bates)  7,300원
  Eleni(Zlotkey) 10,500원
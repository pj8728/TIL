# Web

- Web Client : HTML, CSS, JavaScript, Ajax, JQuery
- Web Server : Servlet, JSP, MVC 패턴, MyBatis,  Spring IoC, Spring MVC



### Servlet 프로그래밍

- Java 언어로 구현하는 웹 서버 프로그래밍 기술
- 웹 서버 프로그래밍 표준 기술 - CGI(C, VisualBasic, Perl..) -> ASP , PHP
                                                        2가지 단점 : 멀티 프로세스
                                                        ---> FastCGI
                                                        ---> Servlet : 멀티 쓰레드(1998 , 9)
- CGI, FastCGI          Servlet
                                  Servlet 엔진(컨테이너)
- Web Server            Web Server
- Tomcat : Web Server + Servlet Container : WAS(Web Application Server)



### Servlet 프로그래밍 정리

1. HttpServlet 클래스를 상속
   Tomcat(Web Server(코요테)+Application Server(카탈리나) : WAS)
   GET : doGet()  // POST : doPost()  //  둘다 : doGet() , doPost(), service()
   HttpServletRequest : 요청 정보를 추출할 때 사용(쿼리 문자열)
   HttpServletResponse : 응답과 관련(응답 스트림 객체, 컨텐트 타입 설정)
2. 서블릿 수행상의 특징
   * 서블릿은 한 번 메모리 할당(객체 생성)되면 할당된 상태를 계속 유지한다.
   * 여러 클라이언트 요청에 대해서 하나의 서블릿 객체를 공유해서 수행한다.
   * 각 시점마다 호출되는 메서드가 정해져 있다.
     객체 생성후 - init()
     요청을 올 때마다 - service() - doGet(), doPost()
     객체 해제 전 - destory()
3. 쿼리 문자열 추출 방법 
   * name=value&name=value&name=value...
   * HttpServletRequest 객체의 getParameter()
     String getParameter("String") : value 값 또는 null 또는 ""
     String[] getParameterValues("String") : value 값들의 배열 또는 null
   * GET 방식의 경우 Query 문자열 추출시 한글이 깨지지 않는다.
     POST 방식의 경우 한글이 깨지는데, 추출하기 전
          request.setCharacterEncoding("UTF-8") 을 호출한 후에 추출한다.

# JSP

#### include

* include 지시자 (형식 : <% include file="example.jsp" %>)
  * 서블릿 1개 -> 한번에 수행 (exam9.jsp)
  * 불러오는 파일의 local id 가 중복 선언될 때 오류(exam12.jsp 12~14행)
* include 액션태그 (형식 : <jsp:include page="example.jsp"/>)
  * 서블릿 n개 -> 개별적 수행 (exam11.jsp)
  * 불러오는 파일의 local id가 중복 선언되더라도 오류발생X(exam12.jsp 16~18행)



#### 요청 내용 클라이언트로 전달하는 방법

1. HttpServletRequest 객체에 저장하여 전달하는 방법 - request scope : 요청이 끝날때까지 유지

2. HttpSession 객체에 저장하여 전달하는 방법 - session scope : 세션이 유지되는동안 유지

3. ServletContext 객체에 저장하여 전달하는 방법 - application scope : 서버가 끊길 때까지 유지

* 공통 메소드 : setAttribute(이름,객체), getAttribute(이름), removeAttribute(이름)



# 

# LottoServlet 예제

### 1.success.jsp와 fail.jsp 두개를 나눠서 만들어서 한 경우

* lottoForm.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style='color:red' >로또 번호를 맞춰 보세요</h1>
<hr>
<form method="get" action="http://70.12.113.170:8000/sedu/lotto1">
1부터 6까지의 숫자를 입력하세요 : 
<input type="number" min="1" max="6" name="number">
<input type="image" src="http://70.12.113.170:8000/sedu/images/clover.png" width=50>
</form>
</body>
</html>
~~~

* LottoServlet.java

~~~ java
package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		int number = Integer.parseInt(request.getParameter("number"));
		int rdnum = (int)(Math.random()*6+1);
		
		System.out.println("전달된 값 : "+number+", 추출된 값 : "+rdnum);
		
		if(rdnum==number) {
			RequestDispatcher rds 
			= request.getRequestDispatcher("/jspexam/success.jsp");
			rds.forward(request, response);
		}
		else {
			RequestDispatcher rdf 
			= request.getRequestDispatcher("/jspexam/fail.jsp");
			rdf.forward(request, response);
		}
	}
}
~~~

* success.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span{
		color: blue
	}
</style>
</head>
<body>
<h3><span>정답</span>입니다.</h3>
<img src="http://70.12.113.170:8000/sedu/images/success.jpg" width=500>
</body>
</html>
~~~

* fail.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span{
		color: red
	}
</style>
</head>
<body>
<h3><span>오답</span>입니다.</h3>
<img src="http://70.12.113.170:8000/sedu/images/fail.jpg" width=500><br><br>
<a href='http://70.12.113.170:8000/sedu/html/lottoForm.html'>다시 시도</a>
</body>
</html>
~~~



### 2.lottoResult.jsp 를 이용한 경우

* lottoForm1.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style='color:red' >로또 번호를 맞춰 보세요</h1>
<hr>
<form method="get" action="http://70.12.113.170:8000/sedu/lotto2">
1부터 6까지의 숫자를 입력하세요 : 
<input type="number" min="1" max="6" name="number">
<input type="image" src="http://70.12.113.170:8000/sedu/images/clover.png" width=50>
</form>
</body>
</html>
~~~

* LottoServlet2.java

~~~ java
package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		int number = Integer.parseInt(request.getParameter("number"));
		int rdnum = (int)(Math.random()*6+1);
		
		System.out.println("전달된 값 : "+number+", 추출된 값 : "+rdnum);
		
		request.setAttribute("data1", number);
		request.setAttribute("data2", rdnum);
		
request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);

	}

}

~~~

* lottoResult.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int data1 = (int)request.getAttribute("data1");
	int data2 = (int)request.getAttribute("data2");
	if(data1==data2){
		out.print("<h3><span>정답</span>입니다.</h3>");
		out.print("<img src='http://70.12.113.170:8000/sedu/images/success.jpg' width=500>");
	}else{
		out.print("<h3><span>오답</span>입니다.</h3>");
		out.print("<img src='http://70.12.113.170:8000/sedu/images/fail.jpg' width=500><br><br>");
		out.print("<a href='http://70.12.113.170:8000/sedu/html/lottoForm1.html'>다시 시도</a>");
	}
%>
</body>
</html>
~~~


## calculate 실습

1. calcForm.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>연산할 두 개의 숫자를 입력하고 연산자를 선택하세요.</h2>
<hr>
<form method="get" action="/mvc/calc">
<input type="number" name="fnum">
<select name="oper">
<option>+</option>
<option>-</option>
<option>*</option>
<option>/</option>
</select>
<input type="number" name="lnum">
<button type="submit">계산</button>
</form>
</body>
</html>
~~~



2. CalcServlet.java

~~~ java
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double fnum = Integer.parseInt(request.getParameter("fnum"));
		String oper = request.getParameter("oper");
		double lnum = Integer.parseInt(request.getParameter("lnum"));
		String url="";
	
		if(oper.equals("+")) {
			request.setAttribute("answer", String.format("%10.2f",fnum+lnum));
			url = "/jspexam/calcResult.jsp";
		}else if(oper.equals("-")) {
			request.setAttribute("answer", String.format("%10.2f",fnum-lnum));
			url = "/jspexam/calcResult.jsp";
		}else if(oper.equals("*")) {
			request.setAttribute("answer", String.format("%10.2f",fnum*lnum));
			url = "/jspexam/calcResult.jsp";
		}else if(oper.equals("/")) {
			if(lnum==0) {
				request.setAttribute("error", "나눗셈 연산 시 나누는 숫자는 0일 수 없습니다.");
				url = "jspexam/errorResult.jsp";
			}else {
				request.setAttribute("answer", String.format("%10.2f",fnum/lnum));
			url = "/jspexam/calcResult.jsp";
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}

~~~



3. calcResult.jsp

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
		color: #ff00ff;
	}
</style>
</head>
<body>
<h2>연산 결과</h2>
<hr>
결과 : <span>
<%
	String answer = (String)request.getAttribute("answer");
	out.print(answer);
%>
</span>
<br><br>
<a href="http://70.12.113.170:8000/mvc/htmlexam/calcForm.html">입력 화면으로</a>
</body>
</html>
~~~



4. errorResult.jsp

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
<h2>처리 중 오류 발생</h2>
<h3>오류 원인 : 
<span style="color: red">
<%
	String error = (String)request.getAttribute("error");
	out.print(error);
%>
</span>
</h3><br>
<a href="http://70.12.113.170:8000/mvc/htmlexam/calcForm.html">입력 화면으로</a>
</body>
</html>
~~~


## product 실습

1. ProductVO

~~~ java
package model;
public class ProductVO {
	private int anum=0;
	private int bnum=0;
	private int hnum=0;
	
	public int getAnum() {
		return anum;
	}
	public void setAnum() {
		++this.anum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum() {
		++this.bnum;
	}
	public int getHnum() {
		return hnum;
	}
	public void setHnum() {
		++this.hnum;
	}
}

~~~

2. product.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		width : 200px;
	}
</style>
</head>
<body>
<h1>구매하려는 상품을 클릭하세요</h1>
<hr>
<form method="get" action="/mvc/cart">
    <a href="http://70.12.113.170:8000/mvc/cart?pid=p001">
    <img src="http://70.12.113.170:8000/mvc/images/apple.gif"></a> 
    <a href="http://70.12.113.170:8000/mvc/cart?pid=p002">
    <img src="http://70.12.113.170:8000/mvc/images/banana.jpg"></a> 
    <a href="http://70.12.113.170:8000/mvc/cart?pid=p003">
    <img src="http://70.12.113.170:8000/mvc/images/halabong.jpg"></a> 
</form>
<br>
<button id="empty">장바구니 비우기</button>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#empty").click(function(){
		$.getJSON("/mvc/cart", function(data){
				alert(data.msg);
		});
	});
});
</script>
</body>
</html>
~~~

3. productView.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선택한 상품 정보</h1>
<hr>
<%
	ProductVO vo = (ProductVO)session.getAttribute("data");
%>
<h4>선택한 사과의 갯수 : <%= vo.getAnum() %></h4>
<h4>선택한 바나나의 갯수 : <%= vo.getBnum() %></h4>
<h4>선택한 한라봉의 갯수 : <%= vo.getHnum() %></h4>
<hr>
<a href="http://70.12.113.170:8000/mvc/htmlexam/product.html"
style="background-image: linear-gradient(150deg,orange,yellow,green)">
상품 선택 화면</a>
</body>
</html>
~~~

4. empty.jsp

~~~ jsp
<%@ page contentType="application/json; charset=utf-8"%>
{
   "msg" : "장바구니가 삭제되었습니다."
}
~~~

5. ProductServlet.java

~~~java
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductVO;

@WebServlet("/cart")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      response.setContentType("text/html; charset=utf-8");      
	      HttpSession session = request.getSession();
	      String pid = request.getParameter("pid");
			if(session.getAttribute("data") == null) {
				session.setAttribute("data", new ProductVO());
			}
	      ProductVO vo = (ProductVO)session.getAttribute("data");  
	      String url = null;
	      if(pid==null) {
	    	  session.invalidate();
	    	  url = "/jspexam/empty.jsp";
		      request.getRequestDispatcher(url).
		        forward(request, response);
	    	  return;
	      }
	      else {
	      if(pid.equals("p001")) {
	          vo.setAnum();
	       }else if(pid.equals("p002")) {
	          vo.setBnum();
	       }else if(pid.equals("p003")) {
	          vo.setHnum();
	       }
	      url = "/jspexam/productView.jsp";
	      } 
	      request.getRequestDispatcher(url).
	        forward(request, response);
	}

}

~~~


## Spring Product 실습

1. ProductController.java

~~~ java
package my.spring.springedu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import vo.ProductVO;

@Controller
@SessionAttributes({"anum","bnum","hnum"})
public class ProductController {	
	@ModelAttribute("anum")
	public ProductVO countMethod1() {
		ProductVO vo = new ProductVO();
		return vo;
	}
	@ModelAttribute("bnum")
	public ProductVO countMethod2() {
		ProductVO vo = new ProductVO();
		return vo;
	}
	@ModelAttribute("hnum")
	public ProductVO countMethod3() {
		ProductVO vo = new ProductVO();
		return vo;
	}
	@RequestMapping(value = "/cart")
	public String handle(@ModelAttribute("anum")ProductVO vo1
			,@ModelAttribute("bnum")ProductVO vo2
			,@ModelAttribute("hnum")ProductVO vo3
			,HttpServletRequest request, SessionStatus s) {
		String pid = request.getParameter("pid");
		if(pid==null) {
			s.setComplete();
			return "empty";
		}else {
	      if(pid.equals("p001")) {
	          vo1.setAnum();
	       }else if(pid.equals("p002")) {
	          vo2.setBnum();
	       }else if(pid.equals("p003")) {
	          vo3.setHnum();
	       }
	      return "productView"; 
		}
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
<form method="get" action="/springedu/cart">
    <a href="http://70.12.113.170:8000/springedu/cart?pid=p001">
    <img src="http://70.12.113.170:8000/springedu/resources/images/apple.gif"></a> 
    <a href="http://70.12.113.170:8000/springedu/cart?pid=p002">
    <img src="http://70.12.113.170:8000/springedu/resources/images/banana.jpg"></a> 
    <a href="http://70.12.113.170:8000/springedu/cart?pid=p003">
    <img src="http://70.12.113.170:8000/springedu/resources/images/halabong.jpg"></a> 
</form>
<br>
<button id="empty">장바구니 비우기</button>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#empty").click(function(){
		$.getJSON("/springedu/cart", function(data){
				alert(data.msg);
		});
	});
});
</script>
</body>
</html>
~~~

3. productVO.java

~~~ java
package vo;
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

4. productView.jsp

~~~jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>선택한 사과의 갯수 : ${ sessionScope.anum.anum }</h4>
<h4>선택한 바나나의 갯수 : ${ sessionScope.bnum.bnum }</h4>
<h4>선택한 한라봉의 갯수 : ${ sessionScope.hnum.hnum }</h4>
<a href="http://70.12.113.170:8000/springedu/resources/product.html"
style="background-image: linear-gradient(150deg,orange,yellow,green)">
상품 선택 화면</a>
</body>
</html>
~~~

5. empty.jsp

~~~jsp
<%@ page contentType="application/json; charset=utf-8"%>
{
   "msg" : "장바구니가 삭제되었습니다."
}
~~~


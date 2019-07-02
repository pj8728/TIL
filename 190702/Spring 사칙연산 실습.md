## Spring 사칙연산 실습

1. CalcController.java

~~~ java
package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {	
	@RequestMapping(value="/calc")
	public ModelAndView calc(double fnum,double lnum,String oper) {
		ModelAndView mav = new ModelAndView();	
		if(oper.equals("+")) {
			mav.addObject("answer", fnum+lnum);
			mav.setViewName("calcResult");			
		}else if(oper.equals("-")) {
			mav.addObject("answer", fnum-lnum);
			mav.setViewName("calcResult");
		}else if(oper.equals("*")) {
			mav.addObject("answer", fnum*lnum);
			mav.setViewName("calcResult");
		}else if(oper.equals("/")){
			if(lnum==0) {
				mav.addObject("error", "나눗셈 연산 시 나누는 숫자는 0일 수 없습니다.");
				mav.setViewName("errorResult");
			}else {
				mav.addObject("answer", fnum/lnum);
				mav.setViewName("calcResult");
			}
		}
		return mav;
	}
}
~~~

2. calcForm.html

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>연산할 두 개의 숫자를 입력하고 연산자를 선택하세요.</h2>
<hr>
<form method="get" action="/springedu/calc">
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

3. calcResult.jsp

~~~jsp
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
<%=
	request.getAttribute("answer")
%>
</span>
<br><br>
<a href="http://70.12.113.170:8000/springedu/resources/calcForm.html">입력 화면으로</a>
<br>
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
<%=
	(String)request.getAttribute("error")
%>
</span>
</h3><br>
<a href="http://70.12.113.170:8000/springedu/resources/calcForm.html">입력 화면으로</a>
<br>
${ error }
</body>
</html>
~~~


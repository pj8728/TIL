# Spring MVC edu 실습

1. EduController.java

~~~ java
package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {	
	@RequestMapping(value="/score")
	public ModelAndView avg(int avg) {
		ModelAndView mav = new ModelAndView();	
		if(avg>=90) {
			mav.setViewName("gradeA");
		}else if(avg>=80) {
			mav.setViewName("gradeB");
		}else if(avg>=70) {
			mav.setViewName("gradeC");
		}else {
			mav.setViewName("gradeD");
		}
		return mav;
	}
}
~~~

2. eduForm.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	article{
		padding: 10px;
		border: 1px solid black;
		width: 400px;
		background-image: linear-gradient(150deg,red,orange,yellow,green,blue,purple);
		border-radius: 15px;
		margin-left: auto;
		margin-right: auto;
	}
	h2{
		text-align: center;
	}
</style>
</head>
<body>
<article>
<h2>성적을 입력하시오</h2>
<hr>
<form method="post" action="/springedu/score">
이름 : <input type="text" required="required" size="5" name="name" ><br>
평균 점수 : <input type="number" min="0" max="100" size="5" required="required" name="avg"><br><br>
<button type="submit">전송</button> <button type="reset">재작성</button>
</form>
</article>
</body>
</html>
~~~

3. gradeA.jsp

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
<h2>
<%
	String name = request.getParameter("name");
	out.print(name);
%>
님은 A등급입니다.
</h2><br>
<a href='http://70.12.113.170:8000/mvc/htmlexam/eduForm.html'>성적 입력 화면으로</a>
</body>
</html>
~~~

4. gradeB.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
<%
	String name = request.getParameter("name");
	out.print(name);
%>
님은 B등급입니다.
</h2><br>
<a href='http://70.12.113.170:8000/mvc/htmlexam/eduForm.html'>성적 입력 화면으로</a>
</body>
</html>
```

5. gradeC.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
<%
	String name = request.getParameter("name");
	out.print(name);
%>
님은 C등급입니다.
</h2><br>
<a href='http://70.12.113.170:8000/mvc/htmlexam/eduForm.html'>성적 입력 화면으로</a>
</body>
</html>
```

6. gradeD.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
<%
	String name = request.getParameter("name");
	out.print(name);
%>
님은 D등급입니다.
</h2><br>
<a href='http://70.12.113.170:8000/mvc/htmlexam/eduForm.html'>성적 입력 화면으로</a>
</body>
</html>
```


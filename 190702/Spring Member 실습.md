## Spring Member 실습

1. MemberController.java

~~~ java
package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;
@Controller
public class MemberController{
	@RequestMapping(value = "/member" , method = RequestMethod.POST)
	public ModelAndView procPost(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		String name = vo.getName();
		String phone = vo.getPhone();
		String id = vo.getId();
		String password = vo.getPassword();
		if(name.equals("")) {vo.setName("없음");}
		if(phone.equals("")) {vo.setPhone("없음");}
		if(id.equals("")) {vo.setId("없음");}
		if(password.equals("")) {vo.setPassword("없음");}
		mav.setViewName("memberView");
		return mav;
	}
}

~~~

2. memberForm.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
		border: 1.5px solid #999999;
		border-radius: 15px;
		width: 250px;
		height: 30px;
		box-shadow: 3px 3px gray;
	}
	h1{
		text-shadow: 2px 2px 2px gray;
	}
	button{
		border : 1px solid gray;
		border-radius: 7.5px;
	}
</style>
</head>
<body>
<h1>회원 정보를 입력하십시오.</h1>
<hr>
<form method="POST" action="/springedu/member">

<input type="text" placeholder=" 이름을 입력하세요" name="name"><br>

<input type="tel" placeholder=" 전화번호를 입력하세요" name="phone"
pattern = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}" ><br>

<input type="text" placeholder=" 계정을 입력하세요" name="id" ><br>

<input type="password" placeholder=" 패스워드를 입력하세요" 
name="password" ><br><br>

<button type="submit">등록</button> <button type="reset">재작성</button>

</form>
</body>
</html>
~~~

3. memberView.jsp

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
<hr>
	<c:if test="${!empty memberVO}" >
		<ul>
			<li>이름 : ${ memberVO.name } </li>
			<li>전화번호 : ${ memberVO.phone }</li>
			<li>계정 : ${ memberVO.id }</li>
			<li>암호 : ${ memberVO.password }</li>
		</ul>
	</c:if>
</body>
</html>
~~~

4.MemberVO.java

~~~ java
package vo;

public class MemberVO {
	private String name;
	private String phone;
	private String id;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
~~~
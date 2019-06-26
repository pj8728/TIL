# JSTL 실습 1

* 주소를 입력하여 위도 및 경도를 불러오는 실습

~~~ jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위도 경도 예제</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<h2>위도 경도 예제</h2>
<hr>
<c:choose>
	<c:when test="${ pageContext.request.method == 'GET' }">
		<h2>주소를 입력하세요</h2>
		<hr>
		<form method="POST" action="/sedu/jspexam/latlng.jsp" >
			주소 : <input type="text" name="address" required >
			<input type="submit" value="선택">
		</form>	
	</c:when>
	<c:otherwise>
<c:catch var="err"> 
<c:import var="latlng"
url="https://maps.googleapis.com/maps/api/geocode/xml?language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE"
 charEncoding="UTF-8">
 <c:param name="address" value="${param.address}" />
 </c:import>
  <x:parse varDom="latlng" xml="${latlng}"></x:parse>
	        	<c:set var="address" value="${ param.address }"/>
	        	<x:if select="$latlng//status = 'OK'">
	        	<x:forEach select="$latlng//location">	
주소 : <x:out select="$address"/> <br>
위도 : <x:out select="lat"/> <br>
경도 : <x:out select="lng"/><br>
</x:forEach>
		</x:if>	        		       			        
	        <x:if select="$latlng//status!='OK'">
	        	<h3>${ param.address }에 대한 정보는 존재하지 않습니다.</h3>	        
	        </x:if>
</c:catch>
<c:if test="${!empty err}">
   <h2>오류 발생</h2>
   ${err}
</c:if>
<hr>
<a href="/sedu/jspexam/latlng.jsp">입력 화면으로</a>
	</c:otherwise>
</c:choose>
</body>
</html>
~~~


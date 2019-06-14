## JQuery 함수 구조

* $(아규먼트).xxx() / $.xxx() 
* each()
* var ary = [10,20,30,40,50];
* $(ary).each(function(index,data){ });
* $.each(ary, function(index,data){ });
* $(자바스크립트객체) , $("CSS선택자문자열") , $("CSS선택자문자열" , DOM객체), $("HTML태그문자열") 
* $(함수) == window.onload(함수)==$(document).ready(함수)
* $(...).val() [val() : getter , val(아규먼트(값,함수)) : setter]
* html() : getter , html(아규먼트) : setter
* css("속성명") : getter , css("속성명","속성값") , css("속성명", 함수)  , css({"속성명", "속성값"... }) : setter
* attr("속성명") : getter , attr("속성명", "속성값") , attr("속성명", 함수) , attr({"속성명", "속성값"... })  : setter
* 1. 이벤트이름(함수)
  2. on("이벤트이름", 함수)  / off("이벤트이름", 함수) 
  3. one("이벤트이름", 함수) 
* 일반 태그의 컨텐트 : html(), text()
* form 태그의 서브태그들 : val()
* form 태그의 서브태그 중 textarea : text() , val()


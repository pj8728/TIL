# CSS

* style : 지정 범위에 대한 세부적으로 추가할 옵션을 넣음

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>CSS로 무엇을 할 수 있을까?</h1>
<hr>
<h1 style="color : green">둘리</h1>
<h1 style="color : green; background-color : yellow">또치</h1>
<h1 style="color : green">도우너</h1>
<h1 style="color : green">희동이</h1>
</body>
</html>
~~~

==============================================================================

* style /style : style 범위 내에 조건을 주고 속성값에 충족하는 조건에 옵션을 줌
* ex1) h1.gstyle : h1으로 묶인 내용 중 class 가 gstyle 인 내용에 옵션을 줌
* ex2) #ystyle : id 가 ystyle 인 내용에 옵션을 줌

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1.gstyle{
		color : green 
	}
	#ystyle{
		background-color : yellow
	}
</style>
</head>
<body>
<h1>CSS로 무엇을 할 수 있을까?</h1>
<hr>
<h1 class="gstyle">둘리</h1>
<h1 class="gstyle" id="ystyle">또치</h1>
<h1 class="gstyle">도우너</h1>
<h1 class="gstyle">희동이</h1>
</body>
</html>
~~~

==============================================================================

* span : 내용에서 일부분을 옵션을 주고자 할때 쓴다. width 는 적용되지 않는다.

* width / height : ~~px , ~~% 로 적용시킬 수 있다.

* div : block형. width 등을 ~~px로 주면 창 축소시 블럭이 잘림

  ​		그러나 ~~%로 주면 창 축소해도 블럭이 잘리지 않고 작성된 내용이 다음줄로 내려오는 등의 변화가 생김

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		background-color: lime;
		margin : 5px;
		width: 60%;
		height : 200px;
		font-size: 
	}
	span{
		background-color: pink;
		margin : 20px;
		width : 300px; /* 적용 안됌*/
	}
</style>
</head>
<body>
<h1>CSS 선택자와 속성들 학습(2)</h1>
<hr>
<div>가나다라마바사아</div>
<div>0123456789</div>
<div>abcdefghij</div>
<hr>
<span>가나다라마바사아</span>
<span>0123456789</span>
<span>abcdefghij</span>
</body>
</html>
~~~


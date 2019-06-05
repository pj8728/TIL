# JavaScript 구구단 구현

### 1.인라인 이벤트 모델

~~~ javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section{
		border : 2px solid #720000;
		height : 400px;
	}
	h2{
		text-align : center;
	}
	button{
		border : 1px solid #ff0000;
		border-radius: 15px 15px 15px 15px;
		padding-left: 20px;
		padding-right : 20px;
		padding-top: 10px;
		padding-bottom: 10px;
		background-color: white;
	}
	nav{
		text-align : center;
	}
	article{
		text-align : center;
	}
</style>
</head>
<body>
<section>
<h2>구구단</h2>
<nav>
<button onclick="g(1)">1단</button>
<button onclick="g(2)">2단</button>
<button onclick="g(3)">3단</button>
<button onclick="g(4)">4단</button>
<button onclick="g(5)">5단</button>
<button onclick="g(6)">6단</button>
<button onclick="g(7)">7단</button>
<button onclick="g(8)">8단</button>
<button onclick="g(9)">9단</button>
</nav>
<br><br>
<article>
</article>
</section>
<script>
var target = document.getElementsByTagName("article")[0];
 	function g(e){
 		target.innerHTML="";
			for(var i=1;i<10;i++){
				target.innerHTML += e+"*"+i+"="+e*i+"<br>";
			}
		}
</script>
</body>
</html>
~~~

### 2.고전 이벤트 모델

~~~javascript
<script>
var dan = document.getElementsByTagName("article")[0];
for(var k=1;k<10;k++){
var target = document.getElementById(k);
target.onclick = g;
}
function g(e){
	var k = e.target.id;
	dan.innerHTML="";
		for(var i=1;i<10;i++){
		dan.innerHTML += k+"*"+i+"="+k*i+"<br>";
	}
}
</script>

인라인 이벤트 모델과 구조는 같고, script 내용만 다름 
~~~

### 3.표준 이벤트 모델

~~~javascript
<script>
var dan = document.getElementsByTagName("article")[0];
for(var k=1;k<10;k++){
var target = document.getElementById(k);
target.addEventListener("click", g);
}
function g(e){
	var k = e.target.id;
	dan.innerHTML="";
		for(var i=1;i<10;i++){
		dan.innerHTML += k+"*"+i+"="+k*i+"<br>";
	}
}
</script>

인라인 이벤트 모델과 구조는 같고, script 내용만 다름 
~~~


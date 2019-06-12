# JQuery 를 이용한 실습

### 1.요일 글자 색깔 2초마다 변경

~~~ javascript
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
	$(document).ready(function(){
		setInterval(function(){
			$('span').val(function(){
				var col = ['Red','Blue','Green','Cyan','Yellow'];
				var num = Math.floor(Math.random()*5);
				$('span').css('color',col[num]);
			});
		},2000);
	});
</script>
</head>
<body>
<h1>오늘은
 <span>
<script>
var d= new Date();
var week = new Array('일','월','화','수','목','금','토');
document.write(week[d.getDay()]);
</script>
</span>요일입니다.
</h1>
</body>
</html>
~~~



### 2. 이미지 opacity 변경하기

~~~ javascript
<!DOCTYPE html>
<html>
<head>
<title>JQuery 실습2</title>
<style>
	div, h1{
		text-align: center;
	}
	table{
		margin : auto;
		text-align: center;
	}
</style>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
	$(document).ready(function(){
		$('img').css({'width':'250','opacity':'0.6'});
		$('img').click(function(){
			$(this).css('opacity',1);
		});
		$('#a').click(function(){
			$('img').css('opacity',1);
		});
		$('#b').click(function(){
			$('img').css('opacity',0.6);
		});
	});
</script>
</head>
<body>
<h1>JQuery를 이용한 이미지 opacity 변경</h1>
<hr>
<section>
<div>
<table>
<tr>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/Chrysanthemum.jpg"/></th>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/Desert.jpg"/></th>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/Hydrangeas.jpg"/></th>
</tr>
<tr>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/Jellyfish.jpg"/></th>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/Koala.jpg"/></th>
    <th><img src="http://70.12.113.170:8000/edu/jqexam/domedit/clownfish.jpg"/></th>
 </tr>   
   </table>
    </div>
    <br>
</section>
<div>
    <button id="a">모두 진하게</button>
    <button id="b">모두 반투명하게</button>
    </div>
</body>
</html>
~~~


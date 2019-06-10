# MyCard 작성

~~~javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#dropbox{
	float : left;
	 width : 400px;
 	 height : 560px;
 	 border : 1px solid black;
 	 margin : 10px;
	}
	#picturesbox{
		float : left;
	 width : 400px;
 	 height : 560px;
 	 border : 1px solid black;
 	 margin : 10px;
	}
	#picturesbox > img{
  float: left;
  padding: 5px;
  width : 80px;
  height : 80px;
}
</style>
  <script>
  var canvas;
  var context;

  function save(){
  	canvas = document.getElementById("canvas");
  	localStorage.setItem("canvas",canvas.toDataURL());
  }

  function del(){
  	console.log("CLEAR");
  	context = canvas.getContext("2d");
  	context.clearRect(0,0,canvas.width,canvas.height);
  }

  function read(){
  	var img = new Image();
  	img.src = localStorage.getItem("canvas");
  	img.onload = function(){
  		context.drawImage(img,0,0);
  	}
  }

//---------------------------------------------------------------------
function fillRect(){
	var rect = document.getElementById("back").value;
	document.getElementById("canvas").style.backgroundColor = rect;
}

function strokeRect(){
	var border = document.getElementById("border").value;
	document.getElementById("dropbox").style.borderColor = border;
}
  
function text(event){
	var text = document.getElementById("text").value;
	var textcol = document.getElementById("textcol").value;
	
	  var posx=event.pageX-drop.offsetLeft;
	  var posy=event.pageY-drop.offsetTop;

	  canvas.font = "20px 굴림";
	  canvas.fillStyle = textcol;
	  canvas.fillText(text,posx,posy+10);  
}

//---------------------------------------------------------------------
    var drop;
    
    function initiate(){
	  var images=document.querySelectorAll('#picturesbox > img');
	  for(var i=0; i<images.length; i++){
	    images[i].addEventListener('dragstart', dragged, false);
	    images[i].addEventListener('dragend', ending, false);
	  }

	  drop=document.getElementById('canvas');
	  canvas=drop.getContext('2d');

	  drop.addEventListener('dragover', function(e){ e.preventDefault(); }, false);
	  drop.addEventListener('drop', dropped, false);
	}
	function ending(e){
	  elem=e.target;
	}
	function dragged(e){
	  var elem=e.target;
	  e.dataTransfer.setData('aa', elem.getAttribute('id'));
	  e.dataTransfer.setDragImage(e.target, 0, 0);
	}
	function dropped(e){
	  e.preventDefault();
	  var id=e.dataTransfer.getData('aa');
	  var elem=document.getElementById(id);

	  var posx=e.pageX-drop.offsetLeft;
	  var posy=e.pageY-drop.offsetTop;

	 canvas.drawImage(elem,posx,posy, 40, 40);
	 
	}
	window.addEventListener('load', initiate, false);
  </script>
</head>
<body>
<h1>HTML5로 크리스마스 카드 만들기</h1>
<button onclick="save();">저장하기</button>
<button onclick="read();">읽어오기</button>
<button onclick="del();">지우기</button>
<br>

<h4>배경 색 설정 : 
<input type="color" id="back" onchange="fillRect();">
테두리 색 설정 : 
<input type="color" id="border" onchange="strokeRect();">
</h4>
<h4>메시지 색 설정 : 
<input type="color" id="textcol">
입력 메시지 : 
<input type="text" size=50 id="text">
</h4>

<section id="dropbox">
<canvas id="canvas" width=400 height=560
 onclick="text(event);"></canvas>
</section>

<section id="picturesbox">
	<img id="image1" src="http://70.12.113.170:8000/edu/jsexam/xmas/g1.png">
	<img id="image2" src="http://70.12.113.170:8000/edu/jsexam/xmas/g2.png">
	<img id="image3" src="http://70.12.113.170:8000/edu/jsexam/xmas/g3.png">
	<img id="image4" src="http://70.12.113.170:8000/edu/jsexam/xmas/g4.png">
	<img id="image5" src="http://70.12.113.170:8000/edu/jsexam/xmas/g5.png">
	<img id="image6" src="http://70.12.113.170:8000/edu/jsexam/xmas/g6.png">
	<img id="image7" src="http://70.12.113.170:8000/edu/jsexam/xmas/g7.png">
	<img id="image8" src="http://70.12.113.170:8000/edu/jsexam/xmas/g8.png">
	<img id="image9" src="http://70.12.113.170:8000/edu/jsexam/xmas/g9.png">
	<img id="image10" src="http://70.12.113.170:8000/edu/jsexam/xmas/g10.png">
	<img id="image11" src="http://70.12.113.170:8000/edu/jsexam/xmas/g11.png">
	<img id="image12" src="http://70.12.113.170:8000/edu/jsexam/xmas/g12.png">
	<img id="image13" src="http://70.12.113.170:8000/edu/jsexam/xmas/g13.png">
	<img id="image14" src="http://70.12.113.170:8000/edu/jsexam/xmas/g14.png">
	<img id="image15" src="http://70.12.113.170:8000/edu/jsexam/xmas/g15.png">
	<img id="image16" src="http://70.12.113.170:8000/edu/jsexam/xmas/g16.png">
	<img id="image17" src="http://70.12.113.170:8000/edu/jsexam/xmas/g17.png">
	<img id="image18" src="http://70.12.113.170:8000/edu/jsexam/xmas/g18.png">
	<img id="image19" src="http://70.12.113.170:8000/edu/jsexam/xmas/g19.png">
	<img id="image20" src="http://70.12.113.170:8000/edu/jsexam/xmas/g20.png">
	<img id="image21" src="http://70.12.113.170:8000/edu/jsexam/xmas/g21.png">
	<img id="image22" src="http://70.12.113.170:8000/edu/jsexam/xmas/g22.png">
	<img id="image23" src="http://70.12.113.170:8000/edu/jsexam/xmas/g23.png">
	<img id="image24" src="http://70.12.113.170:8000/edu/jsexam/xmas/g24.png">
</section>
<br>
</body>
</html>
~~~


# JavaScript 표정 만들기

~~~javascript
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function round() {
		var draw = document.getElementById("smile");
	if(draw.getContext){
		canvas = draw.getContext('2d');
//---------------------------------------------------------------------------
		canvas.beginPath();
		canvas.arc(100, 150, 75, 0, Math.PI * 2, false);
		canvas.fillStyle = "yellow";
		canvas.fill();
		canvas.strokeStyle = "black";
		canvas.stroke();		
		
		canvas.beginPath();
		canvas.arc(100, 170, 20, 0, Math.PI, false);
		canvas.fillStyle = "red";
		canvas.fill();	
		
		canvas.beginPath();
		canvas.arc(70, 140, 20, Math.PI, Math.PI*2, false);
		canvas.strokeStyle = "black";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.arc(130, 140, 20, Math.PI, Math.PI*2, false);
		canvas.strokeStyle = "black";
		canvas.stroke();
//---------------------------------------------------------------------------
		canvas.beginPath(); 
		canvas.arc(300, 150, 75, 0, Math.PI * 2, false);
		canvas.fillStyle = "#fff4d4";
		canvas.fill();
		canvas.strokeStyle = "black";
		canvas.stroke();
	    
		canvas.beginPath();
		canvas.arc(300, 175, 20, 0, Math.PI, false);
		canvas.fillStyle = "blue";
		canvas.fill();	
		
		/*canvas.beginPath();
		canvas.arc(280, 110, 20, Math.PI*0.3, Math.PI*0.7, false);
		canvas.strokeStyle = "black";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.arc(320, 110, 20, Math.PI*0.3, Math.PI*0.7, false);
		canvas.strokeStyle = "black";
		canvas.stroke();*/
		
		canvas.beginPath();
		canvas.moveTo(270,120);
		canvas.quadraticCurveTo(280,130,290,120);
		canvas.stroke();
		
		canvas.beginPath();
		canvas.moveTo(310,120);
		canvas.quadraticCurveTo(320,130,330,120);
		canvas.stroke();
		
		canvas.beginPath();
		canvas.moveTo(300,134);
		canvas.lineTo(285,141);	
		canvas.lineTo(300,148);
		canvas.stroke();
		
//---------------------------------------------------------------------------
		canvas.beginPath();
		canvas.arc(500, 150, 75, 0, Math.PI * 2, false);
		canvas.fillStyle = "yellow";
		canvas.fill();
		canvas.strokeStyle = "gray";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.arc(500, 170, 30, 0, Math.PI, false);
		canvas.fillStyle = "red";
		canvas.fill();	
		canvas.strokeStyle = "blue";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.moveTo(470,171);
		canvas.lineTo(530,171);
		canvas.strokeStyle = "blue";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.arc(470, 130, 15, Math.PI, Math.PI*2, false);
		canvas.fillStyle = "skyblue";
		canvas.fill();	
		canvas.strokeStyle = "black";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.moveTo(455,129);
		canvas.lineTo(485,129);
		canvas.stroke();
		
		canvas.beginPath();
		canvas.moveTo(500,130);
		canvas.lineTo(485,145);
		canvas.lineTo(500,150);
		canvas.stroke();
		
		canvas.beginPath();
	    canvas.moveTo(515,130);
	    canvas.bezierCurveTo(525,135,535,110,545,130);
	    canvas.stroke();
		
//---------------------------------------------------------------------------
		canvas.beginPath();
		canvas.arc(700, 150, 75, 0, Math.PI * 2, false);
		canvas.fillStyle = "yellow";
		canvas.fill();
		canvas.strokeStyle = "lime";
		canvas.stroke();
		
		canvas.beginPath();
		canvas.arc(700, 170, 40, 0, Math.PI, false);
		canvas.fillStyle = "red";
		canvas.fill();	
		
		canvas.beginPath();
		canvas.arc(670, 130, 15, Math.PI, Math.PI*2, false);
		canvas.strokeStyle = "black";
		canvas.stroke();
		canvas.fillStyle = "blue";
		canvas.fill();	
		
		canvas.beginPath();
		canvas.arc(730, 130, 15, Math.PI, Math.PI*2, false);
		canvas.strokeStyle = "black";
		canvas.stroke();
		canvas.fillStyle = "blue";
		canvas.fill();	
		
		canvas.beginPath();
		canvas.moveTo(700,130);
		canvas.lineTo(685,150);
		canvas.lineTo(705,160);
		canvas.stroke();
		
//---------------------------------------------------------------------------	

	}else{
		alert("사파리 브라우저나 파이어폭스 1.5 이상의 브라우저에서만 사이트 내용을 제대로 볼 수 있습니다.")
		}
	}
	window.addEventListener("load", round, false);
</script>
</head>
<body>
	<canvas id="smile" width="800" height="300">
</canvas>
</body>
</html>
~~~


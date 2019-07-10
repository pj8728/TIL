## d3 enter() 를 이용한 실습

~~~ html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<script src="d3.v3.min.js"></script>
		<title>enter() 를 이용한 실습</title>
	</head>
	<body>
		<svg>
			<text x="25" y="40" font-size="24px" style="fill:black">SVG 텍스트 예제</text>
			<text x="25" y="80" font-size="24px" font-family="바탕" style="fill:black">SVG 텍스트 예제</text>
			<text x="25" y="120" font-size="24px" font-family="궁서" style="fill:black">SVG 텍스트 예제</text>
		</svg>
		<script>
d3.select('body')
	.selectAll("text")
	.data(['둘리','또치','도우너'])
	.text(function(d,i){return d})
	.enter()
	.append('text')
</script>
	</body>
</html>

~~~


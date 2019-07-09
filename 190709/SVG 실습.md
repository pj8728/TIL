## SVG 를 이용한 그림 그리기

1. svgsmile.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<svg width="800" height="300">

		<circle cx="100" cy="150" r="75" fill="yellow" stroke-width="1" stroke="black"/>
		<path d="M77,163 C77,193 123,193 123,163" fill="red"/>
		<path d="M50,140 C50,113 90,113 90,140" fill="none" stroke-width="1" stroke="black"/>
		<path d="M110,140 C110,113 150,113 150,140" fill="none" stroke-width="1" stroke="black"/>
		
		
		<circle cx="300" cy="150" r="75" fill="#fff4d4" stroke-width="2" stroke="black"/>
		<path d="M280,175 C280,201 320,201 320,175 Z" fill="blue"/>
		<path d="M270,120 C270,127 290,127 290,120" fill="none" stroke-width="2" stroke="black"/>
		<path d="M310,120 C310,127 330,127 330,120" fill="none" stroke-width="2" stroke="black"/>
		<path d="M300,134 L285,141 L300,148" fill="none" stroke-width="2" stroke="black"/>
		
		
		<circle cx="500" cy="150" r="75" fill="yellow" stroke-width="1.5" stroke="gray"/>
		<path d="M470,170 C470,210 530,210 530,170 Z" fill="red" stroke-width="1" stroke="blue"/>
		<path d="M455,130 C455,110 485,110 485,130 Z" fill="skyblue" stroke-width="1.5" stroke="black"/>
		<path d="M500,130 L485,145 L500,150" fill="none" stroke-width="1" stroke="black"/>
		<path d="M515,130 C525,135 535,110 545,130" fill="none" stroke-width="1.5" stroke="black"/>
		
		
		<circle cx="700" cy="150" r="75" fill="yellow" stroke-width="1.5" stroke="lime"/>
		<path d="M660,170 C660,223 740,223 740,170 Z" fill="red" stroke-width="1" stroke="black"/>
		<path d="M650,126 C650,102 685,102 685,126 Z" fill="blue" stroke-width="1" stroke="black"/>
		<path d="M715,126 C715,102 750,102 750,126 Z" fill="blue" stroke-width="1" stroke="black"/>
		<path d="M700,130 L685,150 L705,160" fill="none" stroke-width="1" stroke="black"/>
		
		
</svg>
</body>
</html>
~~~

2. bori.html

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<svg width="300" height="300">

	<path d="M109,221 L141,207 L159,207 L191,221" fill="#B3774E"/>
	<path d="M109,221 L141,207 L159,207 L191,221" fill="#B3774E"/>
	<path d="M70,105 S-40,315 125,232" fill="#804820" stroke-width="1" stroke="black"/>
	<path d="M230,105 S340,315 175,232" fill="#804820" stroke-width="1" stroke="black"/>
	
	<path d="M69,140 L147,211 L153,211 L231,140" fill="#B3774E"/>
	<path d="M135,217 L165,217 L158,207 L142,207" fill="pink"/>
	<path d="M70,140 C50,13 250,13 230,140" fill="#B3774E" stroke-width="1" stroke="black"/>
	
	<path d="M70,140 C80,170 75,250 147,210" fill="#B3774E" stroke-width="1" stroke="black"/>	
	<path d="M230,140 C220,170 225,250 153,210" fill="#B3774E" stroke-width="1" stroke="black"/>
<!-- 	<rect x="75" y="182" width="150" height="38" fill="skyblue"/>  -->

	<path d="M110,221 C135,245 165,245 190,221" fill="#B3774E" stroke-width="1" stroke="black"/>  
    <path d="M78,181 C90,140 210,140 222,181" fill="none" stroke-width="1" stroke="black"/>
    
	<circle cx="120" cy="130" r="8" fill="black"/>
	<circle cx="180" cy="130" r="8" fill="black"/>

	<path d="M136,183 L164,183 L159,207 L141,207" fill="black"/>
	
	<path d="M137,183 S150,177 163,183" fill="black" stroke-width="1" stroke="black" />
	<path d="M137,183 S120,190 142,207" fill="black" stroke-width="1" stroke="black"/>
	<path d="M163,183 S180,190 158,207" fill="black" stroke-width="1" stroke="black"/>
	<path d="M142,207 S150,214 158,207" fill="black" stroke-width="1" stroke="black"/>
	
	
	<path d="M135,217 S150,227 165,217" fill="pink" stroke-width="1" stroke="black"/>
	
</svg>
</body>
</html>
~~~


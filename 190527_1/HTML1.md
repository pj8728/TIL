# HTML문

### 1.페이지 연결 / 이미지 출력

* h1 /h1 ~ h6 /h6 : 글씨 크기 조정 / href : 연결할 사이트 지정
* br : 행바꿈
* src : 이미지 받아올 때 쓰는 구문
* width / height : 가져올 이미지의 가로 / 세로 크기 조정

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>링크태그와 이미지태그</h1>
<hr>
<a href="http://www.w3.org/">W3C 홈페이지</a><br>
<a href="http://www.w3schools.com/">Web Client 기술 학습</a><br>
<a href="http://java.sun.com/"><img src="../images/java_duke.jpg"></a><br>
<img src="../images/totoro.png">
<img src="/edu/images/totoro.png" width="200">
<img src="http://localhost:8000/edu/images/totoro.png" width="100" height="300">
</body>
</html>
~~~

### 2.리스트 출력

* hr : 선 구분
* ul : li /li 에 써진 내용을 *로 구분
* ol : li /li 에 써진 내용을 1,2,3,... 로 구분
* dl / dt / dd : dl 내에 써진 dt / dd 는 제목 / 내용 개념

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 출력 태그</h1>
	<hr>
	<h2>좋아하는 컬러</h2>
	<ul>
		<li>녹색</li>
		<li>보라색</li>
		<li>주황색</li>
	</ul>
	<hr>
	<h2>좋아하는 음식</h2>
	<ol>
		<li>소고기</li>
		<li>처음처럼</li>
		<li>하늘보리</li>
	</ol>
	<hr>
	<dl>
    	<dt>자바</dt>
	<dd>플랫폼에 의존적이지 않은 OOP 언어</dd>
		<dt>HTML</dt>
	<dd>웹 페이지의 구조와 내용을 작성하는 마크업 언어</dd>
		<dt>CSS</dt>
	<dd>HTML 엘리먼트들이 브라우저에 랜더링될 때 스타일을 조정하는 언어</dd>
	</dl>
</body>
</html>
~~~

### 3.체크박스

* submit : 작성한 내용을 저장(?)하는 버튼
* reset : 작성한 내용을 초기화하는 버튼
* input type=" " : 적용하고자 하는 타입 작성
* 생성된 페이지에서 아무것도 작성하지 않고 전송하기를 누르면 주소가 바뀜

1. http://localhost:8000/edu/htmlexam/exam3.html 에서
2. stname=&stpwd=&stage=&stcolor=%23000000 가 붙음

* 컬러값은 초기값인 000000 , 검은색으로 지정됨
* checkbox : 중복체크 가능 / radio : 중복체크 불가

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 폼 학습</h1>
<hr>
<form>
  이름 <input type="text" name="stname" required><br>
  암호 <input type="password" name="stpwd"><br>
  나이 <input type="number" name="stage"><br>
  좋아하는 컬러 <input type="color" name="stcolor"><br>
  좋아하는 음식 <br>
	햄버거 <input type="checkbox" name="stfood">
	비지찌개 <input type="checkbox" name="stfood">
	회덮밥 <input type="checkbox" name="stfood">
	돈까스 <input type="checkbox" name="stfood"><br>
  성별<br>
	남성<input type="radio" name="gender" value="male">
	여성<input type="radio" name="gender" value="female"><br>
<input type="submit" value="전송하기">
<input type="reset" value="초기화하기">
</form>
</body>
</html>
~~~

### 4.실습 1

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보를 입력하십시오.</h1>
<hr>
<form>
<input id="name" name="name" type="text" required maxlength=4
placeholder="이름을 입력하세요"><br>

<input id="phone" name="phone" type="tel" required
placeholder="전화번호를 입력하세요"
pattern = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"><br>

<input id="email" name="email" type="email" required
placeholder="계정을 입력하세요"><br>

<input id="pw" name="pw" type="password" required
placeholder="패스워드를 입력하세요"><br>

<input type="submit" value="등록">
<input type="reset" value="재작성">

</form>
</body>
</html>
~~~

### 5. 실습 2

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글을 남겨 주세요</h1>
<hr>
<form>
이름 : <input id="name" name="name" type="text" required maxlength=4><br>
남기고자 하는 의견 : <br>
<textarea name="memo" rows="10" cols="40"></textarea><br>
<input type="submit" name="submit" value="등록">
<input type="reset" name="reset" value="재작성">
</form>
</body>
</html>
~~~

### 6.실습 3

* header / nav / section / article / figure / aside / footer 를 이용해 묶음
* header / nav : 머릿말과 그 내에 작성한 것
* section / article / figure : 섹션을 주고, 아티클로 나눠서 작성, figure로 첨언 및 첨부
  * 테이블 작성시 / tr : 1행 만듬 / th : 각 열의 이름 / td : 각 행,열위치의 내용 을 씀
  * border : 테이블의 테두리를 줌 
* aside : 동영상 올릴때 사용 , controls 와 id="player" 중요
* footer : 맺음말 등으로 마무리할때 쓰는듯 , i /i 는 글자 기울여서 출력

~~~html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header><h1>HTML5 학습</h1>
<nav>
<a href="www.w3.org">W3C</a>
<a href="www.w3schools.com">W3SCHOOLS</a>
<a href="www.jquery.com">jQuery</a>
</nav>
</header>
<section>
<article>
<h3>나의 소개</h3>
<ul>
<li>이름 : 박 건호</li>
<li>별명 : 도라이</li>
<li>관심기술 : Java</li>
<li>취미 : 숨쉬기</li>
</ul>
</article>
<article>
<h3>올해 재미있게 읽은 책</h3>
<table border="1">
<tr><th>제목</th><th>장르</th></tr>
<tr><td>용의자 X의 헌신</td><td>추리</td></tr>
<tr><td>연금술사</td><td>소설</td></tr>
<tr><td>숨결이 바람 될 때</td><td>에세이</td></tr>
</table>
</article>
<article>
<h3>자랑하고 싶은 우리 동네의 아름다운 곳</h3>
<h4>마곡 서울식물원</h4>
열린 숲,주제정원,온실,마곡문화관 등으로 이루어진 식물원으로 특히
온실에는 스카이워크도 있어서 관람에 좋다.<br>
2027년까지 식물 자체 연구 및 증식, 국내․외 교환과 기증 등을 통해
식물 8천 종 이상 보유를 목표로 운영하고 있다. <br><br>

<figure>
<img src="../images/DSC03390.jpg" width="600"><br>
<figcaption>마곡 서울식물원 온실 내부 사진</figcaption>
</figure>
</article>
</section>

<aside id="player">
<video src="mediaexam/trailer.mp4" controls>
</video>
</aside>

<footer>
<i>이 문서는 박 건호에 의해 HTML5와 CSS3 기술을
사용하여 2019년 5월 27일에 작성하였습니다.(ver 1.0)</i>
</footer>
</body>
</html>
~~~


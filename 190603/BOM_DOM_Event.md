### 1. BOM : Browser Object Model

* 브라우저가 제공하는 자바스크립트 API
* 미리 객체를 생성해서 제공
* window, location, document, history, screen, navigator

```html
id = setInterval(function, 초시간)
clearInterval(id)

id = setTimeout(function, 초시간)
clearTimeout(id)

alert(), confirm(), prompt(), open()

href - 속성
reload() - 현재 페이지 새로고침

go(), go(n)

user-agent, getLocation()

write() , writeIn()
```

==========================================================================

### 2. DOM : Document Object Model

* HTML 파서들은 파싱한 HTML 문서의 각각의 태그들, 태그의 속성들, 태그의 텍스트 형식의 컨텐트들 모두 자바스크립트 객체로 생성한다.
  --> 자바스크립트에서 접근 가능하도록 지원하기 위해
* document 객체의 자손 객체로 등록한다.
* document.body

```html
* document.getElementById("id속성값")
* document.getElementsByClassName("class속성값")
* document.getElementsByTagName("태그명")
document.getQuerySelector("CSS선택자")
document.getQuerySelectorAll("CSS선택자")
```
==========================================================================

### 3. 이벤트 핸들러 구현

* 이벤트 : 웹 페이지 상에서 발생되는 일
  (1) 브라우저에서 자동으로 발생(load)
  (2) 사용자의 액션에 의해서 발생
      (click, mouseover, mouseenter, mouseout, keyin, keypress, keyout, scroll, change, submit, 	reset 등등)
  
* 타겟 : 이벤트가 발생된 대상 객체

* 이벤트 핸들러(리스러) : 이벤트가 발생했을 때 수행되는 코드를 담고 있는 함수

* 이벤트 모델 : 특정한 타겟에서 정해진 이벤트가 발생했을 때 핸들러가 수행되도록 구현하는 방법
  (1) 인라인 이벤트 모델(지역)
  
  * 태그의 속성으로 등록
  * onXXX = "코드"
  * onclick(onClick,onCLICK) = "수행문장1;수행문장2;수행문장3"
  
  (2) 고전 이벤트 모델(전역)
  
  * DOM 객체를 찾는다.
  * DOM객체.onxxx (xxx 부분은 모두 소문자) = 함수; 
  * 함수 부분에 null 값을 넣으면 제거
  
  (3) 표준 이벤트 모델(전역)
  
  * DOM 객체를 찾는다.
  * DOM객체.addEventListener("xxx",함수)
  * removeEventListener 를 사용하면 제거

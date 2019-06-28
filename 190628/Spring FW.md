# Spring FW

* 소스 코드의 코딩량을 줄여주고 유지 보수성이 좋은 프로그램을 개발
* 웹 서버 프로그래밍 - Spring MVC / Spring IoC(Spring DI)
* Eclips EE = Eclipse for Java Developer + WTP + STS 추가 설치



## 추가 라이브러리 준비하는 방법

1. 해당 라이브러리 압축파일(xxx.jar)을 사이트에서 다운로드하여 정해진 디렉토리에 저장하거나 패스 설정을 한다.
2.  추가로 설치하려는 라이브러들을 관리해주는 툴(빌드 툴)
      - 메이븐, 그래들....(pom.xml)

* autowired="byType"  : setter
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생
  (3) 없으면 null 주입

*  autowired="byName"  : setter
  (1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입
  (2) 없으면 null 주입

* autowired="constructor"  : constructor
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 매개변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 null 주입

* 필드에 설정된 @Autowired - Spring FW 전용
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 NoSuchBeanDefinitionException 발생
       (required = false 속성을 사용하여 없으면 null 이 되게 지정 가능)
  (4) @Qualifier(value="xxx")를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

* 필드에 설정된 @Resource - Java
  (1) 변수명과 동일한 id 값을 갖는 빈을 찾아서 해당 객체 주입
  (2) 타입으로 찾아서 1개이면 객체 주입
  (3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
  (4) 없으면 NoSuchBeanDefinitionException 발생



### 프레임워크(framework) - 1998, 2004~2006

- 스마트 라이브러리 (라이브러리 + 디스크립터 파일(XML))
- EJB(Java+XML), Servlet, Struts, iBatis(MyBatis), Spring, Spring MVC
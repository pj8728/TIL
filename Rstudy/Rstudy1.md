## R study 1

1. R 언어의 구문

   * 데이터 타입의 종류
   * 데이터셋의 종류(벡터 , 매트릭스 , 배열 , 데이터프레임 , 리스트)
   * 연산자
   * 제어문(if , stwitch() , for , while , repeat , break , next)
   * 함수(정의 , 호출)

2. R 의 자료형

   * 문자형(character) : 문자 , 문자열
   * 수치형(numeric) : 정수(integer) , 실수(double)
   * 복소수형(complex) : 실수 + 허수
   * 논리형(logical) : 참 , 거짓 

3. R의 리터럴

   * 문자형 리터럴 : "xxx" , 'xxx' , "" , '' , '123' , "abc"
   * 수치형 리터럴 : 100 , 3.14 , 0
   * 논리형 리터럴 : TRUE(T) , FALSE(F)
   * NULL(데이터 셋이 비어있음) / NA(데이터 셋 내부 결측치) / NaN(not a number : 숫자가 아님)
   * Inf(무한대 값)

4. 타입 체크

   * is.~~ -> TRUE , FALSE 형식으로 반환됨
   * 자동 형 변환 룰 : 문자형 -> 복소수형 -> 수치형 -> 논리형
   * as.~~ -> 강제 형변환 함수
   * class(x) , str(x) , mode(x) : 자료형 확인 함수
     ex) x <- c(num1 : num2) 형식일 때 class : integer , mode : numeric , str : int [1:length(x)] (x의 내용들)
           x <- c(num1 , num2) 형식일 때 class : numeric , mode : numeric , str : num[1:length(x)] (x의 내용들)

5. R의 데이터 셋

   * 벡터(vector) 

     1) R의 가장 기초 데이터셋 , 1차원으로 사용

     2) 하나의 데이터 값도 벡터취급

     3) 동일 타입 데이터로만 구성(문자형 > 수치형 > 논리형)

     4) 생성 방법 : c() , seq() , rep() , : 연산자

     5) 내장 상수 벡터 : LETTERS , letters , month , name , month.abb , pi

     6) 인덱싱 : 1부터 시작하는 인덱스값과 [인덱스] 연산자 사용

   * 팩터(factor)

     1) 가능한 범주 값(level) 만으로 구성됨

     2) 생성 방법 : factor(벡터) , factor(벡터, levels=레벨벡터) , factor(벡터, levels=레벨벡터, ordered = TRUE)

     3) 레벨 정보 추출 : levels(팩터변수)

   * 행렬(matrix)

     1) 2차원 벡터 / 동일 타입 데이터만 저장 가능

     2) 인덱싱 : [행 인덱싱,열 인덱싱] , [행 인덱싱 , ] , [ , 열 인덱싱]

     3) drop 속성 : 행렬 구조 유지 여부

     4) 생성 방법 : matrix(data=벡터 , nrow=행의 갯수 , ncol=열의 갯수)

     ​					  matrix(data=벡터 , nrow=행의 갯수 , ncol=열의 갯수 , byrow=TRUE)

     ​					  rbind(벡터들) , cbind(벡터들)

     ​					  dim(m) <---- 행렬의 차원 체크

     5) 행렬 정보에 대해 알아볼 때 쓰는 구문

     * nrow(행렬) , ncol(행렬) : 행렬의 행 / 열 갯수
     * colnames(m) , rownames(m) : 행렬의 행이름 / 열이름
     * rowSums(m) , colSums(m) : 행렬의 행 합 / 열 합
     * rowMeans(m) , colMeans(m) : 행렬의 행 평균 / 열 평균
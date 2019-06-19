## 파일 업로드

* 클라이어트에서 서버에게 요청을 보낼 때 name=value 로 구성된 쿼리 문자열을 전달할 수 있다.
  (영문,숫자,일부 특수문자는 그대로 전달, 나머지는 인코딩)
* name=value&name=value
* application/x-www-form-urlencoded
* 서버에게 전달하는 데이터에 클라이언트에 존재하는 파일을 첨부해서 요청하려는 경우에는 다른 형식으로 전달해야 한다.
* multipart/form-data
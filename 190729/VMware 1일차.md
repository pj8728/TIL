##  VMware  1일차

c:\CentOS\linuxM

호스트 이름 : linuxserver

암호 : password

centos,centos

/root  ---> 로그인 했을 때 최초로 존재하게 되는 디렉토리 : 홈 디렉토리



cd etc    ///   cd /etc



1. jdk 1.8

* /etc : 시스템 정보와 관련된 파일듯

* /usr : jdk 와 같은 개발 툴을 보관하는 디렉토리

* /tmp : 여러 목적의 임시 폴더와 파일들이 생성되는 디렉토리

* mv old파일명 new파일명 --> 파일명 변경

* mv old파일명 디렉토리 --> 이동

* makid / rmdir

* export JAVA_HOME=/usr/jdk1.8.0_131

* export PATH=$JAVA_HOME/bin:$PATH

* vi(visual editor)

  1. 두가지 모드가 존재함

     * 1) 입력 모드 : 입력되는 문자를 입력 데이터로 인식

     * 2) 명령 모드 : 입력되는 문자를 편집 명령어로 인식

     * ex) 입력 모드 x : 그냥 x // 명령 모드 x : 삭제

     * ex) 입력 모드 dd : 그냥 dd // 명령 모드 dd : 한 행 삭제

  2. 편집 명령어가 알파벳 문자다.

  3. 초기에는 명령모드 / 입력모드로 변환하려면 a,i,o 문자를 입력

  4. 입력 모드에서 명령 모드로 변환하기 위해서는 ESC 키를 누른다.

  5. 저장 - :w , 종료 - :q , 강제종료 - :q!
### VMware 2일차

1. VM 가상머신 생성

2. CentOS 7 설치( root/password , centos/centos )

3. jdk 1.8 - (/etc/profile : 전역적 환경 설정 파일) : JAVA_HOME , PATH

4. eclipse EE (오라클 서비스 중단)

5. 리눅스 명령어

   * 리눅스 OS의 구조 : 커널 - 쉘 - 애플리케이션(리눅스 명령어, 프로그램 등)

   * pwd : print working directory - 현재 위치한 디렉토리 출력 - 홈디렉토리

   * ls : 디렉토리의 파일 리스트, ls -a, ls-l, ls -al, ls 디렉토리 정보

   * cd : 현재 디렉토리를 이동할때 사용
           cd 절대패스 , cd 상대패스 /////// cd - 무조건 홈 디렉토리로 이동
           cd /tmp, cd /etc/sysconfig
           cd tools(cd ./tools) , cd ../../tmp
           cd, cd /root , cd ../../../root

   * cp : 파일 복사, cp old파일 new파일 , cp old파일 디렉토리
           cp FirstApp.java ThridApp.java
           cp FirstApp.java /tmp
           cp FirstApp.java /tmp/New.java
           cp tools /tmp
           cp -r tools /tmp

   * mv : 파일 이동, 파일명 변경
           mv old파일 new파일
           mv old파일 디렉토리명
           mv old파일 디렉토리명/new파일명

   * mkdir : 새로운 디렉터리 생성 / rmdir : 기존 디렉터리 삭제(비어있어야 가능)

   * rm : 파일 삭제
           rm -r 디렉토리, rm -f 파일명

   * tar : 아카이브(꾸러미) 생성, 풀기, 리스트 보기
           tar cvf 아카이브파일명 파일리스트...
           tar xvf 아카이브파일명
           tar tvf 아카이브파일명
           tar cvf myApp.tar *.class -> *은 all의 의미 / 모든 class 를 myApp.tar 로 묶는다
           tar cvf tools.tar tools -> tools 에 있는 모든 것을 tools.tar 로 묶는다
           gzip myApp.tar -> gzip 이 myApp.tar를 압축해 myApp.tar.gz 로 만든다
           gzip -d myApp.tar.gz -> gzip 을 압축을 풀어 myApp.tar 를 생성한다.

   * vi : visual editor : (ed 에디터)
          명령모드, 입력모드
           x : 커서 위치의 문자 하나를 지움 / nx : 커서 위치에서부터 n개의 문자를 지움
           dd : 커서 위치의 한 행을 지움 / ndd : 커서 위치에서부터 n행을 지움
           yy : 커서 위치의 한 행을 복사 / nyy : 커서 위치에서부터 n행을 복사
           p : 커서 위치의 아래 행에 붙이기
           dw : 커서 위치의 단어를 삭제
           명령모드에서 입력모드로 들어가는 명령 : a(커서 위) , i(커서에서) , o(커서 아래)
           입력모드에서 명령모드로 나가는 키 : Esc

     ​      u : undo, . - redo
     ​      :set nu - 행넘버
     ​      /찾을단어 - 단어 찾기, n - forward 방향으로 다음
     ​                                          N 또는 b - forward 방향으로 다음
     ​      :s/old단어/new단어

     

     [종료 명령어]
     저장하고 종료 - :wq
     저장하지 않고 종료 - :q, :q! 
     저장만 - :w

   

   6. 파일 내용 체크 : cat , head , tail , more

   * cat : 여러 개 파일을 나열하면 파일을 연결해서 보여준다
   
   - head : 텍스트 형식으로 작성된 파일의 앞 10행
   - tail : 텍스트 형식으로 작성된 파일의 뒤에서 10행
   - more : 텍스트 형식으로 작성된 파일을 페이지 단위로 화면에 출력 
     - space를 누르면 다음 페이지
     - B를 누르면 앞 페이지로 이동
     - q를 누르면 종료
   
   - 파일의 내용을 출력하거나 편집기로 오픈하지 않고도 체크 
     - grep 찾으려는단어 파일명
       - ex) grep unico *.txt(파일안에 unico라는 단어 체크)
   - 파일 시스템에서 어떤  명칭의 파일이 어디 있는지 체크
     - find 폴더명 -name 파일명
       - ex) find / -name test.java
       - ex) find /tmp -name test.java
       - ex) find tools -name test.java
       - ex) find dir1/dir2 -name test.java
   - *>* , >>, | 
     - *>* : 앞에 오는 명령어를 읽는걸 뒤에 파일 형식으로 만든다?(파일이 원래 있으면 지우고 내용을 덮음)
       - ex) cat Test.java > Output.java
       - ex) ls -al > list.txt 
     - *>*> : *>*와 다르게 파일이 있어도 지우지않고 밑에 복사해서 넣는다.
     - |(파이프기호, 스트림방식) : 앞에 명령어의 내용을 다음 명령어의 내용으로 보내라
       - ex) ls -al | more : ls -al의 내용을 다음 more로 보내 내용을 보여준다.
       - ex) ls -al | wc -l
       - ex) 명령1 | 명령2 | 명령3 ... : 여러개 이어서 사용가능
   
   1. WINDOWS : 단일 사용자
   2. LINUX(UNIX) : 다중 사용자
   3. ps - process status(현재 수행중인 프로그램)
   4. kill -9 pid 
   5. ls -al -----> ps -ef 
   6. 생성되는 모든 파일과 디렉토리는 사용자 허가모드가 정해져 있다
   7. 사용자 허가모드 : 읽기, 쓰기, 실행
      - 읽기 : r
      - 쓰기 : w
      - 실행 : x
      - ex) cd /tmp
   
   
   
   14. JDK 1.8 
       - /etc : 시스템 정보와 관련된 파일들
       - /usr : JDK 와 같은 개발 툴을 보관하는 디렉토리
       - /tmp : 여러 목적의 임시 폴더와 파일들이 생성되는 디렉토리
       - /dev : 리눅스에서 관리되는 장치들에 대한 파일을 보관하는 디렉토리
   
   
   
   15. su : 임시로 새로운 유저로 이동하는 기능
   
   16. chmod 허가모드스펙 대상파일명 : 사용자허가 변경 기능
   
       rwxrwxrwx
   
       1
   
       0
   
       110100100  644  rw-r--r--
   
       110110100  644  rw-rw-r--
   
       110110100  666  rw-rw-rw-
   
       111111111  777   rwxrwxrwx
   
       g+rw
   
       a+rwx
   
       o+r
   
       000  0
   
       001  1
   
       010  2
   
       011  3
   
       100  4
   
       101  5
   
       110  6
   
       111  7

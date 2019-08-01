## VMware 4일차

* 데몬 프로세스(daemon process) : 백그라운드에서 수행중인 프로그램(httpd,pop3d 등 ~~~d 형식)
* start-dfs.sh -> master : NameNode , slave1 : SecondaryNameNode / DataNode
                         , slave2와 slave3 : DataNode
* ps -ef -> jps(JVM Process Status)
* HDFS : 저장소

cd 
mkdir sampledata

sampledata 폴더에 강사가 제공한 데이터 파일 3 개를 복사한다.

  hdfs  dfs  -ls  /
  hdfs  dfs  -mkdir  /edudata
  hdfs  dfs  -ls  /
  hdfs  dfs  -chmod  777  /edudata
  hdfs  dfs  -put  /root/sampledata/파일명   /edudata   --> 3번
  hdfs  dfs  -ls  /edudata





  master 머신에서

  [ master 머신에서 작업 ]

  (1) tools 폴더에 리눅스용 eclipse 를 복사한다.
  (2) 압축을 풀고 압축해제된 eclipse 폴더를 홈디렉토리로 옮긴다.
  (3) eclipse를 기동한다.
  (4) hadoopexam 이라는 JavaProject을 생성한다.
  (5) 내이름을 출력하는 FirstApp.java 소스를 만들어 실행까지 시켜본다.

  - 이클립스 종료, 하둡 종료
  - 마스터 머신만 셧다운
  - m1 가상머신의 메모리를 4G 올리고 마스터를 재기동한다.
  - root 로 로그인하여 하둡의 HDFS를 재기동한다.
  - 데몬들이 제대로 기동됐는지 확인한다.
  - 이클립스를 기동시킨다.

  - /edudata/product_click.log 를 삭제한다.
  
  - HDFSExam  /edudata/sample.txt  가나다
  - 터미널 sample.txt 생성되었는지 리스트 확인, 내용 확인

  conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
  conf.addResource(new Path("/root/hadoop-2.7.7/etc/hadoop/core-site.xml"));

  HadoopPJ 프로젝폴더가 있음
  복사해서 윈도우즈의 이클립스를 기동하여
  import 시킨다. 예제들을 테스트 해본다.
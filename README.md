
* [01 개발 환경설정]
* [03 REST API]
* [04 Lombok-JPA CRUD]
* [06 어드민 프로젝트 시작]
* [06 어드민 프로젝트 연관관계 설정]
* [07 CRUD 인터페이스 정의와 ResponseBody 공통부 작성]
* [08 사용자 API]
* [08 상품 API]
* [08 주문내역 API]
* [09 JPA ENUM]
* [09 추상화적용하기]
* [10 샘플데이터 생성하기]
* [11 페이징처리]
* [12 화면처리하기]

<br>

#### 사용 Spec
* OS
 - MAC

* IDE
 - IntelliJ Ultimate

* Java 
  - 15 [Link](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
  
* Spring Boot
  - 2.3.4
  
* Lombok

* DB
 - MySQL

* JPA ( Hibernate )
* DI 부분 Autowired -> 생성자 주입 패턴으로 변경 
<br><br>


#### 부분 변경점 ( 기존대로 진행 하셔도 무방 합니다.)
  - application.properties 설정에서  => application.yaml 설정으로 변경 합니다.
  - application package가 com.example.study => com.fastcampus.java로 변경 합니다.
  - mySQL 설치 대신 docker 사용자들을 위한 docker-compose.yaml 제공
  

#### 변경된 프로젝트 생성 방법
* JDK 설치는 기존과 동일합니다. 버전만 11 버전으로 설치 하시면 됩니다. [Link](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) <br>

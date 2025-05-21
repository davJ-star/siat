# docker

## 명령어



docker로 시작한다. (client랑 server로 구성되어있다.)
*container를 만들고 image를 만들어 담는것 기준*
(옵션중에서 -는 약어 --는 풀네임)

```
[명령어]
docker로 시작한다. (client랑 server로 구성되어있다.) container를 만들고 image를 만들어 담는것 기준 (옵션중에서 -는 약어 --는 풀네임)

version

info

--help
	Common Commands:
	Management Commands:
	Swarm Commands:

컨테이너 실행(이미지를 이용)
run (실행옵션) 이미지명
	실행옵션: portfowarding등...
		-> 사용자가 실행할때 port를 80 80으로 하고, image 실행할때 8088 port로 실행하고자 할때.	
	docker run -p 80:80 --name siatngnix nginx
			마지막에 ngnix를 하면 자동으로 처리해준다.
	docker run -d -p 80:80 --name siatngnix nginx
			-d는 백그라운딩 옵션(background demon)


docker run -d --name siat01 nginx
		-d는 백그라운딩 옵션(background demon)
docker run -d --name siat02 nginx
		-d는 백그라운딩 옵션(background demon)

docker run -d --name siat03 nginx
		-d는 백그라운딩 옵션(background demon)



docker image ls


컨테이너 삭제(IMAGE ID, )
rm 
rm siatngnix -> 이미지를 삭제하는게아니라 컨테이너 삭제.
rm siatngnix -f -> 실행중인 컨테이너 삭제

rm siatngnix -f siat01 siat02 siat03



docker image inspect nginx
"Env": [ "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/b in", "NGINX_VERSION=1.27.5", "NJS_VERSION=0.8.10", "NJS_RELEASE=1bookworm", "PKG_RELEASE=1bookworm", "DYNPKG_RELEASE=1~bookworm" ], "Cmd": [ "nginx", "-g", "daemon off;" ],

컨테이너의 메타데이터 복사(컨테이너 생성시)
docker run -d --name defaultNginx nginx
docker container inspect defaultNginx

<메타데이터로 수정하는 방법> docker run --name customNginx nginx cat usr/share/nginx/html/index.html

(참고: usr/share/nginx/html/index.html는 welcom page임.)
[실행 시점에 컨테이너의 메타데이터는 수정할 수 있다.]
(사용자가 치는 포트는 이거지만 외부 사용하는 건 내부적으로 해당 포트로 실행시키겠다. port fowarding)
docker run -d -p 8081:3000 --name redContainer devwikirepo/envnodecolorapp
docker run -d -p 8082:3000 --name blueContainer --env COLOR=blue devwikirepo/envnodecolorapp
inspect를 해본다.
- docker container inspect redContainer 
- docker container inspect blueContainer 

[pull, push]
- docker pull devwikirepo/simple-web:lastest(또는 구체적 버전)
	이미지 태그 변경: tag -> docker tag devwikirepo/simple-web:1.0 seongwookjeong/myapp:0.1
	이미지를 내려받으면서 
			- 이미지 명 변경 가능
			- 바로 실행

docker run -d -p 80:80 --name local-simple-app seongwookjeong/myapp:0.1





- docker push seongwookjeong/myapp:0.1



docker ps
	-a



>> 허브로부터 db 이미지를 가져오고 환경설정
1. docker pull mariadb


docker image history mariadb
2. docker image ls
(docker run -p 3306:3306 --name mariaContainer mariadb -d -e MARIADB_ROOT_PASSWORD=123456789 mariadb)
docker run -d --name mariaContainer -e MARIADB_ROOT_PASSWORD=123456789 -p 3306:3306 mariadb
원격 디비 접속
3. docker exec -it mariaContainer mariadb -uroot -p

4. database 만들기
create database devops;

docker을 토대로 자동화

-------------------------------------
(4.5 jar 패킹)
./gradlew bootJar
(나중에는 git action workflow에 들어간다.)


>> 로컬에 이미지 생성.
5. docker build -t siat-spring-backend .

5. docker build -t seongwookjeong/siat-spring-backend .


>> 실행중인 컨테이너를 이미지로 생성하는 방법
docker commit -m dbcommit mariaContainer seongwookjeong/siat-mariadb

-- 컨테이너 실행
docker run -d -p 8087:8088 --name beContainer siat-spring-backend




```
컨테이너의 메타데이터 복사(컨테이너 생성시)
docker run -d --name defaultNginx nginx
```
docker container inspect defaultNginx 





<메타데이터로 수정하는 방법>
docker run --name customNginx nginx cat usr/share/nginx/html/index.html
```
(참고: usr/share/nginx/html/index.html는 welcom page임.)
[실행 시점에 컨테이너의 메타데이터는 수정할 수 있다.]
(사용자가 치는 포트는 이거지만 외부 사용하는 건 내부적으로 해당 포트로 실행시키겠다. port fowarding)
```
	docker run -d -p 8081:3000 --name redContainer devwikirepo/envnodecolorapp
	docker run -d -p 8082:3000 --name blueContainer --env COLOR=blue devwikirepo/envnodecolorapp
```
inspect를 해본다.
- docker container inspect redContainer 
- docker container inspect blueContainer 

[pull, push]
- docker pull devwikirepo/simple-web:lastest(또는 구체적 버전)
	이미지 태그 변경: tag -> docker tag devwikirepo/simple-web:1.0 seongwookjeong/myapp:0.1
	이미지를 내려받으면서 
			- 이미지 명 변경 가능
			- 바로 실행

```
	docker run -d -p 80:80 --name local-simple-app seongwookjeong/myapp:0.1
```


```
	
```



- docker push seongwookjeong/myapp:0.1



docker ps
	-a


```


## [5.19]()
```
devops
(아키텍처 == 엔지니어)

ci / cd



1. 클라우드 마이그레이션
클라우드 환경으로 이주(처음부터 클라우드 환경에서 인프라 구축하기도함)



2. 피크 트래픽 핸들링 스케일 아웃
when? : 서비스를 이용하는 사용자가 급증
why? : 서버가 터지는 상황 발생 x하고 정상 수행

3. 데이터 파이프라인
what? : 절차에 따라 반복되는 것을 자동화
- 데이터, 리소스를 전달하는 구조만드는 것.

4 / 5

6. 코드를 통한 인프라 관리
IaC...

----------------------------------------------------------
devops

애플리케이션과 서비스를 바르게 제공하기 위해
파이프라인: [소스코드 -> 배포환경 관리] 자동화

 java랑 build된 .jar를 배포


section1. Devops 애플리케이션 서버
- 베어메탈(직접 물리적 서버에 세팅)

---논리적---
- 하이퍼바이저(vmware)
- 컨테이너(docker)


나눠서 써보자~!


하이퍼바이저(vmware) -> Host OS(물리적 서버의 os)
	가상화 기술을 사용해 격리된 환경에서 프로세스 실행
	프로세스 실행되면 host os에 리소스 요청하고, kernel이 system call을 요청해서 서버에 접근하고 시스템 할당을 해준다.

*kernel을 가지고 있다. 이게 다른 문제가 발생하게 된다.*

host os위에 hypervisor를 올려두면서 가상화를 진행한다.(이 기종 커널 간 요청 전달 -> 가상 머신 리소스 자원 관리)


-------------도커(컨테이너 가상화)----------------
spring boot	: java파일 -> jar로 빌드 
react		: index.html랑 스크립트


docker hub -> docker image pull 또는 그냥 그대로 실행


hypervisor 대신 모든 container가 하나의 kernel을 공유하기 대문에 적은 오버헤드로 처리가능

-------컨테이너엔진과 컨테이너런타임-------
pipeline을 만들고 실행될 수 있도록 한다.



db를 이미지로 가지면 로컬에 없어도 pull 해서 실행 시킬수 있다.
그렇게 실행시키면 어디서든지 사용할 수 있다.
(이미지가 없으면 docker hub에 이미지를 pull)
(docker hub에 push해놓기.)


ngnix는 중간 서버로 받아들이면 된다. MSA 방식으로 사용된다. (모아서 백엔드에 전달하기 위함)



Nginx 서버 -> 이미지 -> docker run nginx

프로그램: 
- 프로세스

이미지 : 실행가능한 소프트웨어 + 실행에 필요한 환경(디스크 공간 차지)
		-> 메타데이터: docker file
			- cmd 명령어
- 컨테이너 => 1:n






이미지가 있다는건 컨테이너를 통해서 실행 시킬 수 있는 재료가 있다는 것.
(이때 컨테이너 메타데이터를 건드릴수있다.)





docker hub 이미지 저장소
레지스트리주소/프로젝트명/이미지명:태그
-----------------------------------------
이미지 레이어는 수정못하지만, 컨테이너 레이어는 수정이 가능하다. 그래서 실행할때 컨테이너 레이어를 토대로 실행한다.
하지만, 이러한 쉬운일이 아니기 때문에 커밋/빌드 방식을 토대로 이미지를 만든다.


커밋: 현재 컨테이너의 상태를 이미지로 저장
*빌드*: Dockerfile(메타데이터)을 통해 이미지를 저장

------------------------------------------
devops-app: 
	frontend, backend 폴더를 만든다. 
	각 해당하는 docker-file을 생성하고, docker-compose로 배포한다.

```





# 5.20

```

-- dokcer 쓰는 이유

서버 관리 비용 및 인프라(cost upup!) --> cloud로 서버 임대
cloud등장하게되면서, 가상화 등장
-------------------------------------------------------
aws
	 [endpoint제공] - portforwarding(인바운딩, 아웃바운딩)
	- 프론트: bucket(s3) -> 
	- 백엔드: ec2 -> 
	- 데이터베이스: db ->



-------------------------------------------------------
hypervisor vs container

container 대표적인 건 docker
image -> 실행 환경 + 코드

commit
vs
"build: dockerfile을 만들고 이미지 생성."
-------------------------------------------------------
git flow: ci -> /cd -> 


- 컨테이너 실행(이미지를 이용): run (실행옵션) 이미지명
- 컨테이너 삭제(IMAGE ID, )
- [pull, push]
	- tag
	- 

- ㅇ
- ㅇ

-------------------------------------------------------

frontend: 이미지 -> dockerfile
backend: 이미지 -> dockerfile
	- db: 이미지 같이 만들어야함.

기본은 3개 이미지

1개로 묶어서 쓰는경우 docker-compose(.yaml)을 사용하면 된다. -> 설정을 담아버린다.
**docker-compose.yaml은 이미지 하나로 합칠때 사용한다**

-------------------------------------------------------
application.yaml에 대한 설정은 내로컬에 따른 db 설정이므로, cloud 환경에 따른 db 설정이 필요.


-------------------------------------------------------
.env -> github token에 등록하고 가져다가 써야한다.







[배포시 진행]
docker-compose을 세팅할때 해당 디렉토리를 잡아서 sql 실행될 수 있도록한다.
원격에 있는 db에 sql파일이 실행되도록 하면된다.
 테이블 스키마 만들어주기 / insert로 더미데이터를 넣기



실행가능한 애플리케이션 메타데이터 만들기.
frontend 
backend
	```
		명확한 문서를 만들기위해 엔드포인트를 항상 앞에 api/
	```



실행가능한 애플리케이션 메타데이터 만들기-> 백엔드 + db 이미지로 만들꺼면 해당 디렉토리내에서 docker-compose.yaml을 만들어서 세팅 구축해야함.
도커파일은 frontend나 backend를 만들던 루트 아래에 있어야한다.


------------------------------------
토큰이 필요한 것은 filter를 타고 가도록등.. 정책이 필요하다.
-> 엔드포인트를 만들때도 규칙을 만든다.



docker-compose는 이미지를 땡긴다는 느낌.
docker build를 통해 이미지를 변경되고 끄면 db 생성되고 삭제되고를 반복하게 되며 영속성 x
--> volumes에 저장해야한다.


로컬에 db가 만들어지지 않아도 docker hub에 이미지를 pull해서 local에 db를 사용할 수 있다.
이미지에 layer 담아서 실행.

>> 허브로부터 db 이미지를 가져오고 환경설정
1. docker pull mariadb

docker image history mariadb
2. docker image ls

docker run -p 3306:3306 --name mariaContainer mariadb -d -e MARIADB_ROOT_PASSWORD=123456789 mariadb


원격 디비 접속
3. docker exec -it mariaContainer mariadb -uroot -p

4. database 만들기
create database devops;

docker을 토대로 자동화

>> 로컬에 이미지 생성.
5. docker build -t siat-spring-backend .
------------------------------------



------------------------------------
```
Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class

```
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)로 대처







 jdk17 slim -> 라이센스가 없으니 openjdk17를 더해준다.
초경량: alpine -> 



------------최종적으로 만든 JAVA 파일을 패킹하는 작업 명령어--------------
./gradlew bootJAR

snapshot -> 공유할 수 있는 파일에 해당 이름을 붙인다.
(docker )
```

# 5.21
```
복습

(**나중에는 git action workflow에 들어간다.**)
.war vs .jar
jar 파일로 패킹

from
copy
arg

entrypoint

------------------------------------
docker-compse.yaml를 만들면 이미지 만들지 않아도 된다.
mariadb랑 siat-spring-backend
메타데이터이므로 


백엔드는 db 의존성을 가져야한다. 
```yaml
  database: 
    image: mariadb:11.4.5 # 도커허브로 이미지를 내려받는다. 또는 우리가 어제 만든 이미지를 줘도된다.

```
application.yaml vs docker-compse.yaml은 로컬 vs 원격
------------------------------------

<db 생성>
디렉토리가 정해야져야한다. volumes에 의해서 db 생성되고 

SPRING -> application.yaml의 spring 의미.
```
spring:
    # mariadb db
    datasource:
```

그렇기 때문에 만약에 JPA 사용한다면 SPRING_JPA~


.env 만들면, 실행될때 자동으로 실행되므로, 세팅하면된다.


<만들어진 db를 실행하고 서버구동>
병렬처리시 시차가 생길수있어서 restart 옵션 제공

docker-compose에서도 이미지가 실행되어야한다.
-----> **container 안에서 실행되는건 기존 ports랑 동일해야한다.**


docker file로 만들어진 java파일을 써야한다.
(mariadb도 내려받은게있다.이를 이용)

-------------------------------------------------------------------------
docker-compose: muti stage로 관리하는 도구

docker compose up을 해서 한번에 이미지를 컨테이너에 올림(docker-compose.yaml이 있어야함)
docker compose up -d
docker compose down




도커허브로 이미지를 내려받기 때문에 이미지가 필요함. -> backend 이미지 필요.


docker tag siat-spring-backend seongwookjeong/siat-spring-backend

docker tag mariadb seongwookjeong/mariadb


docker push seongwookjeong/siat-spring-backend
(docker push seongwookjeong/mariadb)
docker push seongwookjeong/siat-mariadb


---------실행되고 있는 컨테이너를 올려야한다-----


-----------------------------------------------------

(**나중에는 git action workflow에 들어간다.**)


build전에 jar 패킹하는 작업이 필요하다.


```
backend-spring-container  | 
backend-spring-container  |   .   ____          _            __ _ _
backend-spring-container  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
backend-spring-container  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
backend-spring-container  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
backend-spring-container  |   '  |____| .__|_| |_|_| |_\__, | / / / /
backend-spring-container  |  =========|_|==============|___/=/_/_/_/
backend-spring-container  | 
backend-spring-container  |  :: Spring Boot ::               (v3.3.11)
backend-spring-container  | 
backend-maria-container   | 2025-05-21 05:30:51+00:00 [Note] [Entrypoint]: MariaDB upgrade not required
backend-spring-container  | 2025-05-21T05:30:51.013Z  INFO 1 --- [           main] com.example.backend.BackendApplication   : Starting BackendApplication v0.0.1-SNAPSHOT using Java 17.0.15 with PID 1 (/backend.jar started by root in /)
backend-spring-container  | 2025-05-21T05:30:51.020Z  INFO 1 --- [           main] com.example.backend.BackendApplication   : No active profile set, falling back to 
1 default profile: "default"
backend-maria-container   | 2025-05-21  5:30:51 0 [Note] Starting MariaDB 11.7.2-MariaDB-ubu2404 source revision 80067a69feaeb5df30abb1bfaf7d4e713ccbf027 server_uid 
hMMzmhT1BYIa3O8hmMYSxMLOW9M= as process 1
```

```
backend-spring-container  | 
backend-spring-container  |   .   ____          _            __ _ _
backend-spring-container  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
backend-spring-container  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
backend-spring-container  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
backend-spring-container  |   '  |____| .__|_| |_|_| |_\__, | / / / /
backend-spring-container  |  =========|_|==============|___/=/_/_/_/
backend-spring-container  | 
backend-spring-container  |  :: Spring Boot ::               (v3.3.11)
backend-spring-container  | 
backend-maria-container   | 2025-05-21 05:30:51+00:00 [Note] [Entrypoint]: MariaDB upgrade not required
backend-spring-container  | 2025-05-21T05:30:51.013Z  INFO 1 --- [           main] com.example.backend.BackendApplication   : Starting BackendApplication v0.0.1-SNAPSHOT using Java 17.0.15 with PID 1 (/backend.jar started by root in /)
backend-spring-container  | 2025-05-21T05:30:51.020Z  INFO 1 --- [           main] com.example.backend.BackendApplication   : No active profile set, falling back to 
1 default profile: "default"
backend-maria-container   | 2025-05-21  5:30:51 0 [Note] Starting MariaDB 11.7.2-MariaDB-ubu2404 source revision 80067a69feaeb5df30abb1bfaf7d4e713ccbf027 server_uid 
hMMzmhT1BYIa3O8hmMYSxMLOW9M= as process 1
```


```















## [5.20]()

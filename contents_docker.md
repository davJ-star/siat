# docker

## 명령어



docker로 시작한다. (client랑 server로 구성되어있다.)
*container를 만들고 image를 만들어 담는것 기준*
(옵션중에서 -는 약어 --는 풀네임)

```
version

info

--help
	Common Commands:
	Management Commands:
	Swarm Commands:

컨테이너 실행(이미지를 이용)
run (실행옵션) 이미지명
	실행옵션: portfowarding등...
		-> 사용자가 실행할때 port를 8080으로 하고, image 실행할때 8088 port로 실행하고자 할때.	
	docker run -p 80:80 --name siatngnix nginx
			마지막에 ngnix를 하면 자동으로 처리해준다.
	docker run -d -p 80:80 --name siatngnix nginx
			-d는 백그라운딩 옵션(background demon)


```
	docker run -d --name siat01 nginx
			-d는 백그라운딩 옵션(background demon)
	docker run -d --name siat02 nginx
			-d는 백그라운딩 옵션(background demon)

	docker run -d --name siat03 nginx
			-d는 백그라운딩 옵션(background demon)

		
	
```



docker image ls


컨테이너 삭제(IMAGE ID, )
rm 
rm siatngnix -> 이미지를 삭제하는게아니라 컨테이너 삭제.
rm siatngnix -f -> 실행중인 컨테이너 삭제

```
	rm siatngnix -f siat01 siat02 siat03
```



docker image inspect nginx
```
 "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/b
in",
                "NGINX_VERSION=1.27.5",
                "NJS_VERSION=0.8.10",
                "NJS_RELEASE=1~bookworm",
                "PKG_RELEASE=1~bookworm",
                "DYNPKG_RELEASE=1~bookworm"
            ],
            "Cmd": [
                "nginx",
                "-g",
                "daemon off;"
            ],


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
























## [5.20]()

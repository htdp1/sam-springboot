# sam-springboot
> Springboot를 이용한 Restful API 개발 방법과  
> Container Platform(Kubernetes) 상에서 MSA개발에 필요한 내용을 설명 합니다.


## Prerequisite
### vscode
> vscode를 사용하며, Frontend와 Backend를 동시에 개발하고 테스트 할 수 있는  
> 환경과 기능을 제공함.

#### Extension 필수 설치


#### Extension 추가 설치

### Java환경
> 본설명은 JDK 11을 기준으로 설명하며, Command Line 작업을 위해  
> Maven도 설치 합니다.

- jdk-11.0.11-x64 MSI : redhat 가입 필요. https://developers.redhat.com/products/openjdk/download
- 환경변수 설정 : JAVA_HOME 등록
- maven 설치 : download(https://mirror.navercorp.com/apache/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip)
- unzip : c:\maven
- 환경변수 설정: MAVEN_HOME 등록
- Path 추가 :%MAVEN_HOME%\bin
- SSL Invalidate 설정 : [TODO]

## Download sample
- git url
- [GOTO Tutorial](doc/README.md)

https://developpaper.com/springboot-episode-5-integrating-listeners-filters-and-interceptors/

https://randomuser.me/api/



vegeta attack -name=blocking -rate=50 -duration=5s -targets=blocking.txt > blocking.50qps.bin
vegeta attack -name=nonblocking -rate=50 -duration=5s -targets=nonblocking.txt > nonblocking.50qps.bin


cat blocking.50qps.bin | vegeta plot > blocking.50qps.bin.html
cat nonblocking.50qps.bin | vegeta plot > nonblocking.50qps.bin.html
# Spring Boot Logbook Example

> **Spring Boot** 프로젝트에서 **Logbook** 라이브러리를 활용하여 HTTP 요청 및 응답을 로깅하는 예제 프로젝트입니다.



## **프로젝트 환경**

- **Spring Boot**: 3.4.2
- **Java**: 17
- **빌드 도구**: Gradle
- 사용 라이브러리
  - `logbook-spring-boot-starter:3.10.0`
  - `spring-boot-starter-web`
  - `lombok`



## **디렉토리 구조**

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── logbookexample
│   │               ├── LogbookExampleApplication.java  # Spring Boot 메인 애플리케이션 클래스
│   │               ├── config
│   │               │   └── LogbookConfig.java          # Logbook 설정 클래스
│   │               ├── controller
│   │               │   └── SampleController.java       # 테스트용 REST 컨트롤러
│   │               └── dto
│   │                   ├── ReqDto.java                 # 요청 데이터 DTO 클래스
│   │                   └── RespDto.java                # 응답 데이터 DTO 클래스
│   └── resources
│       └── application.yml                              # Spring Boot 애플리케이션 설정 파일

postmanCollection
└── logbook-example-test.postman_collection.json         # Postman 테스트 API 컬렉션

```

**`src/main/java`**

- **`config/LogbookConfig.java`**: Logbook 설정, 로깅 조건 및 민감 정보 숨김 처리
- **`controller/SampleController.java`**: 테스트를 위한 REST API가 정의된 컨트롤러
- **`dto/ReqDto.java`**: 요청 데이터를 처리하기 위한 DTO 클래스
- **`dto/RespDto.java`**: 응답 데이터를 처리하기 위한 DTO 클래스

**`src/main/resources`**

- **`application.yml`**: Spring Boot 애플리케이션의 설정 파일로, Logbook 로깅 레벨과 기타 환경 설정 포함

**`postmanCollection`**

- **`logbook-example-test.postman_collection.json`**: Postman을 사용하여 HTTP 요청/응답 로깅을 테스트하기 위한 API 컬렉션 파일

# spring-boot-activemq

## Tools needed

You need Docker with the compose plugin.

## Usage

Launch the ActiveMQ container

```shell
docker compose up -d 
```

Launch the spring boot application

```shell
./gradlew bootRun
```

Then you can try with these endpoints :
- http://localhost:8080/actuator/health (Should return `{"status":"UP"}`)
- http://localhost:8080/message/sayHello (Should print `Hi everyone !` inside the console)


# spring-boot-activemq

## Tools needed

You need Docker with the compose plugin.

## Usage

Launch the ActiveMQ and the spring boot app with docker

```shell
docker compose up --build -d
```

Then you can try with these endpoints :
- http://localhost:8080/actuator/health (Should return `{"status":"UP"}`)
- http://localhost:8080/message/sayHello (Should print `Hi everyone !` inside the standard output of the container)

```mermaid
sequenceDiagram
    Backend->>+ActiveMQ: Subscribe to 'messageQueue'
    Backend->>+ActiveMQ: Publish 'hi everyone !' to 'messageQueue'
    ActiveMQ->>+ActiveMQ: Put the message and make it available to consumers
    ActiveMQ->>+Backend: Broadcast the availability to consumers 
    Backend->>+ActiveMQ: Consume the message
    Backend->>+Backend: Delete the message to remove availability
    Backend->>+Backend: Print the message in the standard output
```

You can display the standard output of the backend with

```shell
docker logs spring-app-1 -f
```

In this application, I've used the default configuration for the JMS Listener. In production, we should
tune the timeouts and most of all, the consumption acknowledgment mode (CLIENT or AUTO) of the session.
# User Service

This is a demo application for the book practical microservices.

This application demonstrates a "hybrid" approach to microservices. Commands are sent over HTTP but services emit events over AMQP.

## Getting started

You will need to install Typesafe Activator. Start the application locally with

```
activator run

```

Start RabbitMQ

```
docker run -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

When you created, update or delete a user an event will be dispatched to RabbitMQ. Other services may listen to these events and react accordingly.

```json

{  "name": "user.created",
   "payload": "{\"firstName\":\"Bob\",\"lastName\":\"Jones\",\"email\":\"bob@gmail.com\",\"phone\":\"1234\"}",
   "timestamp": 1453750026869
 }
```


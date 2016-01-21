# Event Driven Services

Very few systems are fully synchonmous. 

Many tasks in a typical system might be things that should happen "in the background". Examples of these sorts of things are
services sending SMS push notification, delivering email, processing complex data etc. In these cases it makes sense to 
invoke these tasks asynchronmously using some kind of message queue. 

## What is an event

An event is simply something that happened in the past. Typically, but not always, it referes to some kind of stage change on an entity. Most people choose a naming strategy to indicate that something has happened in the system. For example

```scala
CustomerDeleted(id = 1)
```

## Rest vs Messaging

## Popular Message Brokers

There are many options when choosing a message broker for your microservice architecture but some of the more popular ones are Kafka and AMQP (RabbitMQ, ActiveMQ, MQLight). I particularly like Kafaka for it's conceptual simplificity.  

## Common Patterns

### Publish Subscribe

### Worker Queues

### RPC

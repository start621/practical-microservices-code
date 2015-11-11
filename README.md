# Microservices Design

A software developer reading list for learning more about micro service architecture

## Service Discovery

Services typically need to call one another. In a monolithic application, services invoke one another through language-level method or procedure calls. In a traditional distributed system deployment, services run at fixed, well known locations (hosts and ports) and so can easily call one another using HTTP/REST or some RPC mechanism. However, a modern microservice-based application typically runs in a virtualized or containerized environments where the number of instances of a service and their locations changes dynamically.

+ [ZooKeeper](http://zookeeper.apache.org)
+ [ETCD](https://github.com/coreos/etcd)
+ [Consol](https://www.consul.io)

## Service Communication

+ HTTP
+ AMQP
+ ZMQ
+ RabbitMQ
+ Protocol Buffers
+ Thrift
+ Avro

## Deployment

+ Docker

## Monitoring

+ StatsD
+ Graphana
+ Graphite
+ Librato

## Postel's Law

> Be liberal in what you accept, and conservative in what you send

## Videos

* [InfoQ Videos](http://www.infoq.com/microservices/presentations)
* [Microservices - Martin Fowler](https://www.youtube.com/watch?v=wgdBVIX9ifA)
* [State of the Art in Microservices - Adrian Cockcroft](https://www.youtube.com/watch?v=nMTaS07i3jk)
* [Deploying And Testing Microservices - Sam Newman](https://www.youtube.com/watch?v=FotoHYyY8Bo)
* [Microservices Anti-Patterns](https://www.youtube.com/watch?v=I56HzTKvZKc)
* [Practical Considerations For Microservice Architectures - Sam Newman](https://www.youtube.com/watch?v=5NOaUK74Jt4)
* [Migrating to Microservices - Adrian Cockcroft](http://www.infoq.com/presentations/migration-cloud-native)
* [Microservices at Netflix](https://www.youtube.com/watch?v=LEcdWVfbHvc)

## Articles

+ [Martin Fowler Articles](http://martinfowler.com/articles/microservices.html)

## Books

* [Antifragile: Things That Gain from Disorder](http://www.amazon.com/gp/product/0812979680)
* [The Black Swan](http://www.amazon.com/The-Black-Swan-Improbable-Robustness/dp/081297381X)
* [Implementing Domain-Driven Design](http://www.amazon.co.uk/Implementing-Domain-Driven-Design-Vaughn-Vernon/dp/0321834577)
* [Building Micro Services - Sam Newman](http://www.amazon.co.uk/Building-Microservices-Sam-Newman/dp/1491950358)
* [Antifragile Software - Russ Miles](https://leanpub.com/antifragilesoftware)

## People

* James Lewis
* Sam Newman
* Russ Miles
* Martin Fowler

## Architectural Patterns

* [API Gateway](http://microservices.io/patterns/apigateway.html)
* [Bounded Context](http://martinfowler.com/bliki/BoundedContext.html)
* [Circuit Breaker](http://martinfowler.com/bliki/CircuitBreaker.html)

## Design Principles

1. Do not worry about the size of services. Focus on which componnents "change together"

## Event Transport  and Service Communication

There are two main approaches to inter-process communication in a microservice architecture.

1. Synchronous HTTP such as REST or SOAP

2. An alternative to synchronous HTTP is an asynchronous message-based mechanism such as an AMQP-based message broker. This approach has a number of benefits. It decouples message producers from message consumers. The message broker will buffer messages until the consumer is able to process them. Producers are completely unaware of the consumers. The producer simply talks to the message broker and does not need to use a service discovery mechanism. Message-based communication also supports a variety of communication patterns including one-way requests and publish-subscribe. One downside of using messaging is needing a message broker, which is yet another moving part that adds to the complexity of the system

3. [Protocol Buffers](https://github.com/google/protobuf/)

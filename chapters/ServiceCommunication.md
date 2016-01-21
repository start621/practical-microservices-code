# Service Communication

The first problem you'll run into when building microservices is "how do I get these things to talk to each other". There are two common methods for service communication (HTTP and Messaging) as well as various options for message format (JSON, XML, Protocol Buffers, Thrift, Avro). 

I like to break down methods into two forms, "request response" and "fire and forget" type communication. Request response is your typical HTTP request flow where you send a request to some service and expect to get a response back in a reasonable amount of time. Fire and forget would be used where you need to send a message to another service but don't care about getting a response back.

## HTTP

HTTP DAO

Client libraries

## Messaging 

Fire and forget 

### Messaging RPC

Although it's possible to RPC using messaging systems like Rabbit MQ, I'm not a great fan of this and would recommend avoiding it where possible. HTTP tends to be a much easier and more natural fit for request/response patterns.

How it works.

+ Correlation ID
+ Callback queue. 

## Transport Formats

### JSON

### Protocol Buffers


# Service Discovery

## Why Service Discovery


In a more traditional application architecture, services instances have fixed locations that rarely change. In a cloud based microservice architecture the number of instances changes dynamically and so it is no longer possible to rely on  instances being available.

In order to make a request to a service we need to know the network location (IP address, port) of that service. In traditional architectures this isn't much of a problem
since applications would be relatively static and we could simple store the network address of services in config. In a modern, cloud based architecture this isn't the case.
Application instances come and go often (due to autoscaling, service failure etc) meaning we need a more flexible mechanism
for service discovery. There are two main patterns in service discovery, client side discovery and server side discovery. We'll take a look at each one in turn.

## Client Side Discovery

Client side service discovery is a pattern in which the client is responsible for determining the network location of other services and handles load balancing requests to the those instances.
The client queries a service registry to fetch a list of available services instances. The client then uses some algorithm to determine which instance to make a request to.

## Server Side Discovery

A server side discovery pattern is where the client makes a request to a load balancer meaning the client no longer has to deal with the complexity of service discovery. 

## Service Registry

### Self Registration

### Third Party Registration
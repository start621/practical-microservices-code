# Logging And Monitoring

When moving to the world of microservices knowing what's going on in your system suddenly becomes a real problem. 

## Standardise, Standardise, Standardise

It is absolutely critical that you come to a standardised monitoring solution and make it as painless as possible for developers 
to add monitoring and metrics to a service. This is because setting up monitoring for each
new service in your architecture will be a great deal of work. You want all services to be consistent in terms of monitoring.

## Expose service stats

It's a good idea for all services to expose some kind of healthcheck (/health) or status (/status) URL. This will make it
easy for clients and operations to query the health of your service. 

## The ELK Stack

## Other Options

+ New Relic
+ Splunk

## Distributed Tracing

+ Zipkin

# Consuming Services

## Provide Client Libraries

Although this is a controvertial subject, I recommend providing a client library with your services to make it easier for 
clients to consume and interact with your services. Calling a service is a non trivial task and it's a lot of work 
for other people that need to call your service. They must deal with request failures, invalid credentials etc, HTTP retries and backoff.

Don't leave all this work up to every user of your service. A good client library should have a clear and intuitive API and
take care of some of the grunt work involved in making requests to your service.

```scala
val userService = new UserServiceClient

val users: Future[Either[Failure, Success]] = userService.getAllUsers()
```

+ Finagle
+ NetFlix

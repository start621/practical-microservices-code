# Example 1

Our first project will look at creating a simple User service to manager user information and an activity service that audits
all events in our system. 

We will be using what I call a "hybrid approach" to microservices where we use HTTP for general service communication but push out events when the state of an entity is changed. Other services can subscribe to the event stream and react accordingly. Our activity service will just listen to a message queue and save all the events that happen in the system.

This idea of an audit log is common in financial domains where you need very strong awareness of transactions that happen in your system.

## The API

Our user service is a very simple CRUD application with a hopefully familar API.

+ Get a list of users
+ Get a single user
+ Create a user
+ Update a user
+ Delete a user

## The Events

For this simple example we are going to emit three events from our service.

+ UserCreated
+ UserUpdated
+ UserDeleted

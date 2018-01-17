Spring Boot Example
===================

This example shows how to work with the simple Camel AMQP application based on the Spring Boot.

The example generates messages using timer trigger, sends to a queue, and logs that a message was sent. 
It also has a cooresponding consumer. 

You will need to compile this example first:
  mvn install

To run the example type
  mvn spring-boot:run

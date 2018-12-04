package com.example.camel.jms;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {        
          from("jms:queue:test.queue")
    	    .routeId("consumer1")
    	    .log(LoggingLevel.INFO, "Message received consumer 1");
          
          from("jms:queue:test.queue")
  	    	.routeId("consumer2")
  	    	.log(LoggingLevel.INFO, "Message received consumer 2");
    }

}

package com.example.camel.jms.amqp;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute  extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:producer?period=1000&repeatCount=6")
        	.routeId("producer")
        	.to("jms:topic:topic.dyn")
        	.log(LoggingLevel.INFO, "Message sent");
    }
}

package com.example.camel.jms.amqp;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;

@Component
public class ProducerRoute  extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
		DataFormat csvToPojo = new BindyCsvDataFormat(com.example.camel.jms.amqp.JsonPojo.class);
		
        from("file:/home/marycochran/git/AMQ7Samples/amqp-camel-client/file-drop/")
        	.routeId("producer")
        	.convertBodyTo(String.class)
        	.split().tokenize("\r\n|\n").streaming().parallelProcessing()
        	.unmarshal(csvToPojo)
        	.log(LoggingLevel.INFO, "************About to send message Body: ${body}")
        	.convertBodyTo(String.class)
        	.to("jms:topic:topic.foo")
        	.log(LoggingLevel.INFO, "Message sent");
    }
}

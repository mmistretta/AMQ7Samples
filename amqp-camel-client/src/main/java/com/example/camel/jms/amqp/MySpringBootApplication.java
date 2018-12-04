package com.example.camel.jms.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.qpid.jms.JmsConnectionFactory;

@SpringBootApplication
@Configuration
@ComponentScan("com.example.camel.jms")
public class MySpringBootApplication {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Bean
    public JmsConnectionFactory jmsConnectionFactory(){
    	JmsConnectionFactory jmsConnectionFactory = new JmsConnectionFactory();
    	jmsConnectionFactory.setRemoteURI("amqp://localhost:5672");
    	return jmsConnectionFactory;
    }

    @Bean
    public JmsConfiguration jmsConfig(){
    	JmsConfiguration jmsConfig = new JmsConfiguration();
    	jmsConfig.setConnectionFactory(jmsConnectionFactory());
    	return jmsConfig;
    }
}

package com.example.camel.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsConfiguration;

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
    public JmsConfiguration jmsConfig(){
    	JmsConfiguration jmsConfig = new JmsConfiguration();
    	ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("failover:(tcp://localhost:61616,tcp://localhost:61617,"
    			+ "tcp://localhost:61618,tcp://localhost:61619)");
    	cf.setUserName("admin");
    	cf.setPassword("Password1!");
    	jmsConfig.setConnectionFactory(cf);
    	return jmsConfig;
    }
}

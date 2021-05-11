package com.davish.serviceDb.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	
	@Bean
	ConnectionFactory connectionFactory()
	{
	CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory("localhost");
	cachingConnectionFactory.setUsername("guest");
	cachingConnectionFactory.setPassword("guest");
	return cachingConnectionFactory;
	}
	
	
	
	

}

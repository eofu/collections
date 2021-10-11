package com.myself.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;
import java.util.Enumeration;

public class ActiveMQTest {
	public static void main(String[] args) {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		try {
			Connection connection = connectionFactory.createConnection();
			ConnectionMetaData metaData = connection.getMetaData();
			Enumeration jmsxPropertyNames = metaData.getJMSXPropertyNames();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}

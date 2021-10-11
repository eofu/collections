package com.myself.mq.activemq.provider;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicProvider {
	public static void main(String[] args) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = null;
		try {
			connection = activeMQConnectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			// 创建目的地
			Destination destination = session.createTopic("myTopic");
			// 创建发送者
			MessageProducer messageProducer = session.createProducer(destination);

			// 创建需要发送的信息
			TextMessage hello = session.createTextMessage("Hello World");

			messageProducer.send(hello);

			session.commit();
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

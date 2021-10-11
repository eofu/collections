package com.myself.mq.activemq.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSQuereReceiver {
	public static void main(String[] args) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = null;
		try {
			connection = activeMQConnectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			// 创建目的地
			Destination destination = session.createQueue("myQuere");
			// 创建消费者
			MessageConsumer messageConsumer = session.createConsumer(destination);

			TextMessage message = (TextMessage)messageConsumer.receive();
			System.out.println(message.getText());

			session.commit();
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException ignored) {

				}
			}
		}
	}
}

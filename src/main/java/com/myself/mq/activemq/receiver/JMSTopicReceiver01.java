package com.myself.mq.activemq.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicReceiver01 {
	public static void main(String[] args) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = null;
		try {
			connection = activeMQConnectionFactory.createConnection();
			connection.setClientID("yangshuai-001");
			connection.start();

			// boolean.true/false 是否开启事务
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			// 创建目的地
			Topic destination = session.createTopic("myTopic");
			// 创建消费者,持久订阅
			MessageConsumer messageConsumer = session.createDurableSubscriber(destination, "yangshuai-001");

			// 持久化
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

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

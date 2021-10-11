package com.myself.mq.kafka.receiver;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerDemo extends Thread {

	private final KafkaProducer<Integer, String> producer;

	private final String topic;

	public KafkaProducerDemo(String topic) {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.CLIENT_ID_CONFIG, "kafkaProducerDemo");
		properties.put(ProducerConfig.ACKS_CONFIG, "1");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<>(properties);
		this.topic = topic;
	}

	public static void main(String[] args) {
		new KafkaProducerDemo("test").start();
	}

	@Override
	public void run() {
		int num = 0;
		while (num < 50) {
			String message = "message_" + num;
			System.out.println("begin send message " + message);
			producer.send(new ProducerRecord<Integer, String>(topic, message));
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}

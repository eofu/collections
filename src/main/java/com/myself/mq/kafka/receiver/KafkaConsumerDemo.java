package com.myself.mq.kafka.receiver;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerDemo extends Thread {
	private final KafkaConsumer consumer;

	public KafkaConsumerDemo(String topic) {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "kafkaConsumerDemo");
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		consumer = new KafkaConsumer(properties);
		consumer.subscribe(Collections.singletonList(topic));
	}

	public static void main(String[] args) {
		new KafkaProducerDemo("test").start();
	}

	@Override
	public void run() {
		while (true) {
			ConsumerRecords<Integer, String> consumerRecords = consumer.poll(1000);
			for (ConsumerRecord<Integer, String> consumerRecord : consumerRecords) {
				System.out.println(consumerRecord);
			}
		}
	}
}

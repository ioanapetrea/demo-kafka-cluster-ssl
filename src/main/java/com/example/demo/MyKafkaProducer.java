package com.example.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class MyKafkaProducer {
    public static final String TOPIC_NAME = "test-topic";
    private static final String CONTENT = "TestMessage";
    public static final String CLUSTER_IP = "192.168.1.110";
    public static final String BOOTSTRAP_SERVERS = String.format("%s:9091,%s:9092,%s:9093", CLUSTER_IP, CLUSTER_IP, CLUSTER_IP);

    public static void produceMessages() {
        Properties props = new Properties();
        props.put("bootstrap.servers", String.format("%s:9091,%s:9092,%s:9093", CLUSTER_IP, CLUSTER_IP, CLUSTER_IP));
        //props.put("acks", "all")
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", "/tmp/kafka/certificates/kafka.truststore");
        props.put("ssl.truststore.password", "Aa123456!");

        props.put("ssl.keystore.location", "/tmp/kafka/certificates/kafka.keystore");
        props.put("ssl.keystore.password", "Aa123456!");
        props.put("ssl.key.password", "Aa123456!");
        props.put("acks", "1");
        props.put("retries", 0);
        // Controls how much bytes sender would wait to batch up before publishing to Kafka.
        props.put("batch.size", 10);
        props.put("linger.ms", 10);
        final Producer<String, String> producer = new KafkaProducer<>(props);
        System.out.println("Producer created");
        for (int i = 0; i < 1000; i++) {
            Integer times = 0;
            try {
                RecordMetadata o = producer
                        .send(new ProducerRecord<String, String>(TOPIC_NAME, Integer.toString(i), CONTENT + i)).get();
                System.out.println(o.topic() + " " + o.partition() + " " + o.offset() + " " + o.timestamp());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Send one message " + i);
        }
    }
}

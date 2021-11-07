package com.example.demo;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;
import java.util.UUID;

public class MyKafkaConsumer {

    public static KafkaConsumer<String, String> createConsumer(String brokers) {
        Properties props = new Properties();
        String consumeGroup = UUID.randomUUID().toString();
        props.put("group.id", consumeGroup);
        props.put("auto.offset.reset", "earliest");
        // Set this property, if auto commit should happen.
        props.put("enable.auto.commit", "true");
        // Auto commit interval, kafka would commit offset at this interval.
        props.put("auto.commit.interval.ms", "10000");
        // This is how to control number of records being read in each poll
        props.put("max.partition.fetch.bytes", "10240");
        // Set this if you want to always read from beginning.
        // props.put("auto.offset.reset", "earliest");
        props.put("heartbeat.interval.ms", "3000");
        props.put("session.timeout.ms", "6001");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.put("bootstrap.servers", brokers);
        //props.put("acks", "all")
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", "/tmp/kafka/certificates/kafka.truststore");
        props.put("ssl.truststore.password", "Aa123456!");

        props.put("ssl.keystore.location", "/tmp/kafka/certificates/kafka.keystore");
        props.put("ssl.keystore.password", "Aa123456!");
        props.put("ssl.key.password", "Aa123456!");
        return new KafkaConsumer<>(props);
    }
}

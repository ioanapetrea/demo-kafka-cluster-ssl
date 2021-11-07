package com.example.demo;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;

public class ConsumerTest {
    @Test
    public void testConsumer() {
//        MyKafkaProducer.produceMessages();

        KafkaConsumer<String, String> consumer = MyKafkaConsumer.createConsumer(MyKafkaProducer.BOOTSTRAP_SERVERS);
        consumer.subscribe(Collections.singletonList("test-topic"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("Received Message topic =%s, partition =%s, offset = %d, key = %s, value = %s\n",
                        record.topic(), record.partition(), record.offset(), record.key(), record.value());
            }
        }
    }

}

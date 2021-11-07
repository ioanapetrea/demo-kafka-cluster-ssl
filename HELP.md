# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#boot-features-kafka)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#using-boot-devtools)

Inspired by https://lff0305.medium.com/build-a-kafka-cluster-with-ssl-with-docker-docker-compose-and-java-client-5d54fa9cb290

Step 1: Create a dockerfile - with details about the kafka brokers- part of your cluster (kafka-image.dockerfile).
Step 2: Build this new docker image: 
`docker build . --file kafka-image.dockerfile -t my_kafka:latest`

Make sure that your my_kafka image was built correctly:
`docker image ls`

Step 3: Create a docker-compose.yml file and add zookeeper support. Public docker-hub zookeeper images can be used.

cp  /tmp/kafka/certificates/ca-cert /home/kick/repo/demo-kafka/certificates/ca-cert
cp  /tmp/kafka/certificates/ca-cert.srl /home/kick/repo/demo-kafka/certificates/ca-cert.srl
cp  /tmp/kafka/certificates/ca-key /home/kick/repo/demo-kafka/certificates/ca-key
cp  /tmp/kafka/certificates/kafka-cert_1 /home/kick/repo/demo-kafka/certificates/kafka-cert_1
cp  /tmp/kafka/certificates/kafka-cert_2 /home/kick/repo/demo-kafka/certificates/kafka-cert_2
cp  /tmp/kafka/certificates/kafka-cert_3 /home/kick/repo/demo-kafka/certificates/kafka-cert_3
cp  /tmp/kafka/certificates/kafka-cert_1-signed /home/kick/repo/demo-kafka/certificates/kafka-cert_1-signed
cp  /tmp/kafka/certificates/kafka-cert_2-signed /home/kick/repo/demo-kafka/certificates/kafka-cert_2-signed
cp  /tmp/kafka/certificates/kafka-cert_3-signed /home/kick/repo/demo-kafka/certificates/kafka-cert_3-signed
cp  /tmp/kafka/certificates/kafka.keystore /home/kick/repo/demo-kafka/certificates/kafka.truststore




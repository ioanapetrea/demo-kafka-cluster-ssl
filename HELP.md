# Build a kafka cluster with SSL with docker / docker-compose and Java Client

### Reference Documentation

* Tutorial: https://lff0305.medium.com/build-a-kafka-cluster-with-ssl-with-docker-docker-compose-and-java-client-5d54fa9cb290

Step 1: Create a dockerfile - with details about the kafka brokers - part of your cluster (kafka-image.dockerfile).
Step 2: Build this new docker image: 
`docker build . --file kafka-image.dockerfile -t my_kafka:latest`

Make sure that your my_kafka image was built correctly:
`docker image ls`

Step 3: Create a docker-compose.yml file and add zookeeper support. Public docker-hub zookeeper images can be used. (docker/docker-compose.yml)
Step 4: Create the keystore, truststore, CA, Certificate Sign Request file,and sign the certificates of the 3 brokers with CA. Modify
openssl configuration to enable SAN names and add our broker name and host ip. The updated openssl configuration file (openssl.cnf).
Step 5: Add kafka service configurations to the docker-compose.yml in Step 2.
Step 6: Start the services.
Step 7: Test with Java client.
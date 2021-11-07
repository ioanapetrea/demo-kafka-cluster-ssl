FROM  wurstmeister/kafka
RUN echo "ssl.keystore.location=/certificates/kafka.keystore" >> /opt/kafka/config/server.properties && \
    echo "ssl.keystore.password=Aa123456!" >> /opt/kafka/config/server.properties && \
    echo "ssl.truststore.location=/certificates/kafka.truststore"  >> /opt/kafka/config/server.properties && \
    echo "ssl.truststore.password=Aa123456!"  >> /opt/kafka/config/server.properties && \
    echo "ssl.key.password=Aa123456!"  >> /opt/kafka/config/server.properties && \
    echo "ssl.client.auth=required"  >> /opt/kafka/config/server.properties
package ru.iam;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.nio.charset.StandardCharsets;

import ru.iam.pojos.SkudEvent;

public class Recv {

    private final static String QUEUE_NAME = "my_java_recv_esb";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.220.16.30");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Just in case exchange and queue not declared and bound yet
        channel.exchangeDeclare("zbrt", "topic", true);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, "zbrt", "esb");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            System.out.println("");
            System.out.println(" #################  New message received  #################");
            System.out.println(" [x] getExchange: " + delivery.getEnvelope().getExchange());
            System.out.println(" [x] getRoutingKey: " + delivery.getEnvelope().getRoutingKey());
            System.out.println(" [x] getContentType: " + delivery.getProperties().getContentType());

            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(message);
            ObjectMapper objectMapper2 = new ObjectMapper();
            objectMapper2.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            if (jsonNode.get("Event-Name").asText().equals("send_event")) {
                System.out.println("\njsonNode tests:");
                System.out.println(" [x] Event-Category '" + jsonNode.get("Event-Category").asText() + "'");
                System.out.println(" [x] Event-Name '" + jsonNode.get("Event-Name").asText() + "'");
                System.out.println(" [x] Data -> Event: '" + jsonNode.get("Data").get("Event").toString() + "'");

                System.out.println("\nJSON to POJO tests:");
                SkudEvent skEvent = objectMapper2.readValue(message, SkudEvent.class);
                System.out.println(" [x] getAction() '" + skEvent.getAction() + "'");
                System.out.println(" [x] skEvent.getNode() '" + skEvent.getNode() + "'");
                System.out.println(" [x] skEvent.getData().getEvent().getReaderId() '"
                                        + skEvent.getData().getEvent().getReaderId() + "'");

                System.out.println("\nPOJO to XML tests:");
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
                String xml = xmlMapper.writeValueAsString(skEvent);
                System.out.println(xml);
            }

        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

package ru.iam;

import com.fasterxml.jackson.databind.*;
import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

import ru.iam.pojos_resp.Message;
import ru.iam.pojos_resp.MyReplyTest;
import ru.iam.pojos_resp.MsgBody;

public class SyncResp {

    private final static String QUEUE_NAME = "my_recv_msg_for_java_test";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.110.16.30");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("zbrt", "topic", true);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
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

            if (jsonNode.get("ClassId").asInt() == 265) {
                System.out.println(" [x] Event-Category '" + jsonNode.get("Event-Category").asText() + "'");
                System.out.println(" [x] Event-Name '" + jsonNode.get("Event-Name").asText() + "'");
                final String ServerId = jsonNode.get("Server-ID").asText();
                System.out.println(" [x] Server-ID '" + ServerId + "'");
                final String MessageId = jsonNode.get("Msg-ID").asText();
                System.out.println(" [x] Msg-ID '" + MessageId + "'");

                objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

//                String respJsonString =  "{\"message\":{\"messageHeader\":{\"version\":\"1.0\",\"sender\":\"TOS\",\"receiver\":\"WEB\",\"created\":\"2021-05-19T00:20:26\"},\"msgBody\":{\"message_text\":\"Hello World\"}},\"Event-Category\":\"sync_resp_category\",\"Event-Name\":\"sync_resp_envent_name\",\"Msg-ID\":\"" + MessageId + "\",\"App-Name\":\"bp1c\",\"App-Version\":\"4.0.0\" }";
//                System.out.println("About to reply to " + jsonNode.get("Node").asText() +" with: " + respJsonString);
//                System.out.println(respJsonString);
//                MyReplyTest myReplyTest = objectMapper.readValue(respJsonString, MyReplyTest.class);
//                String respJsonString2 = objectMapper.writeValueAsString(myReplyTest);

                MyReplyTest myReplyTest = new MyReplyTest();
                MsgBody messageBody = new MsgBody();
                Message myMessage = new Message();
                myMessage.setMsgBody(messageBody);
                myReplyTest.setMessage(myMessage);
                myReplyTest.setMsgID(MessageId);

                String respJsonString2 = objectMapper.writeValueAsString(myReplyTest);
                System.out.println("\nReply to " + jsonNode.get("Node").asText() + " with: ");
                System.out.println(respJsonString2);

                channel.basicPublish(
                        "targeted",
                        ServerId,
                        new AMQP.BasicProperties.Builder()
                                .contentType("application/json")
                                .build(),
                        respJsonString2.getBytes(StandardCharsets.UTF_8));
            }

        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}

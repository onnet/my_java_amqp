package ru.iam;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ru.iam.pojos_out.MyMoveInt;

import java.nio.charset.StandardCharsets;

public class Send {

    private final static String QUEUE_NAME = "my_java_sendtest";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.220.16.30");

        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {

            // Just in case exchange and queue not declared and bound yet
              channel.exchangeDeclare("zbrt", "topic", true);
              channel.queueDeclare(QUEUE_NAME, false, false, false, null);
              channel.queueBind(QUEUE_NAME, "zbrt", "zportal.#");

              String message =  "{\"message\":{\"classId\":\"32\",\"messageHeader\":{\"version\":\"1.0\",\"sender\":\"TOS\",\"receiver\":\"WEB\",\"created\":\"2021-05-19T00:20:26\",\"messageId\":\"55bdf069-6a2b-4cf2-b2c4-af953eac9883\"},\"msgBody\":{\"move_int\":{\"action\":\"save\",\"action_date\":\"2021-05-19T00:20:26\",\"terminal_syncid\":\"BRT/TOS-V6/Stakeholder/8\",\"move_time\":\"2021-05-19T00:20:26\",\"container\":{\"cnt_syncid\":\"BRT/BRT-TOS/Container/52060\",\"cnt_number\":\"TGHU1997126\"},\"loader\":{\"loader_syncid\":\"BRT-TEST/TOS/Loaders/4879\",\"loader_name\":\"RS02\"},\"begin_cell\":\"B43-3-4\",\"begin_tier\":\"2\",\"end_cell\":\"B45-3-5\",\"end_tier\":\"2\",\"from_wh\":\"WFULL\",\"to_wh\":\"WFULL\",\"move_syncid\":\"CTTK/TOS-V64/CNT_OPERATION/242619\",\"move_type\":\"W\",\"work_cnt_syncid\":null,\"work_type\":\"AP\",\"worker\":{\"worker_syncid\":\"BRT/BRT-TOS/Worker/5606\",\"worker_name\":\"DEN\"}}}},\"Event-Category\":\"prebill\",\"Event-Name\":\"move_int\"}";
              System.out.println("message: " + message);
              ObjectMapper objectMapper = new ObjectMapper();
              objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
              objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
              MyMoveInt myMoveInt = objectMapper.readValue(message, MyMoveInt.class);
              String jsonInString = objectMapper.writeValueAsString(myMoveInt);
              System.out.println("jsInStr: " + jsonInString);

              channel.basicPublish(
                      "zbrt",
                      "zportal.prebill",
                      new AMQP.BasicProperties.Builder()
                              .contentType("application/json")
                              .deliveryMode(2)
                              .priority(1)
                          //    .userId("bob")
                              .build(),
                       message.getBytes(StandardCharsets.UTF_8));

              System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

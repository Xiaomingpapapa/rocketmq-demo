package com.zhiming.study.demo4;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

public class BatchMessageProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
//        producer.setCreateTopicKey("BatchTest");
        // 启动生产者
        producer.start();

        String topic = "BatchTopic";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(topic, "TagB", "OrderID001", "Hello world 0".getBytes()));
        messages.add(new Message(topic, "TagB", "OrderID002", "Hello world 1".getBytes()));
        messages.add(new Message(topic, "TagB", "OrderID003", "Hello world 2".getBytes()));
        try {
            producer.send(messages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package by.softclub.kafka_hello_world.controller;

import by.softclub.kafka_hello_world.service.ConsumerService;
import by.softclub.kafka_hello_world.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public final class KafkaController {
    private final ProducerService producerService;
    private final ConsumerService consumerService;


    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic() {
        producerService.sendMessage("message");
    }

//    @GetMapping(value = "/receive")
//    public List<BinRedis> getMessageFromKafkaTopic() {
//        //return consumerService.getMessage();
//    }

}

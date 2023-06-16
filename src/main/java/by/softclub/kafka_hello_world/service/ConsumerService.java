package by.softclub.kafka_hello_world.service;

import by.softclub.kafka_hello_world.persistence.BinRedis;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    private final RedisTemplate<String, List<BinRedis>> redisTemplate;

    @KafkaListener(topics = "${bin.topic.name}", groupId = "bin", containerFactory = "binKafkaListenerContainerFactory")
    public void binListener(List<BinRedis> binRedisList) {
        System.out.println("Received bins from kafka: " + binRedisList);
        redisTemplate.opsForValue().set("bin",binRedisList);
//        System.out.println(redisTemplate.opsForValue().get("bin"));
    }


}

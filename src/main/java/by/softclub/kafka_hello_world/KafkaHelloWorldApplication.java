package by.softclub.kafka_hello_world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@SpringBootApplication
public class KafkaHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaHelloWorldApplication.class, args);
    }

}

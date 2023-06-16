package by.softclub.kafka_hello_world.config;

import by.softclub.kafka_hello_world.persistence.BinRedis;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;


//    public ConsumerFactory<String, List<BinRedis>> binConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "bin");
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(BinRedis.class));
//    }

    //    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, List<BinRedis>> binKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, List<BinRedis>> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(binConsumerFactory());
//        return factory;
//    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, List<BinRedis>> binKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, List<BinRedis>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(binConsumerFactory());
        return factory;
    }

    private ConsumerFactory<String, List<BinRedis>> binConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, List.class.getName());
        return new DefaultKafkaConsumerFactory<>(props);
    }
}

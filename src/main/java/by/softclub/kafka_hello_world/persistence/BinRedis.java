package by.softclub.kafka_hello_world.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BinRedis {

    Long id;
    @JsonProperty("bank_id")
    Long bankId;
    String bin;
}

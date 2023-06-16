package by.softclub.kafka_hello_world.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRedisRepository extends CrudRepository<BinRedis, String> {}

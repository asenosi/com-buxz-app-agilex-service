package com.buxz.app.agilexservice.adapter.outbound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetroBoardRepository extends MongoRepository<OutboundRetroBoard, Long> {
}

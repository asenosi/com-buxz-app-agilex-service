package com.buxz.app.agilexservice.adapter.outbound.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.LongStream;

@Repository
public interface RetroBoardRepository extends MongoRepository<OutboundRetroBoard, UUID> {
    Optional<OutboundRetroBoard> findByRetroId(UUID id);
}

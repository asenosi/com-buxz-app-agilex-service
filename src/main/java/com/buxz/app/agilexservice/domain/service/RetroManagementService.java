package com.buxz.app.agilexservice.domain.service;

import com.buxz.app.agilexservice.adapter.outbound.BoardMongoAdapter;
import com.buxz.app.agilexservice.domain.StatusEnum;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import com.buxz.app.agilexservice.domain.port.RetroManagementUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class RetroManagementService implements RetroManagementUseCase {

    private final BoardMongoAdapter mongoAdapter;

    @Autowired
    public RetroManagementService(BoardMongoAdapter mongoAdapter) {
        this.mongoAdapter = mongoAdapter;
    }

    @Override
    public DomainRetroRequest createNewRetroBoard(DomainRetroRequest retroRequest) {
        log.info("RetroManagementService#createNewRetroBoard: Creating a new retro board, date : {}", LocalDateTime.now());

        DomainRetroRequest domainRetroRequest = DomainRetroRequest.builder()
                .id(UUID.randomUUID())
                .retroId(UUID.randomUUID())
                .boardCreator(retroRequest.getBoardCreator())
                .retroTitle(retroRequest.getRetroTitle())
                .retroDescription(retroRequest.getRetroDescription())
                .dateCreated(LocalDateTime.now())
                .status(StatusEnum.CREATED)
                .build();
        return mongoAdapter.createNewRetroBoard(domainRetroRequest);
    }

    @Override
    public List<DomainRetroRequest> retrieveAllBoards() {
        log.info("RetroManagementService#retrieveAllBoards: Retrieve a list of all the retrospective sessions");
        return mongoAdapter.retrieveAllRetroSessions();
    }

    @Override
    public List<DomainRetroRequest> retrieveBoardByStatus(StatusEnum status) {
        return null;
    }

    @Override
    public Optional<DomainRetroRequest> retrieveRetroSessionById(UUID id) {
        log.info("RetroManagementService#retrieveRetroSessionById: Retrieve a retrospective session by id: {} ", id);
        return mongoAdapter.findRetroSessionById(id);
    }

    @Override
    public void updateRetroBoardStatus(UUID retroId, StatusEnum status) {

    }
}

package com.buxz.app.agilexservice.adapter.inbound.rest;

import com.buxz.app.agilexservice.adapter.inbound.model.RestRetroRequest;
import com.buxz.app.agilexservice.adapter.inbound.rest.mapper.RetroRequestMapper;
import com.buxz.app.agilexservice.domain.port.RetroManagementUseCase;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1/retro")
public class RetroController {

    private final RetroRequestMapper requestMapper;
    private final RetroManagementUseCase retroManagementUseCase;

    @Autowired
    public RetroController(
            RetroRequestMapper requestMapper,
                           RetroManagementUseCase retroManagementUseCase) {
        this.requestMapper = requestMapper;
        this.retroManagementUseCase = retroManagementUseCase;
    }

    @PostMapping
    public ResponseEntity<RestRetroRequest> createNewRetroBoard(@RequestBody RestRetroRequest boardRequest) {
        log.info("CreateNewRetroBoard: Create new retro board named : {}, by User: {}",
                boardRequest.getRetroTitle(), boardRequest.getBoardCreator());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        Optional.of(boardRequest)
                        .map(requestMapper::mapToDomainRequest)
                        .map(retroManagementUseCase::createNewRetroBoard)
                        .map(requestMapper::mapFromDomainRequest)
                        .orElse(null)
                );
    }

    @GetMapping
    public ResponseEntity<List<RestRetroRequest>> getAllRetrospectives() {
        log.info("RetrieveAllRetroBoards: Retrieve a list of all the retrospective sessions");
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(
                        retroManagementUseCase.retrieveAllBoards()
                                .stream()
                                .map(requestMapper::mapFromDomainRequest)
                                .collect(Collectors.toList())
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestRetroRequest> getRetroSessionById(@PathVariable("id") UUID id) {
        Optional<RestRetroRequest> retroSession = retroManagementUseCase.retrieveRetroSessionById(id).map(requestMapper::mapFromDomainRequest);
        return retroSession.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}

package com.buxz.app.agilexservice.domain.port;

import com.buxz.app.agilexservice.adapter.inbound.model.RestRetroRequest;
import com.buxz.app.agilexservice.domain.StatusEnum;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetroManagementUseCase {

    DomainRetroRequest createNewRetroBoard(DomainRetroRequest retroRequest);

    List<DomainRetroRequest> retrieveAllBoards();

    List<DomainRetroRequest> retrieveBoardByStatus(StatusEnum status);

    Optional<DomainRetroRequest> retrieveRetroSessionById(UUID id);

    void updateRetroBoardStatus(UUID retroId, StatusEnum status);


}

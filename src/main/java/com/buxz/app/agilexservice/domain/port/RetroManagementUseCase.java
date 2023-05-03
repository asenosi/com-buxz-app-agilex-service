package com.buxz.app.agilexservice.domain.port;

import com.buxz.app.agilexservice.domain.StatusEnum;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface RetroManagementUseCase {

    DomainRetroRequest createNewRetroBoard(DomainRetroRequest retroRequest);

    List<DomainRetroRequest> retrieveAllBoards();

    Collection<DomainRetroRequest> retrieveBoardByStatus(StatusEnum status);

    DomainRetroRequest retrieveBoardByRetroId(UUID id);

    void updateRetroBoardStatus(UUID retroId, StatusEnum status);


}

package com.buxz.app.agilexservice.adapter.inbound.model;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RestRetroRequest {
    String retroId;
    String retroTitle;
    String boardCreator;
    String retroDescription;
    LocalDateTime dateCreated;
    StatusEnum status;
}

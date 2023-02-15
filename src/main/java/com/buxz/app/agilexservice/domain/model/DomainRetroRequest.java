package com.buxz.app.agilexservice.domain.model;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class DomainRetroRequest {
    UUID id;
    String retroTitle;
    StatusEnum status;
    LocalDate dateCreated;
    String boardCreator;
}

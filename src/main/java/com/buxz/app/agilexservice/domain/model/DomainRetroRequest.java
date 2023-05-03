package com.buxz.app.agilexservice.domain.model;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DomainRetroRequest {
    UUID id;
    String retroTitle;
    private String retroDescription;
    String boardCreator;
    StatusEnum status;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;
}

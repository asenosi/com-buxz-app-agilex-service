package com.buxz.app.agilexservice.adapter.outbound.repository;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class OutboundRetroBoard {
    @Id
    UUID id;
    String retroTitle;
    String boardCreator;
    StatusEnum status;
    LocalDateTime dateCreated;
    String updatedDate;
}

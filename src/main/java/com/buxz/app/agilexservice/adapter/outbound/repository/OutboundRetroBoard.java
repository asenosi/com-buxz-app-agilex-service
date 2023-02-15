package com.buxz.app.agilexservice.adapter.outbound.repository;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutboundRetroBoard {
    UUID id;
    String retroTitle;
    StatusEnum status;
    String createdDate;
    String updatedDate;
}

package com.buxz.app.agilexservice.adapter.inbound.model;

import com.buxz.app.agilexservice.domain.StatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestRetroRequest {
    String retroTitle;
    String boardCreator;
    String retroDescription;
}

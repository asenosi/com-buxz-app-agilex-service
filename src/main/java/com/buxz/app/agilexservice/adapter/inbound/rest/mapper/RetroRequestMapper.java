package com.buxz.app.agilexservice.adapter.inbound.rest.mapper;

import com.buxz.app.agilexservice.adapter.inbound.model.RestRetroRequest;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;

@Mapper
public interface RetroRequestMapper {
    RestRetroRequest mapFromDomainRequest(DomainRetroRequest domainRequest);
    DomainRetroRequest mapToDomainRequest(RestRetroRequest restRequest);


}

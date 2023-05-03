package com.buxz.app.agilexservice.adapter.inbound.rest.mapper;

import com.buxz.app.agilexservice.adapter.inbound.model.RestRetroRequest;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RetroRequestMapper {

    RetroRequestMapper MAPPER = Mappers.getMapper(RetroRequestMapper.class);
    RestRetroRequest mapFromDomainRequest(DomainRetroRequest domainRequest);
    DomainRetroRequest mapToDomainRequest(RestRetroRequest restRequest);
}

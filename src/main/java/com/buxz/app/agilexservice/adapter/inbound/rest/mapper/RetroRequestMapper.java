package com.buxz.app.agilexservice.adapter.inbound.rest.mapper;

import com.buxz.app.agilexservice.adapter.inbound.model.RestRetroRequest;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RetroRequestMapper {

    RetroRequestMapper MAPPER = Mappers.getMapper(RetroRequestMapper.class);
    @Mapping(target = "retroDescription", source = "retroDescription")
    RestRetroRequest mapFromDomainRequest(DomainRetroRequest domainRequest);

    @Mapping(target = "retroDescription", source = "retroDescription")
    DomainRetroRequest mapToDomainRequest(RestRetroRequest restRequest);
}

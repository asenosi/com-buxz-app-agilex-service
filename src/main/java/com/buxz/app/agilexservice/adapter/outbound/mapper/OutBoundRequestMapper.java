package com.buxz.app.agilexservice.adapter.outbound.mapper;

import com.buxz.app.agilexservice.adapter.outbound.repository.OutboundRetroBoard;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OutBoundRequestMapper {

    OutBoundRequestMapper MAPPER = Mappers.getMapper(OutBoundRequestMapper.class);
    @Mapping(target = "dateCreated", source = "dateCreated")
    @Mapping(target = "boardCreator", source = "boardCreator")
    OutboundRetroBoard mapToOutbound(DomainRetroRequest domainRequest);
    DomainRetroRequest mapToDomain(OutboundRetroBoard outboundRetroBoard);
}

package com.buxz.app.agilexservice.adapter.outbound.mapper;

import com.buxz.app.agilexservice.adapter.outbound.repository.OutboundRetroBoard;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OutBoundRequestMapper {

    OutBoundRequestMapper MAPPER = Mappers.getMapper(OutBoundRequestMapper.class);
    @Mapping(target = "dateCreated", source = "dateCreated")
    @Mapping(target = "boardCreator", source = "boardCreator")
    @Mapping(target = "retroDescription", source = "retroDescription")
    @Mapping(target = "retroId", source = "retroId")
    OutboundRetroBoard mapToOutbound(DomainRetroRequest domainRequest);

    @Mapping(target = "dateCreated", source = "dateCreated")
    @Mapping(target = "boardCreator", source = "boardCreator")
    @Mapping(target = "retroDescription", source = "retroDescription")
    @Mapping(target = "retroId", source = "retroId")
    DomainRetroRequest mapToDomain(OutboundRetroBoard outboundRetroBoard);
}

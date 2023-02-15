package com.buxz.app.agilexservice.adapter.outbound.mapper;

import com.buxz.app.agilexservice.adapter.outbound.repository.OutboundRetroBoard;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import org.mapstruct.Mapper;

@Mapper
public interface OutBoundRequestMapper {
    OutboundRetroBoard mapToOutbound(DomainRetroRequest domainRequest);
    DomainRetroRequest mapToDomain(OutboundRetroBoard outboundRetroBoard);
}

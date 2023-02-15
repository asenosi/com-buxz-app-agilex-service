package com.buxz.app.agilexservice.adapter.outbound;

import com.buxz.app.agilexservice.adapter.outbound.mapper.OutBoundRequestMapper;
import com.buxz.app.agilexservice.adapter.outbound.repository.OutboundRetroBoard;
import com.buxz.app.agilexservice.adapter.outbound.repository.RetroBoardRepository;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoardMongoAdapter {

    private final RetroBoardRepository boardRepository;
    private final OutBoundRequestMapper requestMapper;

    @Autowired
    public BoardMongoAdapter(RetroBoardRepository boardRepository, OutBoundRequestMapper requestMapper) {
        this.boardRepository = boardRepository;
        this.requestMapper = requestMapper;
    }

    public DomainRetroRequest createNewRetroBoard(final DomainRetroRequest retroRequest) {
        log.info("CreateNewRetroBoard: Persisting the new board to the database");

        OutboundRetroBoard outboundRetroBoard = requestMapper.mapToOutbound(retroRequest);
        boardRepository.save(outboundRetroBoard);

        return requestMapper.mapToDomain(outboundRetroBoard);
    }

}

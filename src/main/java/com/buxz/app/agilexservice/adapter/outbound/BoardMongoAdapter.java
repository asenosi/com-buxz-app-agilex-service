package com.buxz.app.agilexservice.adapter.outbound;

import com.buxz.app.agilexservice.adapter.outbound.mapper.OutBoundRequestMapper;
import com.buxz.app.agilexservice.adapter.outbound.repository.OutboundRetroBoard;
import com.buxz.app.agilexservice.adapter.outbound.repository.RetroBoardRepository;
import com.buxz.app.agilexservice.domain.StatusEnum;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        log.info("CreateNewRetroBoard: Persisting the new board to the database: {}, {}, {}",
                retroRequest.getRetroTitle(), retroRequest.getBoardCreator(), retroRequest.getDateCreated());

        OutboundRetroBoard outboundRetroBoard = requestMapper.mapToOutbound(retroRequest);
        boardRepository.save(outboundRetroBoard);

        return requestMapper.mapToDomain(outboundRetroBoard);
    }

    public List<DomainRetroRequest> retrieveAllRetroSessions() {
        log.info("BoardMongoAdapter#retriveAllRetroSessions: Retrieve all retro sessions from MongoDb");
        List<OutboundRetroBoard> retroBoardList = boardRepository.findAll();
        return retroBoardList
                .stream()
                .map(requestMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    public Optional<DomainRetroRequest> findRetroSessionById(UUID id) {
        log.info("BoardMongoAdapter#findRetroSessionById: Retrieve retro session by id from MongoDb");
        return boardRepository.findByRetroId(id).map(requestMapper::mapToDomain);
    }

    public List<DomainRetroRequest> retrieveAllRetroSessionByStatus(StatusEnum status) {
        log.info("BoardMongoAdapter#retrieveAllRetroSessionByStatus: Retrieve retro session by id from MongoDb");
        return boardRepository.findAllByStatus(status);
    }
}

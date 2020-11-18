package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.BoardGame;
import com.example.boardGameApplication.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    BoardGameRepository boardGameRepository;

    @Autowired
    public BoardGameServiceImpl(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    @Override
    public BoardGame join(BoardGame boardGame) {
        validateDuplicatedGame(boardGame);
        boardGameRepository.save(boardGame);
        return boardGame;
    }

    private void validateDuplicatedGame(BoardGame boardGame) {
        boardGameRepository.findByGameName(boardGame.getGameName()).ifPresent(g -> {
            throw new IllegalStateException("이미 등록된 게임입니다");
        });
    }

    @Override
    public BoardGame findGame(Long gameId) {
        return boardGameRepository.findByGameId(gameId).get();
    }

    @Override
    public List<BoardGame> findAllGame() {
        return boardGameRepository.findAll();
    }
}

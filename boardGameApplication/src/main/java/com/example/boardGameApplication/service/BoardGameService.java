package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.BoardGame;

import java.util.List;

public interface BoardGameService {
    BoardGame join(BoardGame boardGame);
    BoardGame findGame(Long gameId);
    List<BoardGame> findAllGame();
}

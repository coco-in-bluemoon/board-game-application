package com.example.boardGameApplication.repository;

import com.example.boardGameApplication.domain.BoardGame;

import java.util.List;
import java.util.Optional;

public interface BoardGameRepository {
    void save(BoardGame boardGame);
    Optional<BoardGame> findByGameId(Long gameId);
    Optional<BoardGame> findByGameName(String gameName);
    List<BoardGame> findAll();
}

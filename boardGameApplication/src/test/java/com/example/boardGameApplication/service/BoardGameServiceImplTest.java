package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.BoardGame;
import com.example.boardGameApplication.repository.BoardGameRepository;
import com.example.boardGameApplication.repository.MemoryBoardGameRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardGameServiceImplTest {

    MemoryBoardGameRepository boardGameRepository;
    BoardGameService boardGameService;

    @BeforeEach
    void beforeEach() {
        boardGameRepository = new MemoryBoardGameRepository();
        boardGameService = new BoardGameServiceImpl(boardGameRepository);
    }

    @AfterEach
    void afterEach() {
        boardGameRepository.clearStore();
    }

    @Test
    void join() {
        BoardGame boardGame = new BoardGame();
        boardGame.setGameName("Game A");

         boardGameService.join(boardGame);
        BoardGame resultBoardGame = boardGameService.findGame(boardGame.getGameId());

        assertThat(resultBoardGame).isEqualTo(boardGame);
    }

    @Test
    @DisplayName("중복된 이름의 게임을 저장하는 경우 에러가 발생합니다.")
    void duplicatedJoin() {
        BoardGame boardGame1 = new BoardGame();
        boardGame1.setGameName("Game A");

        BoardGame boardGame2 = new BoardGame();
        boardGame2.setGameName("Game A");

        boardGameService.join(boardGame1);
        assertThrows(IllegalStateException.class, () -> boardGameService.join(boardGame2));
    }

}
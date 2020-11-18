package com.example.boardGameApplication.repository;

import com.example.boardGameApplication.domain.BoardGame;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBoardGameRepository implements BoardGameRepository {

    private static Map<Long, BoardGame> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(BoardGame boardGame) {
        boardGame.setGameId(++sequence);
        store.put(boardGame.getGameId(), boardGame);
    }

    @Override
    public Optional<BoardGame> findByGameId(Long gameId) {
        return Optional.ofNullable(store.get(gameId));
    }

    @Override
    public Optional<BoardGame> findByGameName(String gameName) {
        return store.values().stream()
                .filter(boardGame -> boardGame.getGameName().equals(gameName))
                .findAny();
    }

    @Override
    public List<BoardGame> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

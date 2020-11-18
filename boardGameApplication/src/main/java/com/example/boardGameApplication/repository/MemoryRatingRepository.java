package com.example.boardGameApplication.repository;

import com.example.boardGameApplication.domain.BoardGame;
import com.example.boardGameApplication.domain.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryRatingRepository implements RatingRepository {

    private static Map<Long, Rating> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Rating rating) {
        rating.setGameId(++sequence);
        store.put(rating.getGameId(), rating);
    }

    @Override
    public List<Rating> findByGameId(Long gameId) {
        return store.values().stream()
                .filter(rating -> rating.getGameId().equals(gameId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Rating> findByMemberId(Long memberId) {
        return store.values().stream()
                .filter(rating -> rating.getGameId().equals(memberId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Rating> findAll() {
        return new ArrayList<>(store.values());
    }
}

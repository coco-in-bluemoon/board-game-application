package com.example.boardGameApplication.repository;

import com.example.boardGameApplication.domain.Rating;

import java.util.List;

public interface RatingRepository {
    void save(Rating rating);
    List<Rating> findByMemberId(Long memberId);
    List<Rating> findByGameId(Long gameId);
    List<Rating> findAll();
}

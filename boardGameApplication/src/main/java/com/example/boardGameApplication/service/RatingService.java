package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.Rating;

import java.util.List;

public interface RatingService {
    Rating rate(Rating rating);
    List<Rating> searchByMember(Long memberId);
    List<Rating> searchByGame(Long gameId);
    List<Rating> searchAll();
}

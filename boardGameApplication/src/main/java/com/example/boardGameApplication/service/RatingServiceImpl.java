package com.example.boardGameApplication.service;

import com.example.boardGameApplication.domain.Rating;
import com.example.boardGameApplication.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating rate(Rating rating) {
        validateDuplicatedRating(rating);
        ratingRepository.save(rating);
        return rating;
    }

    private void validateDuplicatedRating(Rating rating) {
        List<Rating> sameGameRating = ratingRepository.findByGameId(rating.getGameId());
        for (Rating sameRating : sameGameRating) {
            if (sameRating.getMemberId().equals(rating.getMemberId())) {
                throw new IllegalStateException("사용자는 이미 게임을 평가하였습니다.");
            }
        }
    }

    @Override
    public List<Rating> searchByMember(Long memberId) {
        return ratingRepository.findByMemberId(memberId);
    }

    @Override
    public List<Rating> searchByGame(Long gameId) {
        return ratingRepository.findByGameId(gameId);
    }

    @Override
    public List<Rating> searchAll() {
        return ratingRepository.findAll();
    }
}

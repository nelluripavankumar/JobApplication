package com.pachu.FirstJob.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findAllReviews(Long id);

    List<Review> findAll();

    void createReview(Long companyId, Review review);

    boolean deleteReviewById(Long id);

    boolean editReviewById(Long id,Review review);
}

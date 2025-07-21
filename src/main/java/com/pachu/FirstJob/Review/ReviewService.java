package com.pachu.FirstJob.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long CompanyId);

    List<Review> findReviewsId(Long id, Long reviewId);

    List<Review> findAll();

    void createReview(Long companyId, Review review);

    boolean deleteReviewById(Long id);

    boolean editReviewById(Long id,Review review);
}

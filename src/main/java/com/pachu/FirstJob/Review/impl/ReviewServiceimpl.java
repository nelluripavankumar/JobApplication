package com.pachu.FirstJob.Review.impl;

import com.pachu.FirstJob.Company.Company;
import com.pachu.FirstJob.Company.CompanyService;
import com.pachu.FirstJob.Review.Review;
import com.pachu.FirstJob.Review.ReviewRepository;
import com.pachu.FirstJob.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceimpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceimpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAllReviews(Long CompanyId) {
        return reviewRepository.findByCompanyId(CompanyId);
    }

    @Override
    public List<Review> findReviewsId(Long companyId, Long reviewId) {
        List<Review> r = reviewRepository.findByCompanyId(companyId);

        return r;
    }

    @Override
    public List<Review> findAll() {

        return reviewRepository.findAll();
    }

    @Override
    public void createReview(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }

    @Override
    public boolean deleteReviewById(Long id) {
        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean editReviewById(Long id,Review review) {
        if(reviewRepository.existsById(id)){
            Optional<Review> r = reviewRepository.findById(id);
            Review t = r.get();
            t.setTitle(review.getTitle());
            t.setRating(review.getRating());
            t.setDescription(review.getDescription());
            reviewRepository.save(t);
            return true;
        }
        return false;
    }
}

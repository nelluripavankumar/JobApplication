package com.pachu.FirstJob.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequestMapping("/companies/{companyId}")
@RestController
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public List<Review> findall(){
        return reviewService.findAll();
    }
    @GetMapping
    public ResponseEntity<Review> findreviewById(@PathVariable Long comanyId){
        Optional<Review> r = reviewService.findAllReviews(comanyId);
        if(r.isPresent())
            return new ResponseEntity<>(r.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review){
        reviewService.createReview(companyId,review);
        return new ResponseEntity<>("Review Created Successfully",HttpStatus.CREATED);
    }
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
        boolean f = reviewService.deleteReviewById(id);
        if(f)
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<>("Id not found in the Reviews so Delete Not Possible",HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity<String> editReviewById(@PathVariable Long id,@RequestBody Review review){
        boolean f = reviewService.editReviewById(id,review);
        if(f)
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<>("Id not found in the Reviews so Updated can't Possible",HttpStatus.NOT_FOUND);
    }
}

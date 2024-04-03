package com.nocaffeine.ssgclone.review.infrastructure;

import com.nocaffeine.ssgclone.review.domain.Review;
import com.nocaffeine.ssgclone.review.domain.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
    List<ReviewImage> findByReview(Review review);
}

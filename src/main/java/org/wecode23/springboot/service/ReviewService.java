package org.wecode23.springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wecode23.springboot.domain.products.repositories.ProductRepository;
import org.wecode23.springboot.domain.reviews.entities.Review;
import org.wecode23.springboot.domain.reviews.entities.repositories.ReviewRepository;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.ReviewResponseDto;
import org.wecode23.springboot.dto.ReviewSaveRequestDto;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long createReview(ReviewSaveRequestDto requestDto) {

        requestDto.setUser(userRepository.findById(requestDto.getUserId()).get());
        requestDto.setProduct(productRepository.findById(requestDto.getProductId()).get());

        return reviewRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long deleteReview(Long id) {

        reviewRepository.deleteById(id);

        return id;
    }

    @Transactional
    public Long updateReview(Long id, ReviewSaveRequestDto requestDto) {
        Review review = reviewRepository.findById(id).get();
        review.updateReview(requestDto.getComment(), requestDto.getTitle());

        return id;

    }

    public List<ReviewResponseDto> getReviewList(Long id) {
        List<Review> reviewList = reviewRepository.findByProductId(id);
        List<ReviewResponseDto> reviewResponseDtoList = new ArrayList<>();
        if (!reviewList.isEmpty()) {
            for (Review review : reviewList) {
                ReviewResponseDto reviewResponseDto = new ReviewResponseDto(review);
                reviewResponseDtoList.add(reviewResponseDto);
            }
        }
        return reviewResponseDtoList;
    }
}

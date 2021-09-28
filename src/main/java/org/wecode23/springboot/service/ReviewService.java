package org.wecode23.springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wecode23.springboot.domain.products.repositories.ProductRepository;
import org.wecode23.springboot.domain.reviews.entities.Review;
import org.wecode23.springboot.domain.reviews.entities.repositories.ReviewRepository;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.ReviewSaveRequestDto;

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

}

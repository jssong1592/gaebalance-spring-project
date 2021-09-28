package org.wecode23.springboot.domain.reviews.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.reviews.entities.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductId(Long id);

}

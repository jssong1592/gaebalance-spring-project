package org.wecode23.springboot.web;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecode23.springboot.domain.reviews.entities.Review;
import org.wecode23.springboot.domain.reviews.entities.repositories.ReviewRepository;
import org.wecode23.springboot.dto.ReviewSaveRequestDto;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ReviewRepository reviewRepository;

    @After
    public void tearDown() throws Exception {
        reviewRepository.deleteAll();
    }

    @Test
    public void ReviewCreate() throws Exception {
        //given
        Long userId = 1L;
        Long productId = 1L;
        Integer sizeRating = 3;
        Integer colorRating= 3;
        Integer deliveryRating = 3;
        String title = "마음에 들어요";
        String comment = "그럭저럭이에요";

        ReviewSaveRequestDto requestDto = ReviewSaveRequestDto.builder()
                .userId(userId)
                .productId(productId)
                .sizeRating(sizeRating)
                .colorRating(colorRating)
                .deliveryRating(deliveryRating)
                .title(title)
                .comment(comment)
                .build();

        String url = "http://localhost:" + port + "reviews";

        //when
        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, requestDto, HashMap.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody().get("MESSAGE")).isEqualTo("CREATED");
        List<Review> all = reviewRepository.findAll();
        assertThat(all.get(all.size()-1).getTitle()).isEqualTo(title);
    }

}

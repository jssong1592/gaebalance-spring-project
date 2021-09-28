package org.wecode23.springboot.web;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecode23.springboot.dto.ReviewSaveRequestDto;
import org.wecode23.springboot.service.ReviewService;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class ReviewApiController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<HashMap> createReview(@RequestBody ReviewSaveRequestDto requestDto) {

        reviewService.createReview(requestDto);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);

    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<HashMap> deleteReview(@PathVariable Long id){

        reviewService.deleteReview(id);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.OK);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}

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
import org.wecode23.springboot.domain.products.repositories.ProductRepository;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ProductViewTest() throws Exception {
        //given
        int i = 1;
        Long id = new Long(i);

        String url = "http://localhost:" + port + "products/" + id;

        //when
        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(url, HashMap.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().get("id")).isEqualTo(1);


    }

}

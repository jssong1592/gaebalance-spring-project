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
import org.wecode23.springboot.domain.products.repositories.SizeRepository;
import org.wecode23.springboot.domain.users.entities.User;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.UserSaveRequestDto;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteById(userRepository.findAll().get(userRepository.findAll().size()-1).getId());
    }

    @Test
    public void UserSignUp() throws Exception {
        //given
        String name = "곽국광";
        Boolean gender = true;
        String birthDate = "1999-03-14";
        String phoneNumber = "010-3325-7534";
        String email = "greatkwaw@gmail.com";
        String password = "testtest123";
        String address = "서울시 여러분 담배꽁초";
        Integer sizeId = 1;

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .gender(gender)
                .birthDate(LocalDate.parse(birthDate))
                .phoneNumber(phoneNumber)
                .email(email)
                .password(password)
                .address(address)
                .sizeId(Long.valueOf(sizeId))
                .build();

        String url = "http://localhost:" + port + "signup";

        //when
        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, requestDto, HashMap.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody().get("MESSAGE")).isEqualTo("CREATED");
        List<User> all = userRepository.findAll();
        assertThat(all.get(all.size()-1).getName()).isEqualTo(name);
        assertThat(all.get(all.size()-1).getSize().getName()).isEqualTo("S");

    }
}

package org.wecode23.springboot.dto;

import lombok.Getter;
import org.wecode23.springboot.domain.users.entities.User;

import java.time.LocalDate;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Boolean gender;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String size;

    public UserResponseDto(User entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.gender = entity.getGender();
        this.birthDate = entity.getBirthDate();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.size = entity.getSize().getName();

    }

}

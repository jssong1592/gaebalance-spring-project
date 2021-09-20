package org.wecode23.springboot.dto;


import lombok.Getter;
import org.wecode23.springboot.domain.users.entities.User;
import org.wecode23.springboot.domain.products.entities.Size;

import java.util.Date;

@Getter
public class UsersResponseDto {

    private Long id;
    private String name;
    private Boolean gender;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String size;

    public UsersResponseDto(User entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.gender = entity.getGender();
        this.birthDate = entity.getBirthDate();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.size = entity.getSize().getName();

    }

}

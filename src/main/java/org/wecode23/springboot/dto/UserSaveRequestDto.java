package org.wecode23.springboot.dto;

import lombok.*;
import org.wecode23.springboot.domain.products.entities.Size;
import org.wecode23.springboot.domain.users.entities.User;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class UserSaveRequestDto {
    private String name;
    private Boolean gender;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    @Setter
    private String password;
    private String address;
    private Long sizeId;
    @Setter
    private Size size;

    @Builder
    public UserSaveRequestDto(String name, Boolean gender, LocalDate birthDate,
                              String phoneNumber, String email, String password,
                              String address, Long sizeId){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.address = address;
        this.sizeId = sizeId;

    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .gender(gender)
                .birthDate(birthDate)
                .phoneNumber(phoneNumber)
                .email(email)
                .password(password)
                .address(address)
                .size(size)
                .build();
    }

}

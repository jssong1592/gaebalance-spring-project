package org.wecode23.springboot.domain.users.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import org.wecode23.springboot.domain.products.entities.Color;
import org.wecode23.springboot.domain.products.entities.Size;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"phone_number","email"}
                )
        }
        )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToMany
    @JoinTable(name = "users_colors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> color;

    @Builder
    public User(String name, Boolean gender, LocalDate birthDate,
                String phoneNumber, String email, String password,
                String address, Size size) {

        this.name        = name;
        this.gender      = gender;
        this.birthDate   = birthDate;
        this.phoneNumber = phoneNumber;
        this.email       = email;
        this.password    = password;
        this.address     = address;
        this.size        = size;

    }
}

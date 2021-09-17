package org.wecode23.springboot.domain.products.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category", length = 45, nullable = false)
    private String category;

    @Builder
    public Category(String category) {

        this.category = category;

    }
}

package org.wecode23.springboot.domain.products.entities;

import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_categories")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @Column(name = "sub_category", length = 45, nullable = false)
    private String subCategory;

}

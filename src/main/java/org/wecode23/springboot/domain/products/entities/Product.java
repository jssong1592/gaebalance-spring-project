package org.wecode23.springboot.domain.products.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "price", precision = 2, nullable = false)
    private Double price;

    @Column(name = "style_code")
    private String styleCode;

    @Column(name = "origin")
    private String origin;

    @Column(name = "manufacture_date", nullable = false)
    private LocalDate manufactureDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 2000)
    private String imageUrl;

    @Column(name = "group", length = 45)
    private String group;

    @Builder
    public Product(SubCategory subCategory, Color color, String name,
                   Double price, String styleCode, String origin,
                   LocalDate manufactureDate, String description, String imageUrl,
                   String group) {

        this.subCategory     = subCategory;
        this.color           = color;
        this.name            = name;
        this.price           = price;
        this.styleCode       = styleCode;
        this.origin          = origin;
        this.manufactureDate = manufactureDate;
        this.description     = description;
        this.imageUrl        = imageUrl;
        this.group           = group;

    }
}

package org.wecode23.springboot.domain.products.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private Category subCategory;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "price", precision = 2, nullable = false)
    private Double price;

    @Column(name = "style_code")
    private String styleCode;

    @Column(name = "manufacture_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 2000)
    private String imageUrl;

    @Column(name = "group", length = 45)
    private String group;

}

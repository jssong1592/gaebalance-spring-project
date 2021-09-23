package org.wecode23.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import org.wecode23.springboot.domain.products.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductResponseDto {

    private Long id;
    private String name;
    private Double price;
    private String styleCode;
    private String origin;
    private LocalDate manufactureDate;
    private String description;
    private String imageUrl;
    @Setter
    private ArrayList<String> imageList;
    private String color;
    private String subCategory;
    private String category;

    public ProductResponseDto(Product entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.styleCode = entity.getStyleCode();
        this.origin = entity.getOrigin();
        this.manufactureDate = entity.getManufactureDate();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.color = entity.getColor().getName();
        this.subCategory = entity.getSubCategory().getSubCategory();
        this.category = entity.getSubCategory().getCategory().getCategory();

    }

}

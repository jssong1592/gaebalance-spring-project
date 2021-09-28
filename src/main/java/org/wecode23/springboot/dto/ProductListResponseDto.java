package org.wecode23.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.products.entities.ProductOption;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class ProductListResponseDto {

    private Long id;
    private String name;
    private String imageUrl;
    private Double price;
    private LocalDate manufactureDate;
    private Integer stock = 0;

    public ProductListResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.manufactureDate = entity.getManufactureDate();

        Set<ProductOption> productOptionSet = entity.getProductOptionSet();
        for (ProductOption productOption:productOptionSet) {
            this.stock += productOption.getStock();
        }
    }

}

package org.wecode23.springboot.domain.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.products.entities.DetailImage;
import org.wecode23.springboot.domain.products.entities.Product;

import java.util.List;

public interface DetailImageRepository extends JpaRepository<DetailImage, Long> {

    List<DetailImage> findByProduct(Product product);
}

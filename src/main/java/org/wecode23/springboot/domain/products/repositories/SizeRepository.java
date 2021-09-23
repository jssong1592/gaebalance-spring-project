package org.wecode23.springboot.domain.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.products.entities.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
}
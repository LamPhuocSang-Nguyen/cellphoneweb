package com.example.cellphoneweb.repositorise;

import com.example.cellphoneweb.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findByProduct_ProductId(int productId);
    void deleteById(int imageId);
}

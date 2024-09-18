package com.example.cellphoneweb.services;

import com.example.cellphoneweb.dtos.ProductImageDTO;
import com.example.cellphoneweb.models.ProductImage;
import com.example.cellphoneweb.models.Products;
import com.example.cellphoneweb.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Products getProductById(int product_id);
    Page<ProductResponse> getProduct(Pageable pageable);
    ProductImage saveProductImage(int product_id, ProductImageDTO productImageDTO);
    List<ProductImage> getAllProductImages(int product_id);
    void deleteProductImage(int imageId);
}

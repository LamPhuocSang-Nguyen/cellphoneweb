package com.example.cellphoneweb.services;

import com.example.cellphoneweb.dtos.ProductImageDTO;
import com.example.cellphoneweb.models.ProductImage;
import com.example.cellphoneweb.models.Products;
import com.example.cellphoneweb.repositorise.ProductImageRepository;
import com.example.cellphoneweb.repositorise.ProductRepository;
import com.example.cellphoneweb.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    public Products getProductById(int product_id) {
        return productRepository.findById(product_id).orElseThrow(() -> new IllegalArgumentException("Product with ID " + product_id + " not found"));
    }

    @Override
    public Page<ProductResponse> getProduct(Pageable pageable) {
        Page<Products> products = productRepository.findAll(pageable);
        return products.map(ProductResponse::fromProduct);
    }

    @Override
    public ProductImage saveProductImage(int product_id, ProductImageDTO productImageDTO) {
        Products product = getProductById(product_id);
        ProductImage productImage = ProductImage.builder()
                .product(product)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        int size = productImageRepository.findByProduct_ProductId(product_id).size();
        if(size > 4){
            throw new IllegalArgumentException("Product image is more than 4");
        }
        return productImageRepository.save(productImage);
    }

    @Override
    public List<ProductImage> getAllProductImages(int product_id) {
        return productImageRepository.findByProduct_ProductId(product_id);
    }

    @Override
    public void deleteProductImage(int imageId) {
        productImageRepository.deleteById(imageId);
    }
}

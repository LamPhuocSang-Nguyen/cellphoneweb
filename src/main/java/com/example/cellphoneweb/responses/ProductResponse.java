package com.example.cellphoneweb.responses;

import com.example.cellphoneweb.models.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends BaseResponse {
    private long productId;
    private String productName;
    private String productDescription;
    private double price;
    private long quantityInStock;

    public static ProductResponse fromProduct(ProductEntity product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .price(product.getPrice().doubleValue())
                .quantityInStock(product.getQuantityInStock())
                .build();
    }
}

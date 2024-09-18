package com.example.cellphoneweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    @NotBlank(message = "Tên sản phâm không được để trống")
    @Size(min = 2 ,max = 50, message = "Tên sản phẩm phải có từ 2 đến 50 ký tự")
    private String productName;

    @NotBlank(message = "Trường mô tả sản phẩm không được để trống")
    private String productDescription;

    @NotBlank(message = "Giá của sản phẩm không được bỏ trống")
    private double price;

//    private int categoryId;

    @NotNull(message = "Xep loai khong duoc trong")
    private int quantityInStock;
}

package com.example.cellphoneweb.repositorise;

import com.example.cellphoneweb.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}

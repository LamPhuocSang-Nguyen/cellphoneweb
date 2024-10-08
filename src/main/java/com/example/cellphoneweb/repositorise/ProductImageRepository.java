package com.example.cellphoneweb.repositorise;

import com.example.cellphoneweb.models.ImageProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ImageProductEntity, Long> {
    List<ImageProductEntity> findByProduct_Id(Long id);
    void deleteById(Long id);
}

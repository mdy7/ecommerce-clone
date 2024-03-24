package com.nocaffeine.ssgclone.product.infrastructure;

import com.nocaffeine.ssgclone.product.domain.OptionSelectedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionSelectedProductRepository extends JpaRepository<OptionSelectedProduct, Long> {

    List<OptionSelectedProduct> findByProductId(Long id);

    @Query("SELECT po FROM OptionSelectedProduct po JOIN FETCH po.product JOIN FETCH po.sizeOption JOIN FETCH po.colorOption JOIN FETCH po.addOption WHERE po.id = :id")
    Optional<OptionSelectedProduct> findById(@Param("id") Long id);
}
package com.nocaffeine.ssgclone.domain.product.dto.response.product;

import com.nocaffeine.ssgclone.domain.category.domain.ProductCategoryList;
import com.nocaffeine.ssgclone.domain.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductIdListResponseDto {

    private Long id;
    private Long productId;

    public static ProductIdListResponseDto fromProductIdListResponseDto(ProductCategoryList productCategoryList) {
        Product product = productCategoryList.getProduct();
        return ProductIdListResponseDto.builder()
                .id(productCategoryList.getId())
                .productId(product.getId())
                .build();
    }
}

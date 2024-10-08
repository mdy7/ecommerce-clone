package com.nocaffeine.ssgclone.domain.product.dto.response.producttotal;

import com.nocaffeine.ssgclone.domain.product.domain.Product;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalResponseDto {

    // Total 엔티티의 필드들을 가져온다.
    private Long id;
    private Product product;
    private int sales;
    private Double rateAverage;
    private int reviewCount;
}

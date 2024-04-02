package com.nocaffeine.ssgclone.brandstore.presentation;

import com.nocaffeine.ssgclone.brandstore.application.BrandService;
import com.nocaffeine.ssgclone.brandstore.dto.BrandResponse;
import com.nocaffeine.ssgclone.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class BrandController {

    private final BrandService brandService;
    @Operation(summary = "상품 브랜드 조회", description = "상품 브랜드 조회", tags = {"Product"})
    @GetMapping("/{productId}/brand")
    public CommonResponse<BrandResponse> brandList(@PathVariable Long productId){
        BrandResponse brandResponse = brandService.findBrand(productId);
        return CommonResponse.success("브랜드를 성공적으로 찾았습니다.",brandResponse);
    }
}

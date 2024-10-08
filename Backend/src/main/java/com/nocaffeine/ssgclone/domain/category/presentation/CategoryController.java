package com.nocaffeine.ssgclone.domain.category.presentation;

import com.nocaffeine.ssgclone.domain.category.application.CategoryService;
import com.nocaffeine.ssgclone.common.CommonResponse;
import com.nocaffeine.ssgclone.domain.category.vo.response.CategoryResponseVo;
import com.nocaffeine.ssgclone.domain.category.vo.response.LargeCategoryResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    //대분류 조회
    @Operation(summary = "대카테고리 조회", description = "대카테고리 조회", tags = {"Category"})
    @GetMapping("/large")
    public CommonResponse<List<LargeCategoryResponseVo>> largeCategoryList(){
;
        return CommonResponse.success("LargeCategory 를 성공적으로 찾았습니다.", LargeCategoryResponseVo.convertToVo(categoryService.findLargeCategories()));
    }

    //중분류 조회
    @Operation(summary = "중카테고리 조회", description = "중카테고리 조회", tags = {"Category"})
    @GetMapping("/{largeId}/medium")
    public CommonResponse<List<CategoryResponseVo>> midCategoryList(@PathVariable("largeId") Long largeId) {
;
        return CommonResponse.success("MediumCategory 를 성공적으로 찾았습니다.", CategoryResponseVo.convertToVo(categoryService.findMediumCategories(largeId)));
    }
    // 소분류 조회
    @Operation(summary = "소카테고리 조회", description = "소카테고리 조회", tags = {"Category"})
    @GetMapping("/{mediumId}/small")
    public CommonResponse<List<CategoryResponseVo>> smallCategoryList(@PathVariable("mediumId") Long mediumId) {

        return CommonResponse.success("SmallCategory 를 성공적으로 찾았습니다.",CategoryResponseVo.convertToVo(categoryService.findSmallCategories(mediumId)));
    }
    // 소분류 + 소소분류
    @Operation(summary = "소소카테고리 조회", description = "소소카테고리 조회", tags = {"Category"})
    @GetMapping("/{smallId}/tiny")
    public CommonResponse<List<CategoryResponseVo>> tinyCategoryList(@PathVariable("smallId") Long smallId) {

        return CommonResponse.success("TinyCategory 를 성공적으로 찾았습니다.", CategoryResponseVo.convertToVo(categoryService.findTinyCategories(smallId)));
    }




}

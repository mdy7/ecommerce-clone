package com.nocaffeine.ssgclone.domain.category.domain;

import com.nocaffeine.ssgclone.domain.product.domain.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ProductCategoryList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private LargeCategory largeCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private MediumCategory mediumCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private SmallCategory smallCategory;

    @Column(name = "tiny_category_id")
    private Long tinyCategory;


    @Builder
    public ProductCategoryList(Product product, LargeCategory largeCategory, MediumCategory mediumCategory, SmallCategory smallCategory, Long tinyCategory) {
        this.product = product;
        this.largeCategory = largeCategory;
        this.mediumCategory = mediumCategory;
        this.smallCategory = smallCategory;
        this.tinyCategory = tinyCategory;
    }

}

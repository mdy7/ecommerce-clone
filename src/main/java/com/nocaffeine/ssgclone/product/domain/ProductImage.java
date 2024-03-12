package com.nocaffeine.ssgclone.product.domain;

import com.nocaffeine.ssgclone.image.domain.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Image image;

    @ManyToOne
    @NotNull
    private Product product;

    @NotNull
    private int thumbnail;

    @NotNull
    private int thumbnailNumber;


}

package com.nocaffeine.ssgclone.domain.questions.domain;

import com.nocaffeine.ssgclone.common.BaseTimeEntity;
import com.nocaffeine.ssgclone.domain.product.domain.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class questions extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Product product;

    @Column(name = "member_id")
    @NotNull
    private Long member;

    @NotNull
    private int type;

    @NotNull
    @Column(length = 255)
    private String title;

    @NotNull
    @Column(length = 500)
    private String content;

    @NotNull
    private int status;
}

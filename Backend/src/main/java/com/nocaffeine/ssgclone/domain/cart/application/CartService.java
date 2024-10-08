package com.nocaffeine.ssgclone.domain.cart.application;


import com.nocaffeine.ssgclone.domain.cart.dto.request.CartAddRequestDto;
import com.nocaffeine.ssgclone.domain.cart.dto.response.CartCountResponseDto;
import com.nocaffeine.ssgclone.domain.cart.dto.response.CartListResponseDto;
import com.nocaffeine.ssgclone.domain.cart.dto.response.CartPriceResponseDto;
import com.nocaffeine.ssgclone.domain.member.domain.Member;

import java.util.List;


public interface CartService {

    void addCart(CartAddRequestDto cartAddRequestDto, Member member);

    void removeCartList(List<Long> cartId);
    void removeCart(Long cartId);

    void increaseCount(Long cartId);
    void decreaseCount(Long cartId);

    void checkCart(Long cartId);
    void unCheckCart(Long cartId);

    List<CartListResponseDto> findCart(Member member);
    List<CartListResponseDto> findCheckedCart(Member member);

    CartCountResponseDto totalCountCart(Member member);
    CartPriceResponseDto findTotalPrice(List<Long> cartId);


}

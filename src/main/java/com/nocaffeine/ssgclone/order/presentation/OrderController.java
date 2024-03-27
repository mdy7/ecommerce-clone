package com.nocaffeine.ssgclone.order.presentation;

import com.nocaffeine.ssgclone.common.CommonResponse;
import com.nocaffeine.ssgclone.common.security.JwtTokenProvider;
import com.nocaffeine.ssgclone.order.application.OrderService;
import com.nocaffeine.ssgclone.order.dto.MemberOrderSaveDto;
import com.nocaffeine.ssgclone.order.dto.OrderedProductDto;
import com.nocaffeine.ssgclone.order.vo.request.MemberOrderProductRequestVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final JwtTokenProvider jwtTokenProvider;

    //회원 주문
    //주문상품id랑 총 개수 받아와야함 리스트로
    @PostMapping("/member")
    public CommonResponse<String> memberOrderAdd(@RequestBody @Valid MemberOrderProductRequestVo memberOrderProductRequestVo) {

        String token = jwtTokenProvider.getHeader();
        String memberUuid = jwtTokenProvider.validateAndGetUserUuid(token);

        //vo를 dto로 변환
        MemberOrderSaveDto memberOrderSaveDto = MemberOrderSaveDto.convertToDto(memberUuid, memberOrderProductRequestVo);

        orderService.addMemberOrder(memberOrderSaveDto);

        return CommonResponse.success("주문이 완료되었습니다.");

    }


}
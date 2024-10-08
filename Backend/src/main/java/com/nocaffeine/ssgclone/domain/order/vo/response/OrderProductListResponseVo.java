package com.nocaffeine.ssgclone.domain.order.vo.response;

import com.nocaffeine.ssgclone.domain.order.dto.response.OrderProductListResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class OrderProductListResponseVo {

    private String productName;
    private String addOption;
    private String color;
    private String size;
    private int count;
    private int price;
    private String brand;
    private String thumbnail;
    private String orderNumber;
    private String region;

    public OrderProductListResponseVo(String productName, String addOption, String color, String size, int count, int price, String brand, String thumbnail,String orderPhoneNumber,String region) {
        this.productName = productName;
        this.addOption = addOption;
        this.color = color;
        this.size = size;
        this.count = count;
        this.price = price;
        this.brand = brand;
        this.thumbnail = thumbnail;
        this.orderNumber = orderPhoneNumber;
        this.region = region;

    }


    public static OrderProductListResponseVo convertToVo(OrderProductListResponseDto orderProductListResponseDto) {
        return new OrderProductListResponseVo(
                orderProductListResponseDto.getProductName(),
                orderProductListResponseDto.getAddOption(),
                orderProductListResponseDto.getColor(),
                orderProductListResponseDto.getSize(),
                orderProductListResponseDto.getCount(),
                orderProductListResponseDto.getPrice(),
                orderProductListResponseDto.getBrand(),
                orderProductListResponseDto.getThumbnail(),
                orderProductListResponseDto.getOrderPhoneNumber(),
                orderProductListResponseDto.getRegion()
        );
    }

}

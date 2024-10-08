package com.nocaffeine.ssgclone.domain.product.dto.request.viewhistory;

import com.nocaffeine.ssgclone.domain.product.vo.request.viewhistory.ViewHistoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더는 객체를 생성할 때 사용하는데, 생성자를 사용하지 않고 객체를 생성할 수 있다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewHistoryRequestDto {

    private Long id;
    private Long productId;

    public static ViewHistoryRequestDto viewHistoryVoToDto(ViewHistoryRequestVo viewHistoryRequestVo) {
        return ViewHistoryRequestDto.builder()
                .productId(viewHistoryRequestVo.getProductId())
                .build();
    }
}

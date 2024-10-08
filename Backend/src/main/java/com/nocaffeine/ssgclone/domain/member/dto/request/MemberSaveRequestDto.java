package com.nocaffeine.ssgclone.domain.member.dto.request;

import com.nocaffeine.ssgclone.domain.member.vo.request.MemberSaveRequestVo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSaveRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 주소가 올바르지 않습니다. 이메일 주소를 정확하게 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "휴대폰번호 번호를 입력해 주세요")
    private String phoneNumber;

    public static MemberSaveRequestDto voToDto(MemberSaveRequestVo memberSaveRequestVo) {
        return MemberSaveRequestDto.builder()
                .email(memberSaveRequestVo.getEmail())
                .password(memberSaveRequestVo.getPassword())
                .name(memberSaveRequestVo.getName())
                .phoneNumber(memberSaveRequestVo.getPhoneNumber())
                .build();
    }
}


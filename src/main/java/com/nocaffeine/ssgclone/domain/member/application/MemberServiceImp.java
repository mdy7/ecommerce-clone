package com.nocaffeine.ssgclone.domain.member.application;

import com.nocaffeine.ssgclone.common.exception.BaseException;
import com.nocaffeine.ssgclone.domain.member.domain.Member;
import com.nocaffeine.ssgclone.domain.member.dto.request.MemberPasswordRequestDto;
import com.nocaffeine.ssgclone.domain.member.dto.response.MemberDetailResponseDto;
import com.nocaffeine.ssgclone.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nocaffeine.ssgclone.common.exception.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberServiceImp implements MemberService {


    private final MemberRepository memberRepository;




    /**
     * 비밀번호 변경
     */
    @Override
    @Transactional
    public void updatePassword(String memberUuid, MemberPasswordRequestDto memberPasswordRequestDto) {
        Member member = memberRepository.findByUuid(memberUuid)
                .orElseThrow(() -> new BaseException(NO_EXIST_MEMBERS));

        if(!memberPasswordRequestDto.password.equals(memberPasswordRequestDto.getPasswordCheck())){
            throw new BaseException(FAILED_TO_PASSWORD);
        }

        Member newMember = Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(memberPasswordRequestDto.getPassword())
                .uuid(member.getUuid())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .address(member.getAddress())
                .build();

        newMember.hashPassword(memberPasswordRequestDto.getPassword());

        memberRepository.save(newMember);
    }

    /**
     * 회원 정보 조회
     */
    @Override
    public MemberDetailResponseDto findMember(Member member) {
        return MemberDetailResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }


    /**
     * 회원 탈퇴
     */
    @Override
    @Transactional
    public void removeMember(String memberUuid) {
        Member member = memberRepository.findByUuid(memberUuid)
                .orElseThrow(() -> new BaseException(NO_EXIST_MEMBERS));

        memberRepository.save(Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .uuid(member.getUuid())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .address(member.getAddress())
                .status(true)
                .build()
        );
    }

}


package jpabook.orignal_jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.orignal_jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /*
    // 로그인
    public Member findOne(String email, String pwd) {
        return memberRepository.findOne(email, pwd);
    }
     */

    // 회원가입
    @Transactional //변경
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 찾기
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    // 캐시 충전
    // 학교 주위 브랜드 조회
    // 친구 email -> 선물 보내기


    /*@Transactional
    public Long charge(Member member, Long cache) {
        member.get
    }*/
}
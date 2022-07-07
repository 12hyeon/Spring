package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링에서 관리
public class MemberController {

    // 1) 생성자 주입
    private final MemberService memberService;

    @Autowired // 스프링에서 알아서 연결시킴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 2) 필드 주입
    // @Autowired private final MemberService memberService;

    // 3) setter 주입
/*
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
 */

    @GetMapping(value = "/members/new") // get
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new") // post
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // 홈 화면으로
    }

    @GetMapping(value = "/members") // get
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // members(회원의 묶음)가 키로 넘어감
        return "members/memberList";
    }
}

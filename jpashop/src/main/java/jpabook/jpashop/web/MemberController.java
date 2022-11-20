package jpabook.orignal_jpashop.web;

import jpabook.orignal_jpashop.domain.Address;
import jpabook.orignal_jpashop.domain.Member;
import jpabook.orignal_jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

/*    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        Address address = new Address(form.getStreet(), form.getDetail(), form.getZipcode());
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setAddress(address);

        // 추가로 받아야하는 요소들
        member.setPwd();
        member.setSchool();
        member.setStation();
        memberService.join(member);
        return "redirect:/";
    }*/

    @PostMapping(value = "/members/new")
    public String create(@PathVariable("email") String email,
                         @PathVariable("name") String name,
                         @PathVariable("street") String street,
                         @PathVariable("detail") String detail,
                         @PathVariable("zipcode") String zipcode,
                         @PathVariable("pwd") String pwd,
                         @PathVariable("school") String school,
                         @PathVariable("station") String station) {
        Address address = new Address(street, detail, zipcode);

        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        member.setAddress(address);
        member.setPwd(pwd);
        member.setSchool(school);
        member.setStation(station);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); return "members/memberList";
    }
}
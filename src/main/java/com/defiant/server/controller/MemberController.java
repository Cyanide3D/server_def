package com.defiant.server.controller;

import com.defiant.server.model.Member;
import com.defiant.server.dto.MemberDto;
import com.defiant.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member add(@RequestBody MemberDto dto) {
        return memberService.addNewMember(dto);
    }

    @GetMapping
    public List<Member> list(@RequestParam(value = "filter", required = false) String param) {
        return memberService.getMembersByParam(param);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Member member) {
        memberService.update(member);
    }

    @PatchMapping("/{id}")
    public Member weekUpdate(@RequestBody Member member, @PathVariable("id") Long id) {
        return memberService.weeklyMemberUpdate(member);
    }

}

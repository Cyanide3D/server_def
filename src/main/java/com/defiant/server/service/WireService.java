package com.defiant.server.service;

import com.defiant.server.dto.WireDto;
import com.defiant.server.model.Member;
import com.defiant.server.model.User;
import com.defiant.server.model.Wire;
import com.defiant.server.repository.WireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WireService {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private WireRepo repository;

    public void wire(WireDto dto, User moderator) {
        Member member = memberService.findMemberById(dto.getMemberId());
        User user = userService.findUserById(dto.getUserId());

        Wire wire = repository.save(new Wire(user, member, moderator));
        member.setWire(wire);
        user.setWire(wire);
        memberService.saveOrUpdate(member);
        userService.saveOrUpdate(user);
    }

}

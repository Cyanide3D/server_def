package com.defiant.server.service;

import com.defiant.server.model.Member;
import com.defiant.server.model.MemberDto;
import com.defiant.server.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepo repository;

    public Member addNewMember(MemberDto dto) {
        return repository.save(Member.from(dto));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public List<Member> getMembersByParam(String partOfNickname) {
        return partOfNickname == null ? repository.findAll() : repository.findAllByNicknameLike(partOfNickname);
    }

    public Member weeklyMemberUpdate(Member member) {
        Member memberFromBD = repository.findById(member.getId()).get();
        memberFromBD.setLastWeekClanPoints(memberFromBD.getCurrentClanPoints());
        memberFromBD.setCurrentClanPoints(member.getCurrentClanPoints());

        return repository.save(memberFromBD);
    }

    public void update(Member member) {
        repository.save(member);
    }


}

package com.defiant.server.repository;

import com.defiant.server.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {

    List<Member> findAllByNicknameLike(String nickname);

}

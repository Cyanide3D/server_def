package com.defiant.server.service;

import com.defiant.server.model.Member;
import com.defiant.server.model.Role;
import com.defiant.server.model.Statistic;
import com.defiant.server.repository.StatisticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private MemberService memberService;
    @Autowired
    private StatisticRepo statisticRepo;

    public Statistic getWeeklyStatistic() {
        List<Member> allMembers = memberService.getAllMembers();
        Statistic statistic = new Statistic();

        statistic.setDate(LocalDate.now());
        statistic.setMemberAmount(allMembers.size());
        statistic.setOfficerAmount((int) allMembers.stream().filter(m -> m.getRole().equals(Role.OFFICER)).count());

        for (Member m : allMembers) {
            statistic.addClanPoints(m.getLastWeekClanPoints());
            statistic.addWeekClanPoints(m.getCurrentWeekClanPoints());
        }

        return statistic;
    }

    public void saveWeeklyStatistic(Statistic statistic) {
        statisticRepo.save(statistic);
    }

}

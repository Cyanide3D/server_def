package com.defiant.server.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "server_statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clan_points")
    private Long clanPoints;
    @Column(name = "week_clan_points")
    private Long weekClanPoints;
    @Column(name = "member_amount")
    private Integer memberAmount;
    @Column(name = "officer_amount")
    private Integer officerAmount;
    @Column(name = "date")
    private LocalDate date;

    public Statistic() {
        clanPoints = 0L;
        weekClanPoints = 0L;
    }

    public void addClanPoints(Long points) {
        clanPoints += points;
    }

    public void addWeekClanPoints(Long points) {
        weekClanPoints += points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClanPoints() {
        return clanPoints;
    }

    public void setClanPoints(Long clanPoints) {
        this.clanPoints = clanPoints;
    }

    public Long getWeekClanPoints() {
        return weekClanPoints;
    }

    public void setWeekClanPoints(Long weekClanPoints) {
        this.weekClanPoints = weekClanPoints;
    }

    public Integer getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(Integer memberAmount) {
        this.memberAmount = memberAmount;
    }

    public Integer getOfficerAmount() {
        return officerAmount;
    }

    public void setOfficerAmount(Integer officerAmount) {
        this.officerAmount = officerAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

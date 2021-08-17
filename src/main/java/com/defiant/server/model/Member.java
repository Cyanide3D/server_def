package com.defiant.server.model;

import com.defiant.server.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "server_members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nickname;
    @Column(name = "last_week_clan_points")
    private Long lastWeekClanPoints;
    @Column(name = "current_clan_points")
    private Long currentClanPoints;
    @Basic
    private String note;
    @OneToOne
    @JsonIgnore
    private Wire wire;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Member() {
    }

    public Member(String nickname, Long currentClanPoints, Role role) {
        this.nickname = nickname;
        this.currentClanPoints = currentClanPoints;
        this.role = role;
        this.lastWeekClanPoints = 0L;
        this.note = "";
    }

    public Wire getWire() {
        return wire;
    }

    public void setWire(Wire wire) {
        this.wire = wire;
    }

    public long getCurrentWeekClanPoints() {
        return currentClanPoints - lastWeekClanPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getLastWeekClanPoints() {
        return lastWeekClanPoints;
    }

    public void setLastWeekClanPoints(Long lastWeekClanPoints) {
        this.lastWeekClanPoints = lastWeekClanPoints;
    }

    public long getCurrentClanPoints() {
        return currentClanPoints;
    }

    public void setCurrentClanPoints(Long currentClanPoints) {
        this.currentClanPoints = currentClanPoints;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Member from(MemberDto dto) {
        return new Member(dto.getNickname(), dto.getClanPoints(), Role.valueOf(dto.getRole().toUpperCase()));
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", lastWeekClanPoints=" + lastWeekClanPoints +
                ", currentClanPoints=" + currentClanPoints +
                ", note='" + note + '\'' +
                ", role=" + role +
                '}';
    }
}

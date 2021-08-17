package com.defiant.server.model;

public class MemberDto {

    private String nickname;
    private String role;
    private Long clanPoints;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getClanPoints() {
        return clanPoints;
    }

    public void setClanPoints(Long clanPoints) {
        this.clanPoints = clanPoints;
    }
}

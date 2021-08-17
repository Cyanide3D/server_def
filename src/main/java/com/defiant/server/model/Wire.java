package com.defiant.server.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "server_wire")
public class Wire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Member member;
    @Column(name = "wire_date")
    private LocalDateTime wireDate;
    @ManyToOne
    private User userWhoWired;

    public Wire() {
    }

    public Wire(User user, Member member, User userWhoWired) {
        this.user = user;
        this.member = member;
        this.userWhoWired = userWhoWired;
        this.wireDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getWireDate() {
        return wireDate;
    }

    public void setWireDate(LocalDateTime wireDate) {
        this.wireDate = wireDate;
    }

    public User getUserWhoWired() {
        return userWhoWired;
    }

    public void setUserWhoWired(User userWhoWired) {
        this.userWhoWired = userWhoWired;
    }
}

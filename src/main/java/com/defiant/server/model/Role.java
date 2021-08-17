package com.defiant.server.model;

public enum Role {

    MEMBER("Игрок"),
    OFFICER("Офицер"),
    HEAD("Глава");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}

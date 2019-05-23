package ru.morou.config;

public enum RoleType {
    ADMIN("ROLE_ADMIN"), MANAGER("ROLE_MANAGER"), EMPLOYEE("ROLE_EMPLOYEE");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

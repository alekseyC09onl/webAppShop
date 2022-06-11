package com.tms.webappshop.entity;


public enum PermissionsEnum {
    READ("READ"),
    WRITE("WRITE");

    private final String permission;

    PermissionsEnum(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

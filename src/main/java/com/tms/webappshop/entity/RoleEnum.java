package com.tms.webappshop.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum RoleEnum {
    USER(Set.of(PermissionsEnum.READ)),
    ADMIN(Set.of(PermissionsEnum.READ, PermissionsEnum.WRITE));

    private final Set<PermissionsEnum> permissions;

    RoleEnum(Set<PermissionsEnum> permissions) {
        this.permissions = permissions;
    }

    public Set<PermissionsEnum> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.getPermission()))
                .collect(Collectors.toSet());
    }

}

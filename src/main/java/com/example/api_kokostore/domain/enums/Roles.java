package com.example.api_kokostore.domain.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Roles {
    USER(List.of(Permissions.READ_PUBLIC_CONTENT)),
    CUSTOMER(mergePermissions(USER, List.of(Permissions.PURCHASE_PRODUCT))),
    ADMIN(mergePermissions(CUSTOMER, List.of(Permissions.MANAGE_PRODUCTS, Permissions.MANAGE_USERS)));

    private final List<Permissions> permissions;

    Roles(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = permissions
                .stream().map(permissions -> new SimpleGrantedAuthority(permissions.name())).collect(Collectors.toList());


        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name())); //Dependiendo del ENUM  CUSTOMER | USER | ADMIN

        return authorities;
    }

    private static List<Permissions> mergePermissions(Roles baseRole, List<Permissions> additionalPermissions) {
        return Stream.concat(baseRole.getPermissions().stream(), additionalPermissions.stream())
                .distinct()
                .toList();
    }


}

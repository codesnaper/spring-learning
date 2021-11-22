package com.example.security.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    NO_ROLE("emp_empty_role"),
    USER_ROLE_READ("emp_read"),
    USER_ROLE_WRITE("emp_write"),
    USER_ROLE_UPDATE("emp_update"),
    ADMIN_USER_CREATE("admin_usr_create"),
    ADMIN_USER_VIEW("admin_user_view"),
    ADMIN_USER_EDIT("admin_user_edit");

    private String value;

    public static Role getRole(String name) {
        for(Role e: Role.values()) {
            if(e.value.equals(name)) {
                return e;
            }
        }
        return Role.NO_ROLE;
    }
}

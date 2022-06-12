package application.data.users.attributes;

import lombok.Getter;

@Getter
public enum Permission {
    CREATE_USER          ("access:user:create"),
    READ_USER            ("access:user:read"),
    UPDATE_USER          ("access:user:update"),
    DELETE_USER          ("access:user:delete");

    private final String permission;

    Permission(String permission)
    {
        this.permission = permission;
    }
}
package application.data.users.attributes;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ROLE_USER(Set.of(
                            Permission.CREATE_USER,
                            Permission.READ_USER,
                            Permission.UPDATE_USER,
                            Permission.DELETE_USER
                    )
             );

    private final Set<Permission> access;

    Role(Set<Permission> access)
    {
        this.access = access;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return access.stream().
                map(permission -> new SimpleGrantedAuthority(permission.getPermission())).
                collect(Collectors.toSet());
    }
}
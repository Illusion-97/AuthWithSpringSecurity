package fr.dawan.AuthWithSpringSecurity.dtos;

import fr.dawan.AuthWithSpringSecurity.models.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class UserSecurity implements UserDetails {
    private final User user;
    private final Collection<? extends GrantedAuthority> roles;
    public UserSecurity(User user) {
        this.user = user;
        // Tant qu'il n'y a pas eu un appel EXPLICITE à une relation
        roles = user.getRoles().stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .toList();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}

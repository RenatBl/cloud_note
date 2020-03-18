package ru.itis.program.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.program.models.enums.Credential;
import ru.itis.program.models.enums.Role;
import ru.itis.program.models.enums.Status;
import ru.itis.program.models.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    @Autowired
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(Role.USER.name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return LocalDateTime.now().getMonth().minus(user.getLastActive().getMonth().getValue()).getValue() > 5;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getStatus().equals(Status.LOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredential().equals(Credential.ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus().equals(Status.CONFIRMED);
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

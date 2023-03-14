package com.quanghoa.springtemplate.domain.auths;

import com.quanghoa.springtemplate.persistence.role.RoleStore;
import com.quanghoa.springtemplate.persistence.user.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserStore userStore;
    private final RoleStore roleStore;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userStore.findByUsername(username)
                .map(this::buildUser)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    private User buildUser(final com.quanghoa.springtemplate.persistence.user.User user) {
        return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(),
                List.of(new SimpleGrantedAuthority(roleStore.getRoleById(user.getRoleId()))));
    }
}
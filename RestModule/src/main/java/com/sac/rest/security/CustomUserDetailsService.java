package com.sac.rest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sac.model.AppUser;
import com.sac.model.AppUserRole;
import com.sac.service.AppUserRoleService;
import com.sac.service.AppUserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRoleService appUserRolesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.get(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = getRoles(appUser);
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }

    private List<GrantedAuthority> getRoles(AppUser appUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<? extends AppUserRole> roles = appUserRolesService.getByAppUser(appUser);
        if (roles != null && !roles.isEmpty()) {
            for (AppUserRole role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().name());
                authorities.add(authority);
            }
        }
        return authorities;
    }
}

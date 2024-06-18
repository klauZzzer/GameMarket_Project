package org.example.gamemarket.security;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Role;
import org.example.gamemarket.entity.UserInfo;
import org.example.gamemarket.exception.ErrorMessage;
import org.example.gamemarket.repository.UserInfoRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    public final UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findUserInfoByLogin(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(ErrorMessage.THIS_USERINFO_DOES_NOT_EXIST);
        }
        return User.withUsername(userInfo.getLogin())
                .username(userInfo.getLogin())
                .password(userInfo.getPassword())
                .authorities(getAuthorities(userInfo.getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().name()));
            role.getAuthorities().forEach(authority ->
                            authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName().name())));
        }
        return authorities;
    }
}

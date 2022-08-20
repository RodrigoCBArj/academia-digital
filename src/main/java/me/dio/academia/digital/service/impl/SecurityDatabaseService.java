package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario userEntity = repository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        userEntity.getPerfis().forEach(perfil -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + perfil));
        });

        UserDetails user = new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);

        return user;
    }
}

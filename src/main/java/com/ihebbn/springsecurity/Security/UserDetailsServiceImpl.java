package com.ihebbn.springsecurity.Security;

import com.ihebbn.springsecurity.User.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String useEmail) throws UsernameNotFoundException {
        return repository.findByEmail(useEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

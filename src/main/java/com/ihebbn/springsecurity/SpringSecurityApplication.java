package com.ihebbn.springsecurity;

import com.ihebbn.springsecurity.Role.Role;
import com.ihebbn.springsecurity.Role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("USER").isEmpty()) {
                Role role = Role.builder()
                        .name("USER")
                        .createdDate(LocalDateTime.now()) // Initialize created_date with current timestamp
                        .build();
                roleRepository.save(role);
            }
        };
    }




}

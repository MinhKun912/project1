//package com.example.jobportal.config;
//
//import com.example.jobportal.entity.User;
//import com.example.jobportal.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
////@Configuration
//@RequiredArgsConstructor
//public class UserDetailsServiceConfig {
//
//    private final UserRepository userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user == null) throw new UsernameNotFoundException("User not found");
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getUsername())
//                    .password(user.getPassword())
//                    .roles(user.getRole().replace("ROLE_", ""))
//                    .build();
//        };
//    }
//}

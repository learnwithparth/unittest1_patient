//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication()
//        .withUser("user")
//        .password("user")
//        .roles("ADMIN")
//        .and()
//        .withUser("20it022")
//        .password("20it022")
//        .roles("USER");
//    }
//    @Bean
//public PasswordEncoder getpasswordEncoder(){
//    return NoOpPasswordEncoder.getInstance();
//    }
//}

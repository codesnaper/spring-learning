//package com.example.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
////@Order(101)
//public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    AuthenticationProvider authenticationProvider;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/admin/employee/**")
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
////                .and()
////                .formLogin()
////                .loginPage("/admin/login")
////                .usernameParameter("username")
////                .successForwardUrl("/admin/employee")
////                .failureUrl("/admin/login/error")
////                .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("admin")).roles("SU");
//    }
//}

package com.example.security.config;

import com.example.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class DigestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailService userDetailService;

    private DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setRealmName(Constant.DIGEST_APP_RELEAM_POLICY);
        entryPoint.setKey(Constant.DIGEST_KEY);
        return entryPoint;
    }

    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
        digestAuthenticationFilter.setUserDetailsService(userDetailService);
//        digestAuthenticationFilter.setCreateAuthenticatedToken(true);
//        It will not generate the HA1 it will use userdetail service password encoded.
//        digestAuthenticationFilter.setPasswordAlreadyEncoded(true);
        return digestAuthenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("admin")).roles("SU");
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .antMatcher("/admin/employee/**")
                .csrf()
                .and()
                .addFilter(digestAuthenticationFilter())
                .exceptionHandling()
                .authenticationEntryPoint(digestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}

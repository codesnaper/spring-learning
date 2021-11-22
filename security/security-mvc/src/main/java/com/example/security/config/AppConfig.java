package com.example.security.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.example.security.repository")
@EntityScan(basePackages = "com.example.security.entity")
@EnableTransactionManagement
@Configuration
public class AppConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(){
            //For all request i need https
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("/*");
                securityConstraint.addCollection(securityCollection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(redirectConnector());
        return tomcatServletWebServerFactory;
    }

    private Connector redirectConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11Nio2Protocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setRedirectPort(443);
        return connector;
    }

}

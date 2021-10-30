package com.example.coffee.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
@Data
@ToString
@EqualsAndHashCode
public class DatabaseProp {

    private String url;

    private String username;

    private String password;

}

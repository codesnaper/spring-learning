package com.example.coffee.config;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.example.coffee.repository")
public class R2DBConfig extends AbstractR2dbcConfiguration {

    private final DatabaseProp databaseProp;

    @Autowired
    public R2DBConfig(DatabaseProp databaseProp) {
        this.databaseProp = databaseProp;
    }

    public ConnectionFactory connectionFactory() {
        return new H2ConnectionFactory(
                H2ConnectionConfiguration.builder()
                        .url(databaseProp.getUrl())
                        .username(databaseProp.getPassword())
                        .build()
        );
    }

}

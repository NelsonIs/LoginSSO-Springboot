package com.sso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.sso")
@EnableJpaRepositories("com.sso")
@EnableTransactionManagement
@Configuration
public class PersistenceConfig {

}
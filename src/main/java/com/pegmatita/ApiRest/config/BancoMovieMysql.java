package com.pegmatita.ApiRest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pegmatita.ApiRest.repository.movie",
        entityManagerFactoryRef = "MovieEntityManager",
        transactionManagerRef = "MovieTransactionManager")
public class BancoMovieMysql {

    @Bean(name = "MovieDataSource")
    @Primary
    public DataSource MovieDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/APIRestMysql");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean("MovieEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean MovieEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier("MovieDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.pegmatita.ApiRest.repository.movie")
                .persistenceUnit("Music")
                .build();
    }

    @Bean(name = "MovieTransactionManager")
    public PlatformTransactionManager MovieTransactionManager(@Qualifier("MovieEntityManager") LocalContainerEntityManagerFactoryBean MovieEntityManager) {
        return new JpaTransactionManager(MovieEntityManager.getObject());
    }

}

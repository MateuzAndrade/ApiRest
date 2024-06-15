package com.pegmatita.ApiRest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.pegmatita.ApiRest.repository.music",
        entityManagerFactoryRef = "MusicaEntityManager",
        transactionManagerRef = "MusicTransactionManager"
)
public class BancoMusicMariaDB {

    @Bean(name = "MusicDataSource")
    public DataSource MusicDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3307/APIRestMariaDB");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean(name = "MusicaEntityManager")
    public LocalContainerEntityManagerFactoryBean MusicaEntityManager(EntityManagerFactoryBuilder builder,
            @Qualifier("MusicDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.pegmatita.ApiRest.model.music")
                .persistenceUnit("Music")
                .build();
    }

    @Bean(name = "MusicTransactionManager")
    public PlatformTransactionManager MusicTransactionManager(@Qualifier("MusicaEntityManager") LocalContainerEntityManagerFactoryBean MusicaEntityManager) {
        return new JpaTransactionManager(MusicaEntityManager.getObject());
    }

}

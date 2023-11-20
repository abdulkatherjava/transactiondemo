package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan("org.example")
public class DatasourceConfig {


    @Bean
    public DataSource dataSource() {
        System.out.println("Datasource...");
        return new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/product",
                "root",
                "root"
        );
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        System.out.println("Datasource JdbcTemplate");
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

package es.deutz.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "es.deutz.demo.custom.domain")
@EnableJpaRepositories(transactionManagerRef = "partnerTransactionManager", entityManagerFactoryRef = "partnerEntityManagerFactory", basePackages = "es.deutz.demo.custom.repository")
public class PartnerDatabaseConfiguration {

    @Bean
    @ConfigurationProperties("partner.datasource")
    public DataSourceProperties partnerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("partner.datasource")
    public DataSource partnerDataSource() {
        return partnerDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "partnerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean partnerEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(partnerDataSource())
            .packages("es.deutz.demo.custom.domain")
            .persistenceUnit("custom")
            .build();
    }

    @Bean(name = "partnerTransactionManager")
    public JpaTransactionManager db2TransactionManager(@Qualifier("partnerEntityManagerFactory") final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


}

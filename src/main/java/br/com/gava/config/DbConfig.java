package br.com.gava.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {

	@Bean(name="defaultDataSourceDb")
	@Primary
	@ConfigurationProperties(prefix="spring.ds-default")
	public DataSource defaultDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="defaultDataSource")
	public JdbcTemplate defaultJdbcTemplate(@Qualifier("defaultDataSourceDb") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
}
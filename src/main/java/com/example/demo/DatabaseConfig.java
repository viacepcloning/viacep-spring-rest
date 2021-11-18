package com.example.demo;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		config.setDriverClassName("org.postgresql.Driver");
		return new HikariDataSource(config);
	}
}

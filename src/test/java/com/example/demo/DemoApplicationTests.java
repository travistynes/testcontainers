package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * These tests use the OracleContainer from testcontainers to start an Oracle
 * database in Docker.
 * 
 * Documentation for testcontainers: https://java.testcontainers.org/modules/databases/jdbc/
 */
@Testcontainers
@SpringBootTest
class DemoApplicationTests {
	private static final String ORACLE_IMAGE = "gvenzl/oracle-xe";

	@Test
	void testOracle() throws SQLException {
		try (OracleContainer oracle = new OracleContainer(ORACLE_IMAGE)
				.withInitScript("db/oracle/init.sql")) {
			oracle.start();
			
			Set<String> names = Set.of("John", "Jane");
			ResultSet resultSet = performQuery(oracle, "select id, name from Users");
			int count = 0;

			while (resultSet.next()) {
				count++;
				String name = resultSet.getString("name");
				assertTrue(names.contains(name));
			}

			assertEquals(names.size(), count);
		}
	}

	private ResultSet performQuery(JdbcDatabaseContainer<?> container, String sql) throws SQLException {
		DataSource ds = getDataSource(container);
		Statement statement = ds.getConnection().createStatement();
		statement.execute(sql);
		ResultSet resultSet = statement.getResultSet();

		return resultSet;
	}

	private DataSource getDataSource(JdbcDatabaseContainer<?> container) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(container.getJdbcUrl());
		config.setUsername(container.getUsername());
		config.setPassword(container.getPassword());
		config.setDriverClassName(container.getDriverClassName());
		return new HikariDataSource(config);
	}
}

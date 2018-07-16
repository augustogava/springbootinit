package br.com.gava.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public abstract class GenericDAO {

	@Autowired
	@Qualifier("defaultDataSource")
	protected JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate( this.getJdbcTemplate() );
	}
	
	protected void insert(String query, SqlParameterSource params) {
		this.update(query, params);
	}

	protected void update(String query, SqlParameterSource params) {
		this.getJdbcTemplate().update(query, params);
	}
}

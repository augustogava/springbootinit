package br.com.gava.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class JdbcBaseDAO extends JdbcDaoSupport {
	

	@Resource
	private DataSource dataSource;
	
	@Resource
	private DataSource routingDataSource;
	
	private NamedParameterJdbcTemplate defaultTemplate;
	
	@PostConstruct
	public void init() {
		this.defaultTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
	}
	
	public NamedParameterJdbcTemplate getDefaultNamedParameterJdbcTemplate() {
		return this.defaultTemplate;
	}
	
}

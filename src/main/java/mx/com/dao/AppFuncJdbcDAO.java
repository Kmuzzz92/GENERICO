package mx.com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;


@Repository
public class AppFuncJdbcDAO implements AppFuncDAO{
	/**
	 * @since 1.0.0
	 */
	protected final static Logger log = LoggerFactory
			.getLogger(AppFuncJdbcDAO.class);

	/**
	 * @since 1.0.0
	 */
	@SuppressWarnings("unused")
	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	/**
	 * 
	 * @param jdbcTemplate
	 * @since 1.0.0
	 */
	
	
	
	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}}

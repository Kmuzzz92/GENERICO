package mx.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import mx.com.doo.Examenes;

@Repository
public class AppProfesorJdbcDAO implements AppProfesorDAO{

	/**
	 * @since 1.0.0
	 */
	protected final static Logger log = LoggerFactory.getLogger(AppProfesorJdbcDAO.class);
	
	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	
	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Examenes> getAllExamenes() {
		String sql = "SELECT [idExamen],[nombre],[descripcion],[usuario],[activo],[fecha_creacion] FROM [plataforma].[dbo].[examenes]";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Examenes.class));
	}


	@Override
	public Examenes getExamenById(int idExamen) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT [idExamen],[nombre],[descripcion],[usuario],[activo],[fecha_creacion] FROM [plataforma].[dbo].[examenes] where idExamen=:idExamen";
		param.put("idExamen", idExamen);
		return jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(Examenes.class));
	}
	
	
}
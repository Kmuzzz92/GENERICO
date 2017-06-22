package mx.com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.doo.Grupo;

@Repository
public class AppGrupoJdbcDAO implements AppGrupoDAO{

	protected final static Logger log = LoggerFactory.getLogger(AppGrupoJdbcDAO.class);

	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Grupo> getAllGrupos() {
		String sql = "SELECT [idGrupo],[nombre] FROM [plataforma].[dbo].[grupo] WHERE idGrupo!=1";
		List<Grupo> grupos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Grupo>(Grupo.class));
		return grupos;
	}

	@Override
	public Grupo getById(int idGrupo) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT [idGrupo],[nombre] FROM [plataforma].[dbo].[grupo] WHERE idGrupo=:idGrupo";
		param.put("idGrupo", idGrupo);
		return jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(Grupo.class));
	}

}

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
		String sql = "SELECT [idGrupo],[nombre],[profesor] FROM [plataforma].[dbo].[grupo] WHERE idGrupo!=1";
		List<Grupo> grupos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Grupo>(Grupo.class));
		return grupos;
	}

	@Override
	public Grupo getById(int idGrupo) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT [idGrupo],[nombre],[profesor] FROM [plataforma].[dbo].[grupo] WHERE idGrupo=:idGrupo";
		param.put("idGrupo", idGrupo);
		return jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(Grupo.class));
	}
	
	@Override
	public boolean insertGrupo (Grupo grupo){
		Map<String, Object> paramUser = new HashMap<String, Object>();
		try{
			String sql  = "INSERT INTO [plataforma].[dbo].[grupo]([nombre],[profesor]) VALUES (:nombre,:profesor)";
			String sql1 = "UPDATE [plataforma].[dbo].[grupo]SET [nombre] = :nombre, [profesor]=:profesor  WHERE idGrupo=:idGrupo ";
			paramUser.put("nombre",grupo.getNombre());
			paramUser.put("profesor", grupo.getProfesor());
			if(grupo.getIdGrupo() != 0){
				paramUser.put("idGrupo",grupo.getIdGrupo());
				sql=sql1;
			}
			jdbcTemplate.update(sql, paramUser);
			return true; 
		} catch (Exception ex) {
			log.error(ex.toString());
			return false;
		}
	}
	
	@Override
	public boolean deleteGrupo( Grupo grupo){
		Map<String, Object> paramUser = new HashMap<String, Object>();
		try{
			String sql = "DELETE FROM [plataforma].[dbo].[grupo] WHERE idGrupo = :idGrupo";
			paramUser.put("idGrupo", grupo.getIdGrupo());
			jdbcTemplate.update(sql, paramUser);
			return true;
		}catch (Exception ex) {
			log.error(ex.toString());
			return false;
		}
	}

	@Override
	public List<Grupo> getAllGruposByProfesor(int idProfesor) {
		Map<String, Object> param = new HashMap<String,Object>();
		String sql ="SELECT * FROM [plataforma].[dbo].[grupo] where profesor=:profesor";
		param.put("profesor",idProfesor);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Grupo>(Grupo.class));
	}
}
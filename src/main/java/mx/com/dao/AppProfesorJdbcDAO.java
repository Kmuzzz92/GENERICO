package mx.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.tema;

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


	@Override
	public List<tema> getAllTemas() {
		String sql = "SELECT * FROM [plataforma].[dbo].[tema]";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(tema.class));
	}


	@Override
	public List<Preguntas> getAllPreguntasByUsuario(String usuario) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT * FROM [plataforma].[dbo].[preguntas] WHERE usuario=:usuario";
		param.put("usuario",usuario);
		return jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<>(Preguntas.class));
	}


	@Override
	public List<Respuestas> getAllRespuestasByPregunta(long idPregunta) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT * FROM [plataforma].[dbo].[respuestas] WHERE idPregunta=:idPregunta";
		param.put("idPregunta",idPregunta);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(Respuestas.class));
	}


	@Override
	public boolean savePreguntas(List<Preguntas> preguntas) {
		boolean ret = false;
		String sql1 = "INSERT INTO [plataforma].[dbo].[preguntas] ([texto],[usuario],[nivel],[tema]) VALUES (:texto,:usuario,:nivel,:tema)";
		String sql2 = "INSERT INTO [plataforma].[dbo].[respuestas] ([texto],[idPregunta],[orden],[correcto],[usuario]) VALUES (:texto,:idPregunta,:orden,:correcto,:usuario)";
		String sql3 = "UPDATE [plataforma].[dbo].[preguntas] SET [texto] = :texto,[usuario] = :usuario,[nivel] = :nivel ,[tema] = :tema WHERE idPregunta=:idPregunta";
		String sql4 = "UPDATE [plataforma].[dbo].[respuestas] SET [texto] = :texto ,[idPregunta] = :idPregunta ,[orden] = :orden ,[correcto] = :correcto ,[usuario] = :usuario WHERE idRespuesta=:idRespuesta";
		Map<String, Object> paramP = null;
		Map<String, Object> paramR = null;
		for(int i=0;i<preguntas.size();i++){
			paramP=new HashMap<String, Object>();
			paramP.put("texto",preguntas.get(i).getTexto());
			paramP.put("usuario",preguntas.get(i).getUsuario());
			paramP.put("nivel",preguntas.get(i).getNivel());
			paramP.put("tema",preguntas.get(i).getTema());
			if(preguntas.get(i).getIdPregunta()!=0){
				paramP.put("idPregunta",preguntas.get(i).getIdPregunta());
				jdbcTemplate.update(sql3, paramP);
				for(int j=0;j<preguntas.get(i).getRespuestas().length;j++){
					paramR = new HashMap<String, Object>();
					paramR.put("texto", preguntas.get(i).getRespuestas()[j].getTexto());
					paramR.put("idPregunta", preguntas.get(i).getRespuestas()[j].getIdPregunta());
					paramR.put("orden", j);
					paramR.put("correcto", preguntas.get(i).getRespuestas()[j].isCorrecto());
					paramR.put("usuario", preguntas.get(i).getRespuestas()[j].getUsuario());
					if(preguntas.get(i).getRespuestas()[j].getIdRespuesta()!=0){
						paramR.put("idRespuesta", preguntas.get(i).getRespuestas()[j].getIdRespuesta());
						jdbcTemplate.update(sql4, paramR);
					}else{
						paramR.put("idPregunta", preguntas.get(i).getIdPregunta());
						jdbcTemplate.update(sql2, paramR);
					}
				}
				ret =true;
			}else{
				KeyHolder key = new GeneratedKeyHolder();
				jdbcTemplate.update(sql1, new MapSqlParameterSource(paramP),key);
				for(int j=0;j<preguntas.get(i).getRespuestas().length;j++){
					paramR = new HashMap<String, Object>();
					paramR.put("texto", preguntas.get(i).getRespuestas()[j].getTexto());
					paramR.put("idPregunta", key.getKey());
					paramR.put("orden", j);
					paramR.put("correcto", preguntas.get(i).getRespuestas()[j].isCorrecto());
					paramR.put("usuario", preguntas.get(i).getRespuestas()[j].getUsuario());
					jdbcTemplate.update(sql2, paramR);
				}
				ret =true;
			}
		}
		return ret;
	}
	
}
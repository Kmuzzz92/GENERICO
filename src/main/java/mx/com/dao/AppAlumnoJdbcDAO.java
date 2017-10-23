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

@Repository
public class AppAlumnoJdbcDAO implements AppAlumnoDAO{

protected final static Logger log = LoggerFactory.getLogger(AppAlumnoJdbcDAO.class);
	
	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	
	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Preguntas> getExamenByNivel(int nivel) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT TOP 10 * FROM [plataforma].[dbo].[preguntas] WHERE nivel=:nivel ORDER BY NEWID()";
		param.put("nivel", nivel);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(Preguntas.class));
	}

	@Override
	public List<Respuestas> getRespuestasByPregunta(long idPregunta) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sql = "SELECT * FROM [plataforma].[dbo].[respuestas] WHERE idPregunta=:idPregunta order by orden desc";
		param.put("idPregunta", idPregunta);
		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(Respuestas.class));
	}


	@Override
	public boolean saveExamen(Examenes examen) {
		boolean ret = false;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> parar = new HashMap<String, Object>();
		String sql1 ="INSERT INTO [plataforma].[dbo].[examenes] ([nombre],[usuario],[fecha_creacion]) VALUES (:nombre,:usuario,GETDATE())";
		String sql2 ="INSERT INTO [plataforma].[dbo].[respuestas_x_alumnos] ([idExamen],[idPregunta],[idRespuesta],[fecha_respuesta],[usuario]) VALUES (:idExamen,:idPregunta,:idRespuesta,GETDATE(),:usuario)";
		KeyHolder key = new GeneratedKeyHolder();
		try{
			param.put("nombre", examen.getNombre());
			param.put("usuario",examen.getUsuario());
			jdbcTemplate.update(sql1, new MapSqlParameterSource(param),key);
			for(int i=0;i<examen.getPreguntas().length;i++){
				parar.put("idExamen", key.getKey());
				parar.put("idPregunta", examen.getPreguntas()[i].getIdPregunta());
				parar.put("idRespuesta", examen.getPreguntas()[i].getRespuesta());
				parar.put("usuario", examen.getUsuario());
				jdbcTemplate.update(sql2, parar);
			}
			ret=true;
		}catch(Exception ex){
			log.error(ex.toString());
		}
		return ret;
	}
}
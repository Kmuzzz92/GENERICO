package mx.com.dao;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.doo.Alumno;

@Repository
public class AppAlumnoJdbcDAO implements AppAlumnoDAO {

	protected final static Logger log = LoggerFactory.getLogger(AppAlumnoJdbcDAO.class);

	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public boolean InsertAlumno(Alumno alumno) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		SimpleDateFormat fecha=new SimpleDateFormat("MM/dd/yyyy");
		
				try {
			String sql = "INSERT INTO [plataforma].[dbo].[alumno] ([username],[email],[nombre],[paterno],[materno],[edad],[grupo]) VALUES (:username,:email,:nombre,:paterno,:materno,:edad,:grupo)";
			paramUser.put("username", alumno.getUsername());
			paramUser.put("email", alumno.getEmail());
			paramUser.put("nombre", alumno.getNombre());
			paramUser.put("paterno", alumno.getPaterno());
			paramUser.put("materno", alumno.getMaterno());
			paramUser.put("edad", fecha.format(alumno.getEdad()));
			paramUser.put("grupo", "" + alumno.getGrupo());
			jdbcTemplate.update(sql, paramUser);
			return true;
		} catch (Exception ex) {
			log.error(ex.toString());
			return false;
		}
	}

}

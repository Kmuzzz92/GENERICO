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

import mx.com.doo.Persona;

@Repository
public class AppPersonaJdbcDAO implements AppPersonaDAO {

	protected final static Logger log = LoggerFactory.getLogger(AppPersonaJdbcDAO.class);

	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public boolean InsertPersona(Persona persona) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		SimpleDateFormat fecha=new SimpleDateFormat("MM/dd/yyyy");
		try {
			String sql = "INSERT INTO [plataforma].[dbo].[persona] ([username],[email],[nombre],[paterno],[materno],[edad],[grupo]) VALUES (:username,:email,:nombre,:paterno,:materno,:edad,:grupo)";
			paramUser.put("username", persona.getUsername());
			paramUser.put("email", persona.getEmail());
			paramUser.put("nombre", persona.getNombre());
			paramUser.put("paterno", persona.getPaterno());
			paramUser.put("materno", persona.getMaterno());
			paramUser.put("edad", fecha.format(persona.getEdad()));
			paramUser.put("grupo", "" + persona.getGrupo());
			jdbcTemplate.update(sql, paramUser);
			return true;
		} catch (Exception ex) {
			log.error(ex.toString());
			return false;
		}
	}

}

package mx.com.dao;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		SimpleDateFormat fecha = new SimpleDateFormat("MM/dd/yyyy");
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

	@Override
	public List<Persona> getPersonas(String tipo) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		try {
			log.info(tipo);
			String sql = "SELECT per.* FROM [plataforma].[dbo].[user_roles] AS UR INNER JOIN [plataforma].[dbo].[persona] as per ON (per.username=UR.username) WHERE UR.role = :role";
			paramUser.put("role", tipo);
			List<Persona> personas = jdbcTemplate.query(sql, paramUser,
					new BeanPropertyRowMapper<Persona>(Persona.class));
			return personas;
		} catch (Exception ex) {
			log.error(ex.toString());
			return null;
		}
	}

	@Override
	public int getIdByUsername(String username) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		try {
			log.info("Get Persona: " + username);
			String sql = "SELECT id FROM [plataforma].[dbo].[persona] WHERE username=:username";
			paramUser.put("username", username);
			int persona = jdbcTemplate.queryForObject(sql, paramUser, Integer.class);
			return persona;
		} catch (Exception ex) {
			log.error(ex.toString());
			return -1;
		}
	}

	@Override
	public Persona getPersonasById(int id) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		try {
			log.info("Get Persona By Id: " + id);
			String sql = "SELECT * FROM [plataforma].[dbo].[persona] WHERE id=:id";
			paramUser.put("id", id);
			Persona persona = (Persona) jdbcTemplate.queryForObject(sql, paramUser,
					new BeanPropertyRowMapper<Persona>(Persona.class));
			return persona;
		} catch (Exception ex) {
			log.error(ex.toString());
			return null;
		}
	}

	@Override
	public boolean UpdatePersona(Persona persona) {
		Map<String, Object> paramUser = new HashMap<String, Object>();
		SimpleDateFormat fecha = new SimpleDateFormat("MM/dd/yyyy");
		try {
			String sql = "UPDATE [plataforma].[dbo].[persona] SET [email] = :email,[nombre] = :nombre,[paterno] = :paterno,[materno] = :materno,[edad] = :edad WHERE username=:username";
			paramUser.put("username", persona.getUsername());
			paramUser.put("email", persona.getEmail());
			paramUser.put("nombre", persona.getNombre());
			paramUser.put("paterno", persona.getPaterno());
			paramUser.put("materno", persona.getMaterno());
			paramUser.put("edad", fecha.format(persona.getEdad()));
			jdbcTemplate.update(sql, paramUser);
			return true;
		} catch (Exception ex) {
			log.error(ex.toString());
			return false;
		}
	}
}

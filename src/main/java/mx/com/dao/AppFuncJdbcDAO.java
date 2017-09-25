package mx.com.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.doo.UserRoles;
import mx.com.doo.Users;


@Repository
public class AppFuncJdbcDAO implements AppFuncDAO{
	/**
	 * @since 1.0.0
	 */
	protected final static Logger log = LoggerFactory.getLogger(AppFuncJdbcDAO.class);
	
	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;

	
	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public boolean InsertUsuario(Users users, UserRoles userRoles) {
		try{
			Map<String, Object> paramUser = new HashMap<String, Object>();
			Map<String, Object> paramRole = new HashMap<String, Object>();
			String sqlUser = "INSERT INTO [plataforma].[dbo].[users] ([username],[password],[enabled]) VALUES (:username, :password, :enabled)";
			String sqlRole = "INSERT INTO [plataforma].[dbo].[user_roles] ([username],[role]) VALUES (:username,:role)";
			paramUser.put("username", users.getUsername());
			paramUser.put("password", users.getPassword());
			paramUser.put("enabled", users.getEnabled());
			paramRole.put("username", userRoles.getUsername());
			paramRole.put("role", userRoles.getRole());
			jdbcTemplate.update(sqlUser,paramUser);
			jdbcTemplate.update(sqlRole, paramRole);
			return true;
		}catch(Exception ex){
			log.error(ex.toString());
			return false;
		}
	}

	@Override
	public void DeleteUsuario(Users users, UserRoles userRoles) {
		try{
			Map<String, Object> paramUser = new HashMap<String, Object>();
			Map<String, Object> paramRole = new HashMap<String, Object>();
			String sqlUser = "DELETE FROM [plataforma].[dbo].[users] WHERE username=:username";
			String sqlRole = "DELETE FROM [plataforma].[dbo].[user_roles] WHERE username=:username";
			paramUser.put("username", users.getUsername());
			paramUser.put("password", users.getPassword());
			paramUser.put("enabled", users.getEnabled());
			paramRole.put("username", userRoles.getUsername());
			paramRole.put("role", userRoles.getRole());
			jdbcTemplate.update(sqlRole, paramRole);
			jdbcTemplate.update(sqlUser,paramUser);
		}catch(Exception ex){
			log.error(ex.toString());
		}
	}

	@Override
	public void ActivarUsuario(String user) {
		try{
			Map<String, Object> paramUser = new HashMap<String, Object>();
			String sqlUser = "UPDATE [plataforma].[dbo].[users] SET [enabled] = :enabled WHERE username=:username";
			paramUser.put("username", user);
			paramUser.put("enabled", 1);
			jdbcTemplate.update(sqlUser,paramUser);
		}catch(Exception ex){
			log.error(ex.toString());
		}
	}

	@Override
	public void DesactivarUsuario(String user) {
		try{
			Map<String, Object> paramUser = new HashMap<String, Object>();
			String sqlUser = "UPDATE [plataforma].[dbo].[users] SET [enabled] = :enabled WHERE username=:username";
			paramUser.put("username", user);
			paramUser.put("enabled", 0);
			jdbcTemplate.update(sqlUser,paramUser);
		}catch(Exception ex){
			log.error(ex.toString());
		}
	}
}

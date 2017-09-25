package mx.com.dao;

import mx.com.doo.UserRoles;
import mx.com.doo.Users;

public interface AppFuncDAO {

	public boolean InsertUsuario(Users users, UserRoles userRoles);
	
	public void DeleteUsuario(Users users, UserRoles userRoles);
	
	public void ActivarUsuario(String user);
	
	public void DesactivarUsuario(String user);
}
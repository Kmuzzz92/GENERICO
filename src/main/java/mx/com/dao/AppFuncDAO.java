package mx.com.dao;

import mx.com.doo.UserRoles;
import mx.com.doo.Users;

public interface AppFuncDAO {

	public boolean InsertUsuarioAlumno(Users users, UserRoles userRoles);
	
	public void DeleteUsuarioAlumno(Users users, UserRoles userRoles);
}
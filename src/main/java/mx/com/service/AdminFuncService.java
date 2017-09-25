package mx.com.service;

import mx.com.doo.UserRoles;
import mx.com.doo.Users;

public interface AdminFuncService {

	public boolean InsertUser(Users users,UserRoles userRole);
	
	public void DeleteUser(Users users,UserRoles userRole);
	
	public void ActivarUsuario(String user);
	
	public void DesactivarUsuario(String user);	
}

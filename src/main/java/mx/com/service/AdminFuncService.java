package mx.com.service;

import mx.com.doo.UserRoles;
import mx.com.doo.Users;

public interface AdminFuncService {

	public boolean InsertAlumnoUser(Users users,UserRoles userRole);
	
	public void DeleteAlumnoUsers(Users users,UserRoles userRole);
	
}

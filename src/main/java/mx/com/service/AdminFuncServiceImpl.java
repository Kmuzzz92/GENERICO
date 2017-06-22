package mx.com.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppFuncDAO;
import mx.com.doo.UserRoles;
import mx.com.doo.Users;

@Service
@Transactional(readOnly=true)
public class AdminFuncServiceImpl implements AdminFuncService {

	@Inject
	private AppFuncDAO funcDAO;

	@Override
	public boolean InsertAlumnoUser(Users users, UserRoles userRole) {
		return funcDAO.InsertUsuarioAlumno(users, userRole);
	}

	@Override
	public void DeleteAlumnoUsers(Users users, UserRoles userRole) {
		funcDAO.DeleteUsuarioAlumno(users, userRole);
	}
	
}

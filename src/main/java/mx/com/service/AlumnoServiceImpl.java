package mx.com.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppAlumnoDAO;
import mx.com.doo.Alumno;

@Service
@Transactional(readOnly=true)
public class AlumnoServiceImpl implements AlumnoService  {
	
	@Inject
	private AppAlumnoDAO alumnoDAO;

	@Override
	public boolean InsertAlumno(Alumno alumno) {
		
		return alumnoDAO.InsertAlumno(alumno);
	}
	
	

}

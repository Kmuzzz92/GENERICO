package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppProfesorDAO;
import mx.com.doo.Examenes;

@Service
@Transactional(readOnly=true)
public class ProfesorServiceImpl implements ProfesorService
{
	@Inject
	private AppProfesorDAO profesorDAO;

	@Override
	public List<Examenes> getAllExamenes() {
		return profesorDAO.getAllExamenes();
	}

	@Override
	public Examenes getExamenById(int idExamen) {
		return profesorDAO.getExamenById(idExamen);
	}	
}
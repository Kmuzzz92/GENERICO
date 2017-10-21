package mx.com.service;

import java.util.List;

import mx.com.doo.Examenes;

public interface ProfesorService {

	public List<Examenes> getAllExamenes();

	public Examenes getExamenById(int idExamen);
	
}

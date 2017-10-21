package mx.com.dao;

import java.util.List;

import mx.com.doo.Examenes;

public interface AppProfesorDAO {

	public List<Examenes> getAllExamenes();

	public Examenes getExamenById(int idExamen);
}
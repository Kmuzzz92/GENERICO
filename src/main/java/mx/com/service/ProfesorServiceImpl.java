package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppProfesorDAO;
import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.tema;

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

	@Override
	public List<tema> getAllTemas() {
		return profesorDAO.getAllTemas();
	}

	@Override
	public List<Preguntas> getAllPreguntasByUsuario(String usuario) {
		return profesorDAO.getAllPreguntasByUsuario(usuario);
	}

	@Override
	public List<Respuestas> getAllRespuestasByPregunta(long idPregunta) {
		return profesorDAO.getAllRespuestasByPregunta(idPregunta);
	}

	@Override
	public boolean savePreguntas(List<Preguntas> preguntas) {
		return profesorDAO.savePreguntas(preguntas);
	}	
}
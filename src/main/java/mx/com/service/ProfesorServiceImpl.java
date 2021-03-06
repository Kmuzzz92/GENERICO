package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppProfesorDAO;
import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.Respuestas_x_alumno;
import mx.com.doo.tema;

@Service
@Transactional(readOnly=true)
public class ProfesorServiceImpl implements ProfesorService
{
	@Inject
	private AppProfesorDAO profesorDAO;

	@Override
	public List<Examenes> getAllExamenesByUsuario(String usuario) {
		return profesorDAO.getAllExamenesByUsuario(usuario);
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

	@Override
	public List<Respuestas_x_alumno> getRespuestasXAlumnoByExamen(int idExamen) {
		return profesorDAO.getRespuestasXAlumnoByExamen(idExamen);
	}

	@Override
	public Preguntas getPreguntaById(long idPregunta) {
		return profesorDAO.getPreguntaById(idPregunta);
	}

	@Override
	public Respuestas getRespuestaById(long idRespuesta) {
		return profesorDAO.getRespuestaById(idRespuesta);
	}	
}
package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppAlumnoDAO;
import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;

@Service
@Transactional(readOnly=true)
public class AlumnoServiceImpl implements AlumnoService  {
	
	@Inject
	private AppAlumnoDAO alumnoDAO;

	@Override
	public List<Preguntas> getExamenByNivel(int nivel) {
		return alumnoDAO.getExamenByNivel(nivel);
	}

	@Override
	public List<Respuestas> getRespuestasByPregunta(long idPregunta) {
		return alumnoDAO.getRespuestasByPregunta(idPregunta);
	}

	@Override
	public boolean saveExamen(Examenes examen) {
		return alumnoDAO.saveExamen(examen);
	}
	
}
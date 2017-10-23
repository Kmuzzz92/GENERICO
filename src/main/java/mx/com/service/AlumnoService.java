package mx.com.service;

import java.util.List;

import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;

public interface AlumnoService {

	List<Preguntas> getExamenByNivel(int nivel);
	
	List<Respuestas> getRespuestasByPregunta(long idPregunta);
	
	boolean saveExamen(Examenes examen);
}
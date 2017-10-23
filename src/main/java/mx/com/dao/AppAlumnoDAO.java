package mx.com.dao;

import java.util.List;

import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;

public interface AppAlumnoDAO {
	
	List<Preguntas> getExamenByNivel(int nivel);
	
	List<Respuestas> getRespuestasByPregunta(long idPregunta);
	
	boolean saveExamen(Examenes examen);
}
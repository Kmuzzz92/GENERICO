package mx.com.service;

import java.util.List;

import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.tema;

public interface ProfesorService {

	public List<Examenes> getAllExamenes();

	public Examenes getExamenById(int idExamen);
	
	public List<tema> getAllTemas();
	
	public List<Preguntas> getAllPreguntasByUsuario(String usuario);
	
	public List<Respuestas> getAllRespuestasByPregunta(long idPregunta);
	
	public boolean savePreguntas(List<Preguntas> preguntas);
}
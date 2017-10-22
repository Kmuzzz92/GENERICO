package mx.com.dao;

import java.util.List;

import mx.com.doo.Examenes;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.Respuestas_x_alumno;
import mx.com.doo.tema;

public interface AppProfesorDAO {

	public List<Examenes> getAllExamenesByUsuario(String usuario);

	public Examenes getExamenById(int idExamen);
	
	public List<tema> getAllTemas();
	
	public List<Preguntas> getAllPreguntasByUsuario(String usuario);
	
	public List<Respuestas> getAllRespuestasByPregunta(long idPregunta);
	
	public boolean savePreguntas(List<Preguntas> preguntas);
	
	public List<Respuestas_x_alumno> getRespuestasXAlumnoByExamen(int idExamen);
	
	public Preguntas getPreguntaById(long idPregunta);
	
	public Respuestas getRespuestaById(long idRespuesta);
}
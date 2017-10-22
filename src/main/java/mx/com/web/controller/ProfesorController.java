package mx.com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.doo.Examenes;
import mx.com.doo.Grupo;
import mx.com.doo.Persona;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.doo.Respuestas_x_alumno;
import mx.com.service.GrupoService;
import mx.com.service.PersonaService;
import mx.com.service.ProfesorService;

@Controller
public class ProfesorController {
	
	protected final static Logger log = LoggerFactory.getLogger(ProfesorController.class);
	
	@Value("${user_alumno}")
	private String ROLE_ALUMNO;
	
	@Inject
	private ProfesorService profesorService;
	
	@Inject
	private PersonaService personaService;
	
	@Inject
	private GrupoService grupoService;
	
	@RequestMapping(value = "/profesor/preguntas", method = RequestMethod.GET)
	public ModelAndView preguntas(Authentication auth) {
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("modelado");
		try {
			model.addObject("temas", mapper.writeValueAsString(profesorService.getAllTemas()));
			List<Preguntas> preguntas = profesorService.getAllPreguntasByUsuario(auth.getName());
			for(int i=0;i<preguntas.size();i++){
				List<Respuestas> resp = profesorService.getAllRespuestasByPregunta(preguntas.get(i).getIdPregunta());
				Respuestas [] res = new Respuestas[resp.size()];
				preguntas.get(i).setRespuestas(resp.toArray(res));
			}
			model.addObject("preguntas", mapper.writeValueAsString(preguntas));
		} catch (JsonProcessingException e) {
			model.addObject("temas", "[]");
			model.addObject("preguntas", "[]");
			log.error(e.toString());
		}
		return model;
	}
	
	@RequestMapping(value="/profesor/preguntas/save", method=RequestMethod.POST)
	public ModelAndView guardarExamen(@RequestParam(value="preguntas", required=true) String preguntasStr,Authentication auth){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		String estatus="ok";
		try {
			List<Preguntas> preguntas = mapper.readValue(preguntasStr,new TypeReference<List<Preguntas>>(){});
			for(int i=0;i<preguntas.size();i++){
				preguntas.get(i).setUsuario(auth.getName());
				for(int j=0;j<preguntas.get(i).getRespuestas().length;j++){
					preguntas.get(i).getRespuestas()[j].setUsuario(auth.getName());
				}
			}
			if(!profesorService.savePreguntas(preguntas)){
				estatus="nook";
			}
		} catch (IOException e) {
			log.error(e.toString());
		}
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	@RequestMapping(value="/profesor/alumnos", method=RequestMethod.GET)
		public ModelAndView getAlumnos(Authentication auth){
			ModelAndView model = new ModelAndView();
			ObjectMapper mapper = new ObjectMapper();
			int idProfe = personaService.getIdUsername(auth.getName());
			List<Grupo> grupos = grupoService.getAllGruposByProfesor(idProfe);
			for(int i=0;i<grupos.size();i++){
				List<Persona> personas = personaService.getPersonas(ROLE_ALUMNO,grupos.get(i).getIdGrupo());
				for(int j=0;j<personas.size();j++){
					List<Examenes> examenes = profesorService.getAllExamenesByUsuario(personas.get(j).getUsername());
					for(int l=0;l<examenes.size();l++){
						List<Respuestas_x_alumno> respuestas = profesorService.getRespuestasXAlumnoByExamen(examenes.get(l).getIdExamen());
						for(int p=0;p<respuestas.size();p++){
							Preguntas [] pre = new Preguntas[]{profesorService.getPreguntaById(respuestas.get(p).getIdPregunta())};
							pre[0].setRespuestas(new Respuestas[]{profesorService.getRespuestaById(respuestas.get(p).getIdRespuesta())});
							examenes.get(l).setPreguntas(pre);
						}
					}
					Examenes [] exa = new Examenes[examenes.size()];
					personas.get(j).setExamenes(examenes.toArray(exa));
				}
				Persona [] per = new Persona[personas.size()];
				grupos.get(i).setPersonas(personas.toArray(per));
			}
			try {
				model.addObject("grupos", mapper.writeValueAsString(grupos));
			} catch (JsonProcessingException e) {
				model.addObject("grupos", "[]");
				log.error(e.toString());
			}
			model.setViewName("alumnos");
			return model;
	}
}
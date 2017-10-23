package mx.com.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.doo.Examenes;
import mx.com.doo.Persona;
import mx.com.doo.Preguntas;
import mx.com.doo.Respuestas;
import mx.com.service.AlumnoService;
import mx.com.service.PersonaService;

@Controller
public class AlumnoController {
	protected final static Logger log = LoggerFactory.getLogger(AlumnoController.class);
	
	@Inject
	private AlumnoService alumnoService;
	
	@Inject
	private PersonaService personaService;
	
	@RequestMapping(value = "/alumno/", method = RequestMethod.GET)
	public ModelAndView principal(Authentication auth) {
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		Persona per = personaService.getPersonasById(personaService.getIdUsername(auth.getName()));
		model.setViewName("principal");
		try {
			model.addObject("alumno", mapper.writeValueAsString(per));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
			model.addObject("alumno", "{}");
		}
		return model;
	}
	
	@RequestMapping(value = "/alumno/examen", method = RequestMethod.GET)
	public ModelAndView examen(Authentication auth) {
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		Persona per = personaService.getPersonasById(personaService.getIdUsername(auth.getName()));
		List<Preguntas> preguntas = alumnoService.getExamenByNivel(per.getNivel());
		for(int i=0;i<preguntas.size();i++){
			List<Respuestas> resp = alumnoService.getRespuestasByPregunta(preguntas.get(i).getIdPregunta());
			for(int j=0;j<resp.size();j++){
				resp.get(j).setCorrecto(false);
			}
			Respuestas [] respuestas = new Respuestas[resp.size()];
			preguntas.get(i).setRespuestas(resp.toArray(respuestas));
		}
		model.setViewName("examen");
		try {
			model.addObject("preguntas", mapper.writeValueAsString(preguntas));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
			model.addObject("preguntas", "[]");
		}
		return model;
	}

	@RequestMapping(value = "/alumno/examen/save", method = RequestMethod.POST)
	public ModelAndView saveExamen(@RequestParam(value="registro", required=true) String examenStr,Authentication auth){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		String estatus="ok";
		try {
			List<Preguntas> preguntas = mapper.readValue(examenStr,new TypeReference<List<Preguntas>>() {});
			Examenes examen = new Examenes();
			Preguntas [] pre = new Preguntas[preguntas.size()]; 
			examen.setUsuario(auth.getName());
			examen.setNombre("Examen-"+format.format(new Date()));
			examen.setPreguntas(preguntas.toArray(pre));
			alumnoService.saveExamen(examen);
		} catch (IOException e) {
			log.error(e.toString());
			estatus="nook";
		}
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	@RequestMapping(value = "/alumno/examenes", method = RequestMethod.GET)
	public ModelAndView examenes(Authentication auth) {
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("examenes");
		return model;
	}
}
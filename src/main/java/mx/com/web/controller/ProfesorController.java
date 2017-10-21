package mx.com.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.doo.Examenes;
import mx.com.service.ProfesorService;

@Controller
public class ProfesorController {
	
	protected final static Logger log = LoggerFactory.getLogger(ProfesorController.class);
	
	@Inject
	private ProfesorService profesorService;
	
	@RequestMapping(value = "/profesor/examenes", method = RequestMethod.GET)
	public ModelAndView modelado() {
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("examenes");
		List<Examenes> examenes = profesorService.getAllExamenes();
		try {
			model.addObject("examenes", mapper.writeValueAsString(examenes));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		}
		return model;
	}
	
	@RequestMapping(value = "/profesor/examenes/examen", method = RequestMethod.GET)
	public ModelAndView examenes(@RequestParam(value="examen",required=true) int idExamen) {
		ModelAndView model = new ModelAndView();
		model.setViewName("modelado");
		model.addObject("examen", profesorService.getExamenById(idExamen));
		return model;
	}
}
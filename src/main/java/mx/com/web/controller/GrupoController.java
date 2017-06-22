package mx.com.web.controller;

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

import mx.com.doo.Grupo;
import mx.com.service.GrupoService;

@Controller
public class GrupoController {

	protected final static Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	@Inject
	private GrupoService grupoService;
	
	@RequestMapping(value="/admin/grupos",method=RequestMethod.GET)
	public ModelAndView grupos(){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("grupos");
		try {
			model.addObject("gruposLista", mapper.writeValueAsString(grupoService.getAllGrupos()));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		}
		return model;
	}
	
	@RequestMapping(value="/admin/grupo",method=RequestMethod.GET)
	public ModelAndView grupo(@RequestParam(value="grupo", required = true) int grupo){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("grupo");
		if(grupo!=0){
			try {
				model.addObject("grupo", mapper.writeValueAsString(grupoService.getById(grupo)));
			} catch (JsonProcessingException e) {
				log.error(e.toString());
			}
		}else{
			try {
				model.addObject("grupo", mapper.writeValueAsString(new Grupo()));
			} catch (JsonProcessingException e) {
				log.error(e.toString());
			}
		}
		return model;
	}
}

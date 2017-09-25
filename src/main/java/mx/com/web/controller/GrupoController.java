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

import mx.com.doo.Grupo;
import mx.com.doo.Persona;
import mx.com.service.GrupoService;
import mx.com.service.PersonaService;

@Controller
public class GrupoController {

	protected final static Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	@Inject
	private GrupoService grupoService;
	
	@Inject
	private PersonaService personaService;
	
	@RequestMapping(value="/admin/grupos",method=RequestMethod.GET)
	public ModelAndView grupos(){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("grupos");
		try {
			List<Grupo> grupos = grupoService.getAllGrupos();
			for(int i=0;i<grupos.size();i++){
				if(grupos.get(i).getProfesor()>0){
					Persona per = personaService.getPersonasById(grupos.get(i).getProfesor());
					grupos.get(i).setAux(per.getNombre()+" "+per.getPaterno()+" "+per.getMaterno());
				}
			}
			model.addObject("gruposLista", mapper.writeValueAsString(grupos));
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
	
	@RequestMapping(value="/admin/grupo/registrar",method=RequestMethod.POST)
	public ModelAndView agregarGrupo(@RequestParam(value="registro", required = true) String registro){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		Grupo gru = null;
		String estatus ="OK";
		
		try{
			gru = mapper.readValue(registro, Grupo.class);
			log.info(gru.toString());
			boolean ret = grupoService.insertGrupo(gru);
			if(ret){
				estatus = "OK";
			}
			else{
				estatus = "Grupo no guardado";
			}
		}
		catch(Exception ex){
			log.error(ex.toString());
		}
		
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	@RequestMapping(value="/admin/grupo/eliminar",method=RequestMethod.POST)
	public ModelAndView deleteGrupo(@RequestParam(value="grupo", required = true) String grupo){
		ModelAndView model = new ModelAndView();
		Grupo gru = new Grupo();
		gru.setIdGrupo(Integer.parseInt(grupo));
		gru.setNombre("");
		String estatus ="OK";
		
		try{
			boolean ret = grupoService.deleteGrupo(gru);
			if(ret){
				estatus = "OK";
			}
			else{
				estatus = "Grupo no eliminado";
			}
		}
		catch(Exception ex){
			log.error(ex.toString());
		}
		
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	
	@RequestMapping(value="/admin/asignaProfesor",method=RequestMethod.POST)
	public ModelAndView asignaProfesor(@RequestParam(value="idGrupo", required = true)  int grupo, @RequestParam(value="profesor", required = true) String profesor){
		ModelAndView model = new ModelAndView();
		Grupo gru = grupoService.getById(grupo);
		gru.setProfesor(personaService.getIdUsername(profesor));
		String estatus ="OK";
		try{
			boolean ret = grupoService.insertGrupo(gru);
			if(ret)
				estatus="Se asigno correctamente el profesor";
			else
				estatus="No se pudo asignar correctamente el profesor";
		}
		catch(Exception ex){
			log.error(ex.toString());
		}
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}	
}
package mx.com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.doo.Persona;
import mx.com.doo.UserRoles;
import mx.com.doo.Users;
import mx.com.service.AdminFuncService;
import mx.com.service.GrupoService;
import mx.com.service.PersonaService;
import mx.com.web.security.PasswordGenerator;

@Controller
public class RegistroController {

	protected final static Logger log = LoggerFactory.getLogger(RegistroController.class);

	@Value("${user_alumno}")
	private String ROLE_ALUMNO;
	
	@Value("${user_profe}")
	private String ROLE_PROFE;
	
	@Inject
	private PasswordGenerator pass;
	
	@Inject
	private AdminFuncService adminService;
	
	@Inject
	private PersonaService personaService;
	
	@Inject
	private GrupoService grupoService;
	
	@RequestMapping(value="/registro", method = RequestMethod.GET)
	public ModelAndView regitro(@RequestParam(value="aux", required = false) String aux){
		ModelAndView model = new ModelAndView();
		model.setViewName("registro");
		model.addObject("grupos", grupoService.getAllGrupos());
		ObjectMapper mapper = new ObjectMapper();
		if(aux.equals("0"))
			model.addObject("alumno", "{}");
		else{
			try {
				model.addObject("alumno", mapper.writeValueAsString(personaService.getPersonasById(Integer.parseInt(aux))));
			} catch (NumberFormatException | JsonProcessingException e) {
				log.error(e.toString());
			}
		}
		return model;
	}
		
	@RequestMapping(value="/admin/registro", method = RequestMethod.GET)
	public ModelAndView registroprofesor(@RequestParam(value="aux", required = false) String aux){
		ModelAndView model = new ModelAndView();
		model.setViewName("registroprofesor");
		ObjectMapper mapper = new ObjectMapper();
		if(aux.equals("0"))
			model.addObject("profesor", "{}");
		else{
			try {
				model.addObject("profesor", mapper.writeValueAsString(personaService.getPersonasById(Integer.parseInt(aux))));
			} catch (NumberFormatException | JsonProcessingException e) {
				log.error(e.toString());
			}
		}
		return model;
	}
		
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ModelAndView regitrar(@RequestParam(value="registro", required = true) String registro){
		ObjectMapper mapper = new ObjectMapper();
		Persona alu = null;
		String estatus = "OK";
		try {
			alu = mapper.readValue(registro,Persona.class);
			if(alu.getId() == 0){
			Users users = new Users();
			users.setUsername(alu.getUsername());
			users.setPassword(pass.Generate("123456"));
			users.setEnabled(1);
			UserRoles userRole = new UserRoles();
			userRole.setRole(ROLE_ALUMNO);
			userRole.setUsername(alu.getUsername());
			if(adminService.InsertUser(users, userRole)){
				if(!personaService.InsertPersona(alu)){
					adminService.DeleteUser(users, userRole);
					estatus = "NOOK";
				}
			}
			}else{
				if(!personaService.UpdatePersona(alu))
					estatus="NOOK";
			}
		} catch (IOException e) {
			log.error(e.toString());
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}	
	
	@RequestMapping(value="/admin/registrar", method = RequestMethod.POST)
	public ModelAndView registrarP(@RequestParam(value="registro", required = true) String registro){
		ObjectMapper mapper = new ObjectMapper();
		Persona pro = null;
		String estatus = "OK";
		try {
			pro = mapper.readValue(registro,Persona.class);
			if(pro.getId()==0){
				pro.setGrupo(1);
				Users users = new Users();
				users.setUsername(pro.getUsername());
				users.setPassword(pass.Generate(pro.getContrasena()));
				users.setEnabled(1);
				UserRoles userRole = new UserRoles();
				userRole.setRole(ROLE_PROFE);
				userRole.setUsername(pro.getUsername());
				if(adminService.InsertUser(users, userRole)){
					if(!personaService.InsertPersona(pro)){
						adminService.DeleteUser(users, userRole);
						estatus = "NOOK";
					}
				}
			}else{
				if(!personaService.UpdatePersona(pro))
					estatus="NOOK";
			}
		} catch (IOException e) {
			log.error(e.toString());
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	@RequestMapping(value="/admin/profesores", method = RequestMethod.POST)
	public ModelAndView getProfesores(){
		ModelAndView model = new ModelAndView();
		model.setViewName("respuesta");
		List<Persona> personas = personaService.getPersonas(ROLE_PROFE);
		if(personas.size()>0){
			String [][] tmpPersonas = new String[2][personas.size()];
			for(int i=0;i<personas.size();i++){
				tmpPersonas[0][i] = personas.get(i).getUsername();
				tmpPersonas[1][i] = personas.get(i).getPaterno()+ " "+personas.get(i).getMaterno()+" "+personas.get(i).getNombre();
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				model.addObject("respuesta", mapper.writeValueAsString(tmpPersonas));
			} catch (JsonProcessingException e) {
				log.error(e.toString());
				model.addObject("respuesta", "[]");
			}
		}else{
			model.addObject("respuesta", "[]");
		}
		return model;
	}
	
	@RequestMapping(value="/admin/profesores", method = RequestMethod.GET)
	public ModelAndView getProfesoresLista(){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("profesores");
		try {
			model.addObject("profesores", mapper.writeValueAsString(personaService.getPersonas(ROLE_PROFE)));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		}		
		return model;
	}
	
	@RequestMapping(value="/admin/alumnos", method = RequestMethod.GET)
	public ModelAndView getAlumnoLista(){
		ModelAndView model = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		model.setViewName("alumnos");
		try {
			model.addObject("alumnos", mapper.writeValueAsString(personaService.getPersonas(ROLE_ALUMNO)));
		} catch (JsonProcessingException e) {
			log.error(e.toString());
		}		
		return model;
	}
}
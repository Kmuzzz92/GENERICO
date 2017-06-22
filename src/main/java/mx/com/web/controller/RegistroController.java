package mx.com.web.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView regitro(){
		ModelAndView model = new ModelAndView();
		model.setViewName("registro");
		model.addObject("grupos", grupoService.getAllGrupos());
		return model;
	}
		
	@RequestMapping(value="/admin/registro", method = RequestMethod.GET)
	public String registroprofesor(){
		return "registroprofesor";
	}
		
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ModelAndView regitrar(@RequestParam(value="registro", required = true) String registro){
		ObjectMapper mapper = new ObjectMapper();
		Persona alu = null;
		String estatus = "OK";
		try {
			alu = mapper.readValue(registro,Persona.class);
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
			
		} catch (IOException e) {
			log.error(e.toString());
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
}
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

import mx.com.doo.Alumno;
import mx.com.doo.UserRoles;
import mx.com.doo.Users;
import mx.com.service.AdminFuncService;
import mx.com.service.AlumnoService;
import mx.com.web.security.PasswordGenerator;

@Controller
public class RegistroController {

	protected final static Logger log = LoggerFactory.getLogger(RegistroController.class);

	@Value("${user_alumno}")
	private String ROLE_ALUMNO;
	
	@Inject
	private PasswordGenerator pass;
	
	@Inject
	private AdminFuncService adminService;
	
	@Inject
	private AlumnoService alumnoService;
	
	@RequestMapping(value="/registro", method = RequestMethod.GET)
	public String regitro(){
		return "registro";
	}
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ModelAndView regitrar(@RequestParam(value="registro", required = true) String registro){
		ObjectMapper mapper = new ObjectMapper();
		Alumno alu = null;
		String estatus = "OK";
		try {
			alu = mapper.readValue(registro,Alumno.class);
			Users users = new Users();
			users.setUsername(alu.getUsername());
			users.setPassword(pass.Generate("123456"));
			users.setEnabled(1);
			UserRoles userRole = new UserRoles();
			userRole.setRole(ROLE_ALUMNO);
			userRole.setUsername(alu.getUsername());
			if(adminService.InsertAlumnoUser(users, userRole)){
				if(!alumnoService.InsertAlumno(alu)){
					adminService.DeleteAlumnoUsers(users, userRole);
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
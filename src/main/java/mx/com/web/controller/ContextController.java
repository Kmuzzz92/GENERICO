package mx.com.web.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.com.service.AdminFuncService;


@Controller
public class ContextController {
	
	protected final static Logger log = LoggerFactory.getLogger(ContextController.class);
	
	@Inject
	private AdminFuncService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuario o Contraseña inválida!");
		}
		if (logout != null) {
			model.addObject("msg", "Usted ha salido exitosamente!!!");
		}
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied() {
		return "403";
	}
	
	@RequestMapping(value="/admin/activar", method = RequestMethod.POST)
	public ModelAndView activar(@RequestParam(value="username", required = true) String username){
		String estatus="OK";
		ModelAndView model = new ModelAndView();
		adminService.ActivarUsuario(username);
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
	
	@RequestMapping(value="/admin/desactivar", method = RequestMethod.POST)
	public ModelAndView desactivar(@RequestParam(value="username", required = true) String username){
		String estatus="OK";
		ModelAndView model = new ModelAndView();
		adminService.DesactivarUsuario(username);
		model.setViewName("respuesta");
		model.addObject("respuesta", estatus);
		return model;
	}
}

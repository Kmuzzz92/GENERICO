package mx.com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContextController {
	
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
	
	@RequestMapping(value="/registro", method = RequestMethod.GET)
	public String regitro(){
		return "registro";
	}
	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public String regitrar(ModelAndView model){
		return "registro";
	}
}

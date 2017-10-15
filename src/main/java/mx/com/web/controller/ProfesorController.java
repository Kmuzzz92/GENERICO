package mx.com.web.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProfesorController {
	
	protected final static Logger log = LoggerFactory.getLogger(ProfesorController.class);
	
	@RequestMapping(value = "/modelado", method = RequestMethod.GET)
	public ModelAndView modelado() {
		ModelAndView model = new ModelAndView();
		model.setViewName("modelado");
		return model;
	}
	
	@RequestMapping(value = "/examenes", method = RequestMethod.GET)
	public ModelAndView examenes() {
		ModelAndView model = new ModelAndView();
		model.setViewName("examenes");
		return model;
	}
}
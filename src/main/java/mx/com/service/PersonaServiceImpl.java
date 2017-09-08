package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppPersonaDAO;
import mx.com.doo.Persona;

@Service
@Transactional(readOnly=true)
public class PersonaServiceImpl implements PersonaService  {
	
	@Inject
	private AppPersonaDAO alumnoDAO;

	@Override
	public boolean InsertPersona(Persona persona) {
		return alumnoDAO.InsertPersona(persona);
	}
	
	@Override
	public List<Persona> getPersonas(String tipo){
		return alumnoDAO.getPersonas(tipo);
	}

	@Override
	public int getIdUsername(String username) {
		return alumnoDAO.getIdByUsername(username);
	}
}
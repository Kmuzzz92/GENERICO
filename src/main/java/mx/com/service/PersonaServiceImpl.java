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
	private AppPersonaDAO personaDAO;

	@Override
	public boolean InsertPersona(Persona persona) {
		return personaDAO.InsertPersona(persona);
	}
	
	@Override
	public List<Persona> getPersonas(String tipo){
		return personaDAO.getPersonas(tipo);
	}

	@Override
	public int getIdUsername(String username) {
		return personaDAO.getIdByUsername(username);
	}

	@Override
	public Persona getPersonasById(int id) {
		return personaDAO.getPersonasById(id);
	}

	@Override
	public boolean UpdatePersona(Persona persona) {
		return personaDAO.UpdatePersona(persona);
	}
}
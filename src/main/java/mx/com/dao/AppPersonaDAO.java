package mx.com.dao;

import java.util.List;

import mx.com.doo.Persona;

public interface AppPersonaDAO {
	
	public boolean InsertPersona(Persona persona);
	
	public List<Persona> getPersonas(String tipo);
	
	public int getIdByUsername(String username);
	
}

package mx.com.service;

import java.util.List;

import mx.com.doo.Persona;

public interface PersonaService{
	
	public boolean InsertPersona(Persona persona);
	
	public List<Persona> getPersonas(String tipo);
	
	public int getIdUsername(String username);
	
	public Persona getPersonasById(int id);
	
	public boolean UpdatePersona(Persona persona);
}
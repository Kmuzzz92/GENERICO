package mx.com.service;

import java.util.List;

import mx.com.doo.Grupo;

public interface GrupoService {

	public List<Grupo> getAllGrupos();
	
	public Grupo getById(int idGrupo);
	
	public boolean insertGrupo (Grupo grupo);
	
	public boolean deleteGrupo(Grupo grupo);
	
	public List<Grupo> getAllGruposByProfesor(int idProfesor);
}

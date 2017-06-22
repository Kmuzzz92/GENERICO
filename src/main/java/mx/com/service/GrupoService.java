package mx.com.service;

import java.util.List;

import mx.com.doo.Grupo;

public interface GrupoService {

	public List<Grupo> getAllGrupos();
	
	public Grupo getById(int idGrupo);
	
}

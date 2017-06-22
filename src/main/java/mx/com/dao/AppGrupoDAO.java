package mx.com.dao;

import java.util.List;

import mx.com.doo.Grupo;

public interface AppGrupoDAO {
	
	public List<Grupo> getAllGrupos();
	
	public Grupo getById(int idGrupo);

}

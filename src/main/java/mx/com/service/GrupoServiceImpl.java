package mx.com.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppGrupoDAO;
import mx.com.doo.Grupo;

@Service
@Transactional(readOnly=true)
public class GrupoServiceImpl implements GrupoService{

	@Inject
	private AppGrupoDAO grupoDAO;
	
	@Override
	public List<Grupo> getAllGrupos() {
		return grupoDAO.getAllGrupos();
	}

	@Override
	public Grupo getById(int idGrupo) {
		return grupoDAO.getById(idGrupo);
	}
	
	public  boolean insertGrupo(Grupo grupo){
		return grupoDAO.insertGrupo(grupo);
	}
	
	public boolean deleteGrupo(Grupo grupo){
		return grupoDAO.deleteGrupo(grupo);
	}

}

package mx.com.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.dao.AppFuncDAO;

@Service
@Transactional(readOnly=true)
public class AdminFuncServiceImpl implements AdminFuncService {

	@SuppressWarnings("unused")
	@Inject
	private AppFuncDAO funcDAO;
	
}

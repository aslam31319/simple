package org.jspiders.mvc.login.services;

import java.util.List;

import org.jspiders.mvc.login.model.EmpDTO;
import org.jspiders.mvc.login.repository.inf.EmpDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	private EmpDaoInf empDao;

	public List<EmpDTO> getAllEmp() {
		return empDao.getAllEmp();
	}
}

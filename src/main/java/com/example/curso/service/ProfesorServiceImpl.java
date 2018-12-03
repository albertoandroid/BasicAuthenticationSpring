package com.example.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.dao.IProfesorDao;
import com.example.curso.entity.Profesor;

@Service("profesorService")
public class ProfesorServiceImpl implements IProfesorService {
	
	@Autowired
	private IProfesorDao profesorDao;

	@Override
	public List<Profesor> findAllProfessors() {
		return (List<Profesor>) profesorDao.findAll();
	}

}

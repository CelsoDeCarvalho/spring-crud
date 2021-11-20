package com.app.service;

import com.app.model.Curso;
import com.app.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceImpl implements CursoService {

    @Autowired
    CursoRepository repository;

	@Override
	public List<Curso> listar() {
		return (List<Curso>)repository.findAll();
	}

	@Override
	public Curso procurarPorId(long id) {
		return repository.findById(id).get();
	}

	@Override
	public void salvar(Curso curso) {
		repository.save(curso);
	}

	@Override
	public void apagar(long id) {		
		repository.deleteById(id);
	}

    


}

package com.app.service;

import com.app.model.Curso;
import java.util.List;

public interface CursoService {

	List<Curso> listar();

	Curso procurarPorId(long id);

	void salvar(Curso curso);

	void apagar(long id);

}

package com.rossini.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rossini.cursomc.domain.Categoria;
import com.rossini.cursomc.domain.Produto;
import com.rossini.cursomc.repositories.CategoriaRepository;
import com.rossini.cursomc.repositories.ProdutoRepository;
import com.rossini.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search (String nome, List<Integer> id, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(id);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		
	}
}

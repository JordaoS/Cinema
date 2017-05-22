package br.ufc.qxd.vev.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.qxd.vev.bean.*;

@CrossOrigin(origins = "*")
@RestController
public class FilmeController {
	
	@RequestMapping("/filme/filmes")
	public ArrayList<Filme> getListFilme(){
		ArrayList<Filme> filmes = new ArrayList<>();
		ArrayList<Pessoa> equipe = new ArrayList<>();
		equipe.add(new Pessoa(1, "Erika", "Atriz"));
		equipe.add(new Pessoa(2, "Nathy", "Atriz"));
		equipe.add(new Pessoa(3, "Clarice", "Diretor"));
		Categoria categoria1 = new Categoria(1, "Suspense");
		Categoria categoria2 = new Categoria(2, "Drama");
		filmes.add(new Filme(1, "A Cabana", equipe, "Historia triste de um pai",
				3, categoria1,"3d"));
		filmes.add(new Filme(2, "O Impossível", equipe, "Historia de um maremoto",
				2, categoria2,"2d"));
		
		return filmes;
	}
	
	@RequestMapping("/filme/filmeporid/{id}")
	public Filme getFilmePorId(@RequestParam(value="id", defaultValue="1") int id){
		ArrayList<Pessoa> equipe = new ArrayList<>();
		equipe.add(new Pessoa(1, "Erika", "Atriz"));
		equipe.add(new Pessoa(2, "Nathy", "Atriz"));
		equipe.add(new Pessoa(3, "Clarice", "Diretor"));
		Categoria categoria = new Categoria(1, "Suspense");
		return new Filme(1, "A Cabana", equipe, "História triste de um pai", 
				3, categoria, "3d");
	}
}

package br.ufc.qxd.vev.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.qxd.vev.bean.*;

@CrossOrigin(origins = "*")
@RestController
public class SalaController {

	@RequestMapping("/sala/salaporcinema/{id}")
	public ArrayList<Sala> buscarSalaPorCinema(@RequestParam(value="id", defaultValue="1") int id){
		ArrayList<Sala> salas = new ArrayList<>();
		Cinema cinema = new Cinema(1, "O bom vizinho", "Quixadá");
		salas.add(new Sala(1, "Sala1", cinema, 40, "3d")); 
		return salas;
	}
	
	@RequestMapping("/sala/salaporid/{id}")
	public Sala getSalaById(@RequestParam(value="id", defaultValue="1") int id){
		Cinema cinema = new Cinema(1, "O bom vizinho", "Quixadá");
		return new Sala(1, "Sala1", cinema, 40, "3d");
	}
		
	
}

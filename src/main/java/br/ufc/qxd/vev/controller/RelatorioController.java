package br.ufc.qxd.vev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ufc.qxd.vev.bean.*;

@RestController
public class RelatorioController {

	private final String host = "http://localhost:8081";
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/relatorio/porcinema/{id}")
	public List<RelatorioFilme> buscarFilmePorCinema(@RequestParam(value="id", defaultValue="1") String id){		
		if(idIsInteger(id)){
			List<RelatorioFilme> relatorioDeFilme = new ArrayList<>();
			List<Filme> filmesDoCinema = new ArrayList<>();
			List<Sessao> sessoesDoCinema = new ArrayList<>();
			List<Sala> salasDoCinema = Arrays.asList(restTemplate.getForObject(host + "/sala/salaporcinema/" + id, Sala[].class)); 
			
			for(Sala sala : salasDoCinema){
				List<Sessao> sessoesDaSala = Arrays.asList(restTemplate.getForObject(host + "/sessao/getBySala/" + sala.getId(), Sessao[].class));
				for(Sessao sessao : sessoesDaSala){
					
					sessoesDoCinema.add(sessao);
					for(int i = 0; i < filmesDoCinema.size(); i++){
						if(filmesDoCinema.get(i).getId().equals(sessao.getFilme().getId())){
							filmesDoCinema.remove(i);
						}
					}
					filmesDoCinema.add(sessao.getFilme());
				}
			}

			for(Filme filme : filmesDoCinema){
				List<SalaSessao> salasSessoesDoFilme = new ArrayList<>();
				for(Sessao sessao : sessoesDoCinema){
					if(filme.getId().equals(sessao.getFilme().getId())){
						salasSessoesDoFilme.add(new SalaSessao(sessao.getSala().getQtdAcentos(),
								sessao.getSala().getTipo(), sessao.getSala().getNome(), 
								sessao.getHoraInicio() + ":00 - " + sessao.getHoraFim() + ":00",
								sessao.getData().toString()));
					}
				}
				relatorioDeFilme.add(new RelatorioFilme(filme, salasSessoesDoFilme));
			}

			return relatorioDeFilme;
		}
		
		return null;
	}

	@RequestMapping("/relatorio/porfilme/{id}")
	public List<RelatorioCinema> buscarCinemaPorFilme(@RequestParam(value="id", defaultValue="1") String id){
		if(idIsInteger(id)){
			List<RelatorioCinema> relatorioDoCinema = new ArrayList<>();
			List<Cinema> cinemasDoFilme = new ArrayList<>();
			List<Sessao> sessoesDoFilme = Arrays.asList(restTemplate.getForObject(host + "/sessao/getByFilme/" + id, Sessao[].class));
			
			for(Sessao sessao : sessoesDoFilme){
				for(int i = 0; i < cinemasDoFilme.size(); i++){
					if(cinemasDoFilme.get(i).getId().equals(sessao.getSala().getCinema().getId())){
						cinemasDoFilme.remove(i);
					}
				}
				cinemasDoFilme.add(sessao.getSala().getCinema());
			}
			
			for(Cinema cinema : cinemasDoFilme){
				List<SalaSessao> salasSessoesDoCinema = new ArrayList<>();
				for(Sessao sessao : sessoesDoFilme){
					if(cinema.getId().equals(sessao.getSala().getCinema().getId())){
						salasSessoesDoCinema.add(new SalaSessao(sessao.getSala().getQtdAcentos(),
								sessao.getSala().getTipo(), sessao.getSala().getNome(),
								sessao.getHoraInicio() + " - " + sessao.getHoraFim(),
								sessao.getData().toString()));
					}
				}
				relatorioDoCinema.add(new RelatorioCinema(cinema, salasSessoesDoCinema));
			}
			return relatorioDoCinema;
		}
		
		return null;
	}
	
	public boolean idIsInteger(String id){
		if(id.contains(".") || id.contains(",")){
			return false;
		}
		for(int i = 0; i < id.length(); i++){
			if(Character.isLetter(id.charAt(i))){
				return false;
			}
			
		}
		return true;
	}
}

package br.ufc.qxd.vev.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.qxd.vev.bean.Sessao;
import br.ufc.qxd.vev.services.ISessaoService;
import br.ufc.qxd.vev.util.CustomErrorType;


@RestController
@RequestMapping("/sessao")
@Produces("application/json")
public class SessaoRestController {

	public static final Logger logger = LoggerFactory.getLogger(SessaoRestController.class);

	@Autowired
	ISessaoService sessaoService;
	// Service which will do all data
	// retrieval/manipulation work

	@RequestMapping("/")
	public String home(){
		return "Hello World!";
	}


	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Sessao>> listAllSessoes() {
		List<Sessao> sessoes = sessaoService.findAllSessao();
		if (sessoes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Sessao>>(sessoes, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// User------------------------------------------

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSessao(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		Sessao sessao = sessaoService.findById(id);
		if (sessao == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Sessao com id " + id + " não encontrada"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Sessao>(sessao, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)	  
	@ResponseBody
	public String create(@RequestBody Sessao sessao) {
		String timeId = "";
		try {
			sessaoService.saveUser(sessao);
		}catch (Exception ex) {
			return "{\"message\": \"Erro ao cadastrar a sessão.\"}";
		}
		return "{\"message\": \"Sessão cadastrada com sucesso.\"}";
	}
	
	@RequestMapping(value = "/getByFilme/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getByFilme(@PathVariable("id") long id) {
		List<Sessao> sessoes = sessaoService.getSessaoByFilme(id);
		if (sessoes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Sessao>>(sessoes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBySala/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBySala(@PathVariable("id") long id) {
		List<Sessao> sessoes = sessaoService.getSessaoBySala(id);
		if (sessoes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Sessao>>(sessoes, HttpStatus.OK);
	}
}

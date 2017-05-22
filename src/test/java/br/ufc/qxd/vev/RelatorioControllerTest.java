package br.ufc.qxd.vev;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=CinemaApplication.class)
public class RelatorioControllerTest {
	
	private String JSONBuscarFilmePorCinema = "["
	+ "{" +
		"\"filme\":{\"id\":1,\"titulo\":\"A Cabana\","
		+ "\"atores\":["
					  +"{\"id\":1,\"nome\":\"Erika\",\"papel\":\"Atriz\"},"
					  +"{\"id\":2,\"nome\":\"Nathy\",\"papel\":\"Atriz\"},"
					  +"{\"id\":3,\"nome\":\"Clarice\",\"papel\":\"Diretor\"}"
					  +"],"
		+"\"sinopse\":\"Historia triste de um pai\",\"duracao\":3,"                                                
	    +"\"categoria\":{\"id\":1,\"nome\":\"Suspense\"},\"tipo\":\"3d\""
        +"},"                                                   
	    + "\"salasSessoesDoFilme\":["
        						 + "{\"qtdAcento\":40,\"tipo\":\"3d\",\"nome\":\"Sala1\",\"horario\":\"12:00 - 14:00\",\"data\":\"12/10/12\"},"
        						 + "{\"qtdAcento\":35,\"tipo\":\"2d\",\"nome\":\"Sala2\",\"horario\":\"20:00 - 22:00\",\"data\":\"12/10/12\"},"
        						 + "{\"qtdAcento\":40,\"tipo\":\"3d\",\"nome\":\"Sala1\",\"horario\":\"12:00 - 14:00\",\"data\":\"12/10/12\"},"
        						 + "{\"qtdAcento\":35,\"tipo\":\"2d\",\"nome\":\"Sala2\",\"horario\":\"20:00 - 22:00\",\"data\":\"12/10/12\"}"
	                             + "]"                      
	                                                   
	                                               
	+ "}"
	+ "]";
	
	private String JSONBuscarCinemaPorFilme = "["
	+ "{"
	    + "\"cinema\":{\"id\":1,\"nome\":\"O bom vizinho\",\"cidade\":\"Quixadá\"},"
	    + "\"salasSessoesDoCinema\":[{\"qtdAcento\":40,\"tipo\":\"3d\",\"nome\":\"Sala1\",\"horario\":\"12:00 - 14:00\",\"data\":\"12/10/12\"}]" 
	+ "},"        
	+ "{"
		+ "\"cinema\":{\"id\":2,\"nome\":\"Renato Aragão\",\"cidade\":\"Sobral\"},"
	    + "\"salasSessoesDoCinema\":[{\"qtdAcento\":35,\"tipo\":\"2d\",\"nome\":\"Sala2\",\"horario\":\"20:00 - 22:00\",\"data\":\"12/10/12\"}]"
	+ "}"	    
	+ "]";
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void verificaBuscarFilmePorCinemaComIdCinema() {
		String RelatorioFilmeJSON = this.restTemplate.getForObject("/relatorio/porcinema?id=2", String.class);
		assertEquals(JSONBuscarFilmePorCinema, RelatorioFilmeJSON);
	}
	
	@Test
	public void verificaBuscarFilmePorCinemaSemIdCinemaOuIdNulo(){
		String RelatorioFilmeJSON = this.restTemplate.getForObject("/relatorio/porcinema", String.class);
		assertEquals(JSONBuscarFilmePorCinema, RelatorioFilmeJSON);
	}
	
	@Test
	public void verificaBuscarFilmePorCinemaComIdCinemaSendoDecimal(){
		String RelatorioFilmeJSON = this.restTemplate.getForObject("/relatorio/porcinema?id=2.1", String.class);
		assertNull(RelatorioFilmeJSON);
	}
	
	@Test 
	public void verificaBuscarFilmePorCinemaComIdCinemaSendoString(){
		String RelatorioFilmeJSON = this.restTemplate.getForObject("/relatorio/porcinema?id=\"asdhiaf\"", String.class);
		assertNull(RelatorioFilmeJSON);
	}

	@Test
	public void verificaBuscarCinemaPorFilmeComIdFilme(){
		String RelatorioCinemaJSON = this.restTemplate.getForObject("/relatorio/porfilme?id=3", String.class);
		assertEquals(JSONBuscarCinemaPorFilme, RelatorioCinemaJSON);
	}
	
	@Test
	public void verificaBuscarCinemaPorFilmeSemIdFilmeOuIdNulo(){
		String RelatorioCinemaJSON = this.restTemplate.getForObject("/relatorio/porfilme", String.class);
		assertEquals(JSONBuscarCinemaPorFilme, RelatorioCinemaJSON);
	}
	
	@Test 
	public void verificaBuscarCinemaPorFilmeComIdFilmeSendoDecimal(){
		String RelatorioCinemaJSON = this.restTemplate.getForObject("/relatorio/porfilme?id=3.1", String.class);
		assertNull(RelatorioCinemaJSON);
	}
	
	@Test
	public void verificaBuscarCinemaPorFilmeComIdFilmeSendoString(){
		String RelatorioCinemaJSON = this.restTemplate.getForObject("/relatorio/porfilme?id=\"adaafhçcl\"", String.class);
		assertNull(RelatorioCinemaJSON);
	}
	
}

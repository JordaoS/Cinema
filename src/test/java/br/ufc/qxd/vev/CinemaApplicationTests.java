package br.ufc.qxd.vev;

import static com.jayway.restassured.RestAssured.given;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.gargoylesoftware.htmlunit.util.NameValuePair;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CinemaApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CinemaApplicationTests {

	@Test
	public void validateGetAll() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/getAll/");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertEquals("[{\"id\":0,\"filme\":\"dsafdsfas\",\"sala\":\"sdfasdf\",\"horaInicio\":10,\"horaFim\":2,\"data\":1305570998000}]", resultado);

	}

	@Test
	public void notValidateGetAll() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/getAll/");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertNotEquals("pepe", resultado);

	}

	@Test
	public void validateGetById() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/get/0");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertEquals("{\"id\":0,\"filme\":\"dsafdsfas\",\"sala\":\"sdfasdf\",\"horaInicio\":10,\"horaFim\":2,\"data\":1305570998000}", resultado);

	}

	@Test
	public void notValidationGetById() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/get/0");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertNotEquals("jack", resultado);

	}

	@Test
	public void errorValidationGetById() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/get/1");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertEquals("{\"errorMessage\":\"User with id 1 not found\"}", resultado);

	}
	@Test
	public void notErrorValidationGetById() throws Exception {
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();   
		HttpMethod method = new GetMethod("http://localhost:8081/sessao/get/1");   
		client.executeMethod(method);   
		String resultado = method.getResponseBodyAsString();
		assertNotEquals("{\"errorMessage\"}", resultado);

	}

	@Test
	public void validateAddSessao() throws Exception {
		
		String uri = "http://localhost:8081/sessao/create";
	    URL url = new URL(uri);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type", "application/json");

	    String input = "{\"filme\":\"1\", \"sala\":\"10\", \"horaInicio\": \"10:00 PM\", \"horaFim\": \"11:00 PM\", \"data\": \"2017-05-11\"}";

	    OutputStream os = conn.getOutputStream();
	    os.write(input.getBytes());
	    os.flush();

	  

	    BufferedReader br = new BufferedReader(new InputStreamReader(
	            (conn.getInputStream())));

	    String response = "";
	    String output;
	    while ((output = br.readLine()) != null) {
	        response += output;
	    }
	    conn.disconnect();
	    
	    assertEquals("{\"message\": \"Sessão cadastrada com sucesso.\"}", response);
	}
}
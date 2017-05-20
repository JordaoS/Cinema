package br.ufc.qxd.vev.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JoinColumn(name = "cinema", referencedColumnName = "id")
    @ManyToOne
	private Cinema cinema;
	
	private int qtdAcentos;
	private String tipo;

	public Sala(Integer id, String nome, Cinema cinema, int qtdAcentos, String tipo){
		this.id = id;
		this.nome = nome;
		this.cinema = cinema;
		this.qtdAcentos = qtdAcentos;
		this.tipo = tipo;
	}

	public Sala(){
		
	}
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public int getQtdAcentos() {
		return qtdAcentos;
	}
	public void setQtdAcentos(int qtdAcentos) {
		this.qtdAcentos = qtdAcentos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

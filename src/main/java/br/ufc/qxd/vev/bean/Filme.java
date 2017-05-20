package br.ufc.qxd.vev.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

	//@OneToMany(mappedBy="pessoa", targetEntity=Pessoa.class)
	//private List<Pessoa> atores;

	private String sinopse;
	private int duracao;

	@JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
	private Categoria categoria;

	private String tipo;

	public Filme(Integer id, String titulo, List<Pessoa> atores, String sinopse,
			int duracao, Categoria categoria, String tipo){
		this.setId(id);
		this.titulo = titulo;
		//this.atores =atores;
		this.sinopse = sinopse;
		this.duracao =duracao;
		this.categoria =categoria;
		this.tipo =tipo;
	}

	public Filme(){

	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/*public List<Pessoa> getAtores() {
		return atores;
	}
	public void setAtores(List<Pessoa> atores) {
		this.atores = atores;
	}*/
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}

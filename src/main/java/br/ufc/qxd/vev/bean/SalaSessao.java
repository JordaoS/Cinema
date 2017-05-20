package br.ufc.qxd.vev.bean;

public class SalaSessao {
	
	private Integer qtdAcento;
	private String tipo;
	private String nome;
	private String horario;
	private String data;
	
	public SalaSessao(Integer qtdAcento, String tipo, String nome, String horario, String data){
		this.qtdAcento = qtdAcento;
		this.tipo = tipo;
		this.nome = nome;
		this.horario = horario;
		this.data = data;
	}

	public Integer getQtdAcento() {
		return qtdAcento;
	}

	public void setQtdAcento(Integer qtdAcento) {
		this.qtdAcento = qtdAcento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}

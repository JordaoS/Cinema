package br.ufc.qxd.vev.bean;

import java.util.List;

public class RelatorioFilme {

	private Filme filme;
	private List<SalaSessao> salasSessoesDoFilme;
	
	public RelatorioFilme(Filme filme, List<SalaSessao> salasSessoesDoFilme) {
		this.filme = filme;
		this.salasSessoesDoFilme = salasSessoesDoFilme;
	}
	
	public RelatorioFilme(){
		
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<SalaSessao> getSalasSessoesDoFilme() {
		return salasSessoesDoFilme;
	}

	public void setSalasSessoesDoFilme(List<SalaSessao> salasSessoesDoFilme) {
		this.salasSessoesDoFilme = salasSessoesDoFilme;
	}	
}

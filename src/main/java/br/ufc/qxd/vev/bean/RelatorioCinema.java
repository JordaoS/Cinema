package br.ufc.qxd.vev.bean;

import java.util.List;

public class RelatorioCinema {
	
	private Cinema cinema;
	private List<SalaSessao> salasSessoesDoCinema;
	
	public RelatorioCinema(Cinema cinema, List<SalaSessao> salasSessoesDoCinema) {
		this.cinema = cinema;
		this.salasSessoesDoCinema = salasSessoesDoCinema;
	}
	
	public RelatorioCinema(){
		
	}
	
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<SalaSessao> getSalasSessoesDoCinema() {
		return salasSessoesDoCinema;
	}

	public void setSalasSessoesDoCinema(List<SalaSessao> salasSessoesDoCinema) {
		this.salasSessoesDoCinema = salasSessoesDoCinema;
	}
}

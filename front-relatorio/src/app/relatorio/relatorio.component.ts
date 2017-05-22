import { Component, OnInit } from '@angular/core';
import { RelatorioService } from './relatorio.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  providers: [RelatorioService]
})
export class RelatorioComponent implements OnInit {

  revelarPorCinema = false;
  revelarPorFilme = false;

  filmes = [];
  cinemas = [];
  relatorioCinema = [];
  relatorioFilme = [];

  constructor(private service: RelatorioService) {


    //pegando todos os cinemas
    this.service.getCinemas().subscribe(
      data => this.cinemas = data,
      erro => console.log(erro)
    )

    //pegando todos os filmes
    this.service.getFilmes().subscribe(
      data => this.filmes = data,
      erro => console.log(erro)
    )
  }

  relatorioPorCinema(id){
    this.service.gerarRelatoriPorCinema(id).subscribe(
      data => {
        this.relatorioCinema = data;
        this.revelarPorCinema = true;
      },
      erro => console.log(erro)
    )
  }

  relatorioPorFilme(id){
    this.service.gerarRelatoriPorFilme(id).subscribe(
      data => {
        this.relatorioFilme = data;
        this.revelarPorFilme = true;
      },
      erro => console.log(erro)
    )
  }

  voltarListaCidades(){
    this.revelarPorCinema = false;
  }
  voltarListaFilmes() {
    this.revelarPorFilme = false;
  }

  ngOnInit() {
  }

}

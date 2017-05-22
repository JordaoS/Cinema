import { Injectable } from '@angular/core';
import { Http, Response } from  '@angular/http';
import { Observable } from 'rxjs';

@Injectable()
export class RelatorioService {

  private url = "http://localhost:8080/";

  constructor(private http:Http) {
  }

  getCinemas() {
      return this.http.get(`${this.url}${"Cinema/listar"}`).map(
        (response : Response) => {
          return response.json();
        }
      ).catch(
        (erro : Response) => Observable.throw(erro)
      )
  }

  getFilmes() {
    return this.http.get(`${this.url}${"filme/filmes"}`).map(
      (response : Response) => {
        return response.json();
      }
    )
  }

  gerarRelatoriPorCinema(id) {
    return this.http.get(`${this.url}${"relatorio/porcinema/"}${id}`).map(
      (response : Response) => {
        return response.json();
      }
    ).catch(
      (erro : Response) => Observable.throw(erro)
    )
  }

gerarRelatoriPorFilme(id) {
  return this.http.get(`${this.url}${"relatorio/porfilme/"}${id}`).map(
    (response: Response) => {
      return response.json();
    }
  ).catch(
    (erro: Response) => Observable.throw(erro)
  )
}

}

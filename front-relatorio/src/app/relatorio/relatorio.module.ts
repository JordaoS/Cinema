import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RelatorioComponent } from './relatorio.component';
import { RelatorioService } from './relatorio.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    RelatorioComponent
  ],
  exports: [RelatorioComponent]
})
export class RelatorioModule { }

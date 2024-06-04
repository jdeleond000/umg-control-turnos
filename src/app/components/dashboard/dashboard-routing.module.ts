import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { InicioComponent } from './inicio/inicio.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { AsignacionesComponent } from './asignaciones/asignaciones.component';
import { TrabajadorComponent } from './trabajador/trabajador.component';
import { VacacionesComponent } from './vacaciones/vacaciones.component';
import { RrhhComponent } from './rrhh/rrhh.component';
import { NominaComponent } from './nomina/nomina.component';

const routes: Routes = [
  {
    path: '', component: DashboardComponent, children: [
      { path: '', component: InicioComponent },
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'catalogo', component: CatalogoComponent },
      { path: 'asignaciones', component: AsignacionesComponent },
      { path: 'trabajador', component: TrabajadorComponent },
      { path: 'vacaciones', component: VacacionesComponent },
      { path: 'rrhh', component: RrhhComponent },
      { path: 'nomina', component: NominaComponent },
    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }

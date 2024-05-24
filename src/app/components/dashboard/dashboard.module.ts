import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { InicioComponent } from './inicio/inicio.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SharedModule } from '../shared/shared.module';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { AsignacionesComponent } from './asignaciones/asignaciones.component';
import { TrabajadorComponent } from './trabajador/trabajador.component';
import { VacacionesComponent } from './vacaciones/vacaciones.component';
import { RrhhComponent } from './rrhh/rrhh.component';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
@NgModule({
  declarations: [
    DashboardComponent,
    UsuariosComponent,
    InicioComponent,
    NavbarComponent,
    CatalogoComponent,
    AsignacionesComponent,
    TrabajadorComponent,
    VacacionesComponent,
    RrhhComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    SharedModule,
    MatDividerModule,
    MatListModule,
    FormsModule,
    MatSelectModule,
    MatOptionModule,
    MatButtonModule,
    MatMenuModule,
    ReactiveFormsModule,
    MatTableModule,
    MatExpansionModule
  ]
})
export class DashboardModule { }

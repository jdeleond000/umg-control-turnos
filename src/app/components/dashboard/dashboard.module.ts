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
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MarcajeComponent } from './trabajador/modals/marcaje/marcaje.component';
import { AddEmpleadoComponent } from './rrhh/modals/add-empleado/add-empleado.component';
import { TextAreaModule } from '../inputs/text-area/text-area.module';
import { BaseSolicitudComponent } from './rrhh/modals/base-solicitud/base-solicitud.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AddSolicitudComponent } from './vacaciones/modals/add-solicitud/add-solicitud.component';
import { NominaComponent } from './nomina/nomina.component';
import { LoginComponent } from '../login/login.component';
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
    RrhhComponent,
    MarcajeComponent,
    AddEmpleadoComponent,
    BaseSolicitudComponent,
    AddSolicitudComponent,
    NominaComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    SharedModule,
    MatDividerModule,
    HttpClientModule,
    MatListModule,
    FormsModule,
    TextAreaModule,
    MatSelectModule,
    MatOptionModule,
    MatButtonModule,
    MatMenuModule,
    ReactiveFormsModule,
    MatTableModule,
    MatCardModule,
    MatExpansionModule,
    MatSelectModule,
    MatFormFieldModule
  ]
})
export class DashboardModule { }

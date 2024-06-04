import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { RRHH, empleados } from '../general';
import { GeneralService } from 'src/app/services/general.service';
import { EmpleadoRH } from 'src/app/interfaces/general.interface';
import { MatDialog } from '@angular/material/dialog';
import { AddEmpleadoComponent } from './modals/add-empleado/add-empleado.component';
import { BaseSolicitudComponent } from './modals/base-solicitud/base-solicitud.component';

@Component({
  selector: 'app-rrhh',
  templateUrl: './rrhh.component.html',
  styleUrls: ['./rrhh.component.css']
})
export class RrhhComponent implements OnInit {

  constructor(public dialog: MatDialog, private generalService: GeneralService) { }

  ngOnInit(): void {
    this.listEmpleadosRH();
  }
  dataSource: MatTableDataSource<EmpleadoRH> =
    new MatTableDataSource();

  displayedColumns: string[] = [
    'nit',
    'nombre',
    'apellido',
    'dpi',
    'correo',
    'telefono',
    'direccion',
    'fechaContratacion',
    'estado',
    'salario'
  ];

  listEmpleadosRH() {
    this.generalService.getEmpleadosRH().subscribe((empleadoSvc: EmpleadoRH[]) => {
      this.dataSource.data = empleadoSvc;
    });
  }

  add() {
    const dialogRef = this.dialog.open(AddEmpleadoComponent, {
      width: '75%',
      minWidth: '70%',
      data: {
      },
      disableClose: false
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  acciones() {
    // const dialogRef = this.dialog.open(MarcajeComponent, {
    //   width: '80%',
    //   minWidth: '300px',
    //   data: {
    //   },
    //   disableClose: false
    // });

    // dialogRef.afterClosed().subscribe(result => {
    // });
  }
}

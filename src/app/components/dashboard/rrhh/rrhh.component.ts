import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { RRHH, empleados } from '../general';
import { GeneralService } from 'src/app/services/general.service';
import { EmpleadoRH } from 'src/app/interfaces/general.interface';

@Component({
  selector: 'app-rrhh',
  templateUrl: './rrhh.component.html',
  styleUrls: ['./rrhh.component.css']
})
export class RrhhComponent implements OnInit {

  constructor(private generalService: GeneralService) { }

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
}

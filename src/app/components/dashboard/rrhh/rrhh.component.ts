import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { RRHH, empleados } from '../general';

@Component({
  selector: 'app-rrhh',
  templateUrl: './rrhh.component.html',
  styleUrls: ['./rrhh.component.css']
})
export class RrhhComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  dataSource: MatTableDataSource<RRHH> =
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
}

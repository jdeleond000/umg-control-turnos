import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { empleados } from '../general';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  dataSource: MatTableDataSource<empleados> =
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
    'estado'
  ];

}

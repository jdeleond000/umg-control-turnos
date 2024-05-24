import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { empleados } from '../general';
import { GeneralService } from 'src/app/services/general.service';
import { Empleado } from 'src/app/interfaces/general.interface';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  constructor(private generalService: GeneralService) { }

  ngOnInit(): void {

    this.getEmpleados();
  }

  dataSource: MatTableDataSource<Empleado> =
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

  getEmpleados() {
    this.generalService.getEmpleados().subscribe((empleadoSvc: Empleado[]) => {
      this.dataSource.data = empleadoSvc;
    });
  }

}

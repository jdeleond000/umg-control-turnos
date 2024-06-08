import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { EmpleadoRH } from 'src/app/interfaces/general.interface';
import { ExportExcelService } from 'src/app/services/export-excel.service';
import { GeneralService } from 'src/app/services/general.service';

@Component({
  selector: 'app-nomina',
  templateUrl: './nomina.component.html',
  styleUrls: ['./nomina.component.css']
})
export class NominaComponent implements OnInit {

  constructor(public dialog: MatDialog, private generalService: GeneralService, private excelExport: ExportExcelService,) { }

  ngOnInit(): void {
    this.listEmpleadosRH();
  }
  dataExcel: [] = [];
  dataSource: MatTableDataSource<EmpleadoRH> = new MatTableDataSource();

  displayedColumns: string[] = [
    'nit',
    'nombre',
    'apellido',
    'dpi',
    'correo',
    'direccion',
    'fechaContratacion',
    'salario',
    'iva',
    'igss',
    'totalDevengado'
  ];

  listEmpleadosRH() {
    this.generalService.getEmpleadosRH().subscribe((empleadoSvc: EmpleadoRH[]) => {
      this.dataSource.data = empleadoSvc.map(empleado => {
        // Calculo de IVA (12% del salario)
        empleado.iva = empleado.salario * 0.12;
        // Calculo de IGSS (4.83% del salario)
        empleado.igss = empleado.salario * 0.0483;
        // Calculo del total devengado (salario - IGSS)
        empleado.totalDevengado = empleado.salario - empleado.igss;
        return empleado;
      });
    });
  }

  export() {
    this.excelExport.exportToExcel(
      this.dataSource.data,
      'calculo_nomina'
    );
  }
}

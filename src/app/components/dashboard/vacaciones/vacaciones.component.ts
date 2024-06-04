import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { catalogoRegistroSolicitud } from 'src/app/interfaces/general.interface';
import { GeneralService } from 'src/app/services/general.service';
import { BaseSolicitudComponent } from '../rrhh/modals/base-solicitud/base-solicitud.component';
import { AddSolicitudComponent } from './modals/add-solicitud/add-solicitud.component';

@Component({
  selector: 'app-vacaciones',
  templateUrl: './vacaciones.component.html',
  styleUrls: ['./vacaciones.component.css']
})
export class VacacionesComponent implements OnInit {
  displayedColumns: string[] = ['idSolicitud', 'tipoSolicitud', 'estado', 'fechaInicio', 'fechaFin', 'comentario', 'opciones'];
  dataSource = new MatTableDataSource<catalogoRegistroSolicitud>();
  panelOpenState = false;
  solicitudes: catalogoRegistroSolicitud[] = [];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(public dialog: MatDialog, private generalService: GeneralService) { }

  ngOnInit(): void {
    this.getSolcitudes();
  }

  getSolcitudes() {
    this.generalService.getcatalogoRegistroSolicitud('123').subscribe((data: catalogoRegistroSolicitud[]) => {
      this.solicitudes = data;
      this.dataSource.data = data;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  crearSolicitud() {
    // Lógica para crear una nueva solicitud
  }

  acciones() {
    // Lógica para editar la solicitud con el id dado
  }
  add(id: string) {
    const dialogRef = this.dialog.open(BaseSolicitudComponent, {
      width: '75%',
      minWidth: '70%',
      data: {
        id: id,
      },
      disableClose: false
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  addSolicitud() {
    const dialogRef = this.dialog.open(AddSolicitudComponent, {
      width: '75%',
      minWidth: '70%',
      data: {
      },
      disableClose: false
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

}

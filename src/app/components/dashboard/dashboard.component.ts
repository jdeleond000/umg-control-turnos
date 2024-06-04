import { Component, OnInit } from '@angular/core';
import { AddSolicitudComponent } from './vacaciones/modals/add-solicitud/add-solicitud.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void { }

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

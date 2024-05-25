import { Component, OnInit, OnDestroy } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MarcajeComponent } from './modals/marcaje/marcaje.component';

@Component({
  selector: 'app-trabajador',
  templateUrl: './trabajador.component.html',
  styleUrls: ['./trabajador.component.css']
})
export class TrabajadorComponent implements OnInit, OnDestroy {
  time: string = '00:00:00';
  intervalId: any;

  constructor(
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.updateTime();
    this.intervalId = setInterval(() => {
      this.updateTime();
    }, 1000);
  }

  ngOnDestroy(): void {
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }

  updateTime(): void {
    const options: Intl.DateTimeFormatOptions = {
      timeZone: 'America/Guatemala',
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit',
      hour12: false
    };
    this.time = new Intl.DateTimeFormat('en-US', options).format(new Date());
  }

  marcaje() {
    const dialogRef = this.dialog.open(MarcajeComponent, {
      width: '80%',
      minWidth: '300px',
      data: {
      },
      disableClose: false
    });

    dialogRef.afterClosed().subscribe(result => {
    });
  }
}


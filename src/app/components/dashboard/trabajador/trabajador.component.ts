import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-trabajador',
  templateUrl: './trabajador.component.html',
  styleUrls: ['./trabajador.component.css']
})
export class TrabajadorComponent implements OnInit, OnDestroy {
  time: string = '00:00:00'; // Inicializa time en la declaración
  intervalId: any;

  constructor() { }

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
}

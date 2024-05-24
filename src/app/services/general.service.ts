import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../interfaces/general.interface';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  constructor(private httpClient: HttpClient) { }

  urlBase: string = `${environment.GENERAL}`;

  getEmpleados(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${this.urlBase}/empleados/listEmpleados`);
  }

  getEmpleadosRH(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${this.urlBase}/empleados/listEmpleadosbyRRHH`);
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado, catalogoRegistroSolicitud, catalogos, dataSolicitudes } from '../interfaces/general.interface';
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

  getListCatalogo(): Observable<catalogos[]> {
    return this.httpClient.get<catalogos[]>(`${this.urlBase}/marcajes/listCatalogo`);
  }

  postSaveMarcaje(datos: any): Observable<any> {
    return this.httpClient
      .post(`${this.urlBase}/marcajes/save`, datos, { responseType: 'json' })
  }

  login(datos: any): Observable<any> {
    return this.httpClient
      .post(`${this.urlBase}/empleados/login`, datos);
  }

  postEmpleadoSave(datos: any): Observable<any> {
    return this.httpClient
      .post(`${this.urlBase}/empleados/save`, datos, { responseType: 'json' })
  }

  getCatalogoSolicitud(codigoCatalogo: number): Observable<dataSolicitudes[]> {
    return this.httpClient.get<dataSolicitudes[]>(
      `${this.urlBase}/solicitudes/catalogoSolicitud/${codigoCatalogo}`,
    );
  }

  getcatalogoRegistroSolicitud(nit: string): Observable<catalogoRegistroSolicitud[]> {
    return this.httpClient.get<catalogoRegistroSolicitud[]>(
      `${this.urlBase}/solicitudes/catalogoRegistroSolicitud/${nit}`,
    );
  }

  autorizarRechazar(comentario: string, estado: string, id: number) {
    return this.httpClient.put(
      `${this.urlBase}/solicitudes/autorizarRechazarSolicitud/${comentario}/${estado}/${id}`,
      {}
    );
  }

  getEmpleadosSearch(cui: string): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(
      `${this.urlBase}/solicitudes/empleadoSearch/${cui}`,
    );
  }

  updateTurno(turno: number, nit: string) {
    return this.httpClient.put(
      `${this.urlBase}/solicitudes/updateTurno/${turno}/${nit}`,
      {}
    );
  }

  getCatalogoSearch(codigoCatalogo: number): Observable<catalogos[]> {
    return this.httpClient.get<catalogos[]>(`${this.urlBase}/solicitudes/catalogoSearch/${codigoCatalogo}`);
  }
}

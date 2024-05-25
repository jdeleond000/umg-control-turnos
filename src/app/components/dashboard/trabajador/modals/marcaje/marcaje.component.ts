import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { catalogos } from 'src/app/interfaces/general.interface';
import { GeneralService } from 'src/app/services/general.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-marcaje',
  templateUrl: './marcaje.component.html',
  styleUrls: ['./marcaje.component.css']
})
export class MarcajeComponent implements OnInit {

  form = this.fb.group({
    tipoInfraccion: [''],
  });

  catalogos: catalogos[] = [];
  currentDate: string = this.getCurrentDate(); // Inicialización de la variable

  constructor(
    private fb: FormBuilder,
    private generalService: GeneralService,
    private dialogRef: MatDialogRef<MarcajeComponent>
  ) { }

  ngOnInit(): void {
    this.getCatalogos();
    this.getCurrentDate();
  }

  getCatalogos() {
    this.generalService
      .getListCatalogo()
      .subscribe((cat) => {
        this.catalogos = cat.filter(catalogo =>
          catalogo.descripcionCatalogo === 'Entrada a labores' ||
          catalogo.descripcionCatalogo === 'Salida de labores'
        );
      });
  }

  getCurrentDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }

  cancel() {
    this.dialogRef.close();
  }

  marcar() {
    const datos = {
      nit: '123',
      tipoMarcaje: this.form.get('tipoInfraccion')?.value.idCatalogo,
      fecha: this.currentDate,
      llegadaTardia: false
    }
    this.generalService.postSaveMarcaje(datos).subscribe(
      (data) => {
        Swal.fire({
          icon: 'success',
          text: 'Marcaje realizado con éxito',
          confirmButtonText: 'Aceptar',
          confirmButtonColor: '#186ca4',
        });
        this.dialogRef.close();
      },
      (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Ocurrió un error',
          text: 'Error al realizar el marcaje',
          confirmButtonColor: '#146498',
        });
      }
    );
  }
}

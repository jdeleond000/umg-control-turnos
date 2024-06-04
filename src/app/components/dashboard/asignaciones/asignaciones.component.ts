import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Empleado, catalogos, motivo, tipoSolicitud } from 'src/app/interfaces/general.interface';
import { GeneralService } from 'src/app/services/general.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-asignaciones',
  templateUrl: './asignaciones.component.html',
  styleUrls: ['./asignaciones.component.css']
})
export class AsignacionesComponent implements OnInit {
  disabledSave: boolean = true;
  catalogo_motivo: motivo[] = [];
  catalogo_solicitud: tipoSolicitud[] = [];
  selectedCodigo: string = '';

  form = this.fb.group({
    cui: ['', [Validators.required]],
    nombre: [{ value: '', disabled: true }],
    apellido: [{ value: '', disabled: true }],
    nit: [{ value: '', disabled: true }],
    direccion: [{ value: '', disabled: true }],
    tipoSolicitud: [''],
    motivo: ['']
  });

  constructor(
    private fb: FormBuilder,
    private generalService: GeneralService
  ) { }

  ngOnInit(): void {
    this.getCatalogos();
  }
  catalogos: catalogos[] = [];

  findExpediente(): void {
    const cui = this.form.get('cui')?.value;

    this.generalService.getEmpleadosSearch(cui).subscribe(
      (data: Empleado[]) => {
        if (data && data.length > 0) {
          const item: Empleado = data[0]; // Seleccionar el primer empleado de la lista

          this.form.patchValue({
            nombre: item.nombre,
            apellido: item.apellido,
            nit: item.nit,
            direccion: item.direccion
          });

          this.disabledSave = false;
        } else {
          Swal.fire('Error', 'Intente con otro CUI', 'error');
        }
      },
      (error) => {
        Swal.fire('Error', 'Ocurrió un error', 'error');
      }
    );
  }

  getCatalogos() {
    this.generalService
      .getListCatalogo()
      .subscribe((cat) => {
        this.catalogos = cat.filter(catalogo =>
          catalogo.idCatalogo === '4' ||
          catalogo.idCatalogo === '5'
        );
      });
  }

  saveSolicitud() {
    if (!this.form.valid) {
      Swal.fire({
        icon: 'warning',
        title: '¡Advertencia!',
        text: 'Todos los campos son necesarios',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: '#146498'
      });
      return;
    }

    const nit = this.form.get('nit')?.value;
    const turno = this.form.get('tipoSolicitud')?.value;;

    this.generalService.updateTurno(turno, nit).subscribe(() => {
      Swal.fire({
        icon: 'success',
        title: '¡Éxito!',
        text: 'Asignación actualizada',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: "#0b69a1"
      }).then(result => {
        window.location.reload();
      });
    },
      (error: any) => {
        if (error.status === 405) {
          Swal.fire({
            icon: 'error',
            title: 'Ocurrió un error',
            // html: 'Error no se encontró No. expediente: No. Expediente Invalido.',
            html: 'Ocurrió un error inesperado',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#146498',
          });
        }
      });
  }
}

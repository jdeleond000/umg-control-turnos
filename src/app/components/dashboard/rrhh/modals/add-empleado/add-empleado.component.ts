import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { GeneralService } from 'src/app/services/general.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-empleado',
  templateUrl: './add-empleado.component.html',
  styleUrls: ['./add-empleado.component.css']
})
export class AddEmpleadoComponent implements OnInit {
  form = this.fb.group({

    nit: ['', [Validators.required, Validators.maxLength(600)]],
    nombre: ['', [Validators.required, Validators.maxLength(200)]],
    apellido: ['', [Validators.required, Validators.maxLength(13000)]],
    contrasena: ['', [Validators.required, Validators.maxLength(800)]],
    dpi: ['', [Validators.required, Validators.maxLength(600)]],
    correoElectronico: ['', [Validators.required, Validators.maxLength(200)]],
    numeroTelefono: ['', [Validators.required, Validators.maxLength(200)]],
    direccion: ['', [Validators.required, Validators.maxLength(200)]],
    cargoId: ['', [Validators.required, Validators.maxLength(200)]],
    email: ['', [Validators.required, Validators.maxLength(200)]],
    fechaContratacion: ['', [Validators.required, Validators.maxLength(200)]],
    salario: ['', [Validators.required, Validators.maxLength(200)]],
    //turno: ['', [Validators.required, Validators.maxLength(200)]],

  });
  constructor(private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddEmpleadoComponent>,
    private generalService: GeneralService
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.dialogRef.close();
  }

  // saveSolicitud() {

  //   if (!this.form.valid) {
  //     Swal.fire({
  //       icon: 'warning',
  //       title: '¡Advertencia!',
  //       text: 'Todos los campos son necesarios',
  //       confirmButtonText: 'Aceptar',
  //       confirmButtonColor: '#146498'
  //     });
  //     return;
  //   }

  //   const datos = {
  //     noExpediente: this.form.get('noExpediente').value,
  //     descripcion: this.form.get('descripcion').value,
  //     tipoSolicitud: this.form.get('tipoSolicitud').value.codigo,
  //     motivo: this.form.get('motivo').value.codigo
  //   };

  //   this.generalService.postSaveSolicitud(datos).subscribe(() => {
  //     console.log(datos)
  //     Swal.fire({
  //       icon: 'success',
  //       title: '¡Éxito!',
  //       text: 'Solicitud creada',
  //       confirmButtonText: 'Aceptar',
  //       confirmButtonColor: "#0b69a1"
  //     }).then(result => {
  //       this.dialogRef.close();
  //       window.location.reload();
  //     });
  //   },
  //     (error: any) => {
  //       if (error.status === 405) {
  //         Swal.fire({
  //           icon: 'error',
  //           title: 'Ocurrió un error',
  //           // html: 'Error no se encontró No. expediente: No. Expediente Invalido.',
  //           html: 'Número de Expediente Invalido.',
  //           confirmButtonText: 'Aceptar',
  //           confirmButtonColor: '#146498',
  //         });
  //       }
  //     }
  //   );

  // }
}

import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { GeneralService } from 'src/app/services/general.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-base-solicitud',
  templateUrl: './base-solicitud.component.html',
  styleUrls: ['./base-solicitud.component.css']
})
export class BaseSolicitudComponent implements OnInit {
  selectedValue: string = '';
  comment: string = '';
  id: number = 0;

  actions: { value: string, viewValue: string }[] = [
    { value: 'autorizar', viewValue: 'Autorizar' },
    { value: 'rechazar', viewValue: 'Rechazar' }
  ];

  constructor(private dialogRef: MatDialogRef<BaseSolicitudComponent>,
    private generalService: GeneralService,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.id = this.data.id;
  }

  cancel(): void {
    this.dialogRef.close();
  }

  send(): void {

    this.generalService.autorizarRechazar(this.comment, this.selectedValue, this.id).subscribe((data: any) => {
      console.log(this.comment, this.selectedValue, this.id)
      Swal.fire({
        icon: 'success',
        title: '¡Éxito!',
        text: 'Asignación actualizada',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: "#0b69a1"
      }).then(result => {
        window.location.reload();
      });
    })
  }
}

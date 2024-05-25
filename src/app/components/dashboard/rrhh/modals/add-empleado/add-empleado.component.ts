import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

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
    turno: ['', [Validators.required, Validators.maxLength(200)]],

  });
  constructor(private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddEmpleadoComponent>,
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.dialogRef.close();
  }

  send() { }
}

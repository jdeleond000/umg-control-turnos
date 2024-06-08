import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { catalogos, catalogosPuesto } from 'src/app/interfaces/general.interface';
import { GeneralService } from 'src/app/services/general.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-empleado',
  templateUrl: './add-empleado.component.html',
  styleUrls: ['./add-empleado.component.css']
})
export class AddEmpleadoComponent implements OnInit {
  form = this.fb.group({
    nit: ['', [Validators.required, Validators.maxLength(15)]],
    nombre: ['', [Validators.required, Validators.maxLength(50)]],
    apellido: ['', [Validators.required, Validators.maxLength(50)]],
    contrasena: ['', [Validators.required, Validators.maxLength(50)]],
    dpi: ['', [Validators.required, Validators.maxLength(50)]],
    correoElectronico: ['', [Validators.required, Validators.maxLength(255)]],
    numeroTelefono: ['', [Validators.required, Validators.maxLength(20)]],
    direccion: ['', [Validators.required, Validators.maxLength(50)]],
    email: ['', [Validators.required, Validators.maxLength(100)]],
    fechaContratacion: ['', [Validators.required, Validators.maxLength(200)]],
    salario: ['', [Validators.required, Validators.maxLength(200)]],
    turno: ['', Validators.required],
    cargo: [null, Validators.required],
  });

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddEmpleadoComponent>,
    private generalService: GeneralService
  ) { }

  currentDate: string = this.getCurrentDate();

  getCurrentDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }

  catalogos: catalogos[] = [];
  catalogoss: catalogos[] = [];

  ngOnInit(): void {
    this.getCatalogos();
    this.getCatalogosPuesto();
  }

  cancel(): void {
    this.dialogRef.close();
  }

  saveEmpleado() {
    if (!this.form.valid) {
      console.log('Formulario no válido', this.form.errors);
      Swal.fire({
        icon: 'warning',
        title: '¡Advertencia!',
        text: 'Todos los campos son necesarios',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: '#146498'
      });
      return;
    }

    const datos = {
      nit: this.form.get('nit')?.value,
      nombre: this.form.get('nombre')?.value,
      apellido: this.form.get('apellido')?.value,
      contrasena: this.form.get('contrasena')?.value,
      dpi: this.form.get('dpi')?.value,
      correoElectronico: this.form.get('correoElectronico')?.value,
      numeroTelefono: this.form.get('numeroTelefono')?.value,
      direccion: this.form.get('direccion')?.value,
      email: this.form.get('email')?.value,
      fechaContratacion: this.form.get('fechaContratacion')?.value,
      salario: this.form.get('salario')?.value,
      turno: this.form.get('turno')?.value,
      cargo: this.form.get('cargo')?.value?.idCatalogo,  // Solo el ID del catálogo
      fecha: this.currentDate,
      llegadaTardia: false
    };

    console.log('Datos enviados:', datos);

    // Aquí puedes enviar los datos a tu servicio
    // this.generalService.saveEmpleado(datos).subscribe(() => {
    //   Swal.fire({
    //     icon: 'success',
    //     title: '¡Éxito!',
    //     text: 'Empleado guardado',
    //     confirmButtonText: 'Aceptar',
    //     confirmButtonColor: "#0b69a1"
    //   }).then(result => {
    //     this.dialogRef.close();
    //     window.location.reload();
    //   });
    // },
    //   (error: any) => {
    //     Swal.fire({
    //       icon: 'error',
    //       title: 'Ocurrió un error',
    //       text: 'Error inesperado',
    //       confirmButtonText: 'Aceptar',
    //       confirmButtonColor: '#146498',
    //     });
    //   }
    // );
  }

  getCatalogos() {
    this.generalService.getListCatalogo().subscribe((cat) => {
      this.catalogos = cat.filter(catalogo =>
        catalogo.idCatalogo === '4' || catalogo.idCatalogo === '5'
      );
      console.log('Catalogos cargados:', this.catalogos);
    });
  }

  getCatalogosPuesto() {
    this.generalService.getCatalogoSearch(1).subscribe((cat: catalogos[]) => {
      this.catalogoss = cat;
      console.log('CatalogosPuesto cargados:', this.catalogoss);
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GeneralService } from 'src/app/services/general.service';
import { SeguridadSvcService } from 'src/app/services/seguridad-svc.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  logo = 'http://assets.stickpng.com/images/5847ea22cef1014c0b5e4833.png';
  datos = {
    username: '',
    password: ''
  };
  errorMessage: string = '';

  constructor(private router: Router, private generalService: GeneralService, private seguridad: SeguridadSvcService) { }

  ngOnInit(): void { }

  ingresar() {
    this.generalService.login(this.datos).subscribe(res => {
      this.seguridad.setUsuario(
        res.tokenType + res.accessToken,
        res.codigo_rol,
        res.nit
      );
      this.router.navigateByUrl('/dashboard');

    }, error => {
      this.errorMessage = 'Error al intentar iniciar sesión. Por favor, intente nuevamente.';
    });
  }


}

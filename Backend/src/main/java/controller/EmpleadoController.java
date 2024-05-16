package controller;

import Service.Impl.EmpleadoSvcImpl;
import components.Exceptiones;
import dto.EmpleadoDto;
import dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoSvcImpl empleadoSvcImpl;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveEMpleado(@RequestBody EmpleadoDto e) {
        try {
            return ResponseEntity.ok(empleadoSvcImpl.guardarEmpleado(e));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ahorro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

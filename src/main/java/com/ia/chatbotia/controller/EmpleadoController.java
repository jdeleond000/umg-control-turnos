/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Entity.Empleados;
import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.Service.Impl.EmpleadoSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.EmpleadoDto;
import com.ia.chatbotia.dto.LoginRequest;
import com.ia.chatbotia.dto.ResponseDto;
import com.ia.chatbotia.projection.RHProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import com.nimbusds.jose.JOSEException;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jairo
 */
@RestController
@Slf4j
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @Autowired
    EmpleadoSvcImpl empleadoSvcImpl;
    
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoDto dato) {
        try {
            return ResponseEntity.ok(empleadoSvcImpl.guardarEmpleado(dato));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ahorro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @GetMapping("/listEmpleados")
    @ApiOperation("Muestra el listado general de empleados")
    public ResponseEntity<List<empleadoProjection>> listarEmpleados() {
        List<empleadoProjection> lista = empleadoSvcImpl.listaEmpleado();
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/listEmpleadosbyRRHH")
    @ApiOperation("Muestra el listado general de empleados para RRHH")
    public ResponseEntity<List<RHProjection>> listaEmpleadoRH() {
        List<RHProjection> lista = empleadoSvcImpl.listaEmpleadoRH();
        return ResponseEntity.ok(lista);
    }
    
     @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws JOSEException {
        //crearUsuarioAdmi();
        return ResponseEntity.ok(empleadoSvcImpl.logueo(loginRequest)).getBody();
    }

    @GetMapping(value = "/findUsuarioByusername/{username}")
    public Empleados findUsuarioByusername(@PathVariable(required = true) String username) {
        return ResponseEntity.ok(empleadoSvcImpl.findUsuarioByUsername(username)).getBody();
    }
    
}

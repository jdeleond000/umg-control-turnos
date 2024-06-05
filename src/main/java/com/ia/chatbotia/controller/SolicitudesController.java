/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.controller;
import com.ia.chatbotia.Service.Impl.SolicitudesSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.ResponseDto;
import com.ia.chatbotia.dto.SolicitudesDto;
import com.ia.chatbotia.projection.solicitudesProjection;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author jairo
 */
@RestController
@Slf4j
@RequestMapping("/solicitudes")
public class SolicitudesController {
    
    @Autowired
    SolicitudesSvcImpl solicitudesSvcImpl;
    
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody SolicitudesDto dato) {
        try {
            return ResponseEntity.ok(solicitudesSvcImpl.guardarsolicitudes(dato));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ahorro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @GetMapping("/listSolicitudes")
    @ApiOperation("Muestra el listado general de solicitudes")
    public ResponseEntity<List<solicitudesProjection>> listSolicitudes() {
        List<solicitudesProjection> lista = solicitudesSvcImpl.listSolicitud();
        return ResponseEntity.ok(lista);
    }
    
    
}

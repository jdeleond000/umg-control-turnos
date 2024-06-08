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
import com.ia.chatbotia.projection.CatalogoProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import com.ia.chatbotia.projection.solicitudesProjection;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path = "/empleadoSearch/{cui}")
    @ApiOperation("Busqueda de empleado por cui")
    public ResponseEntity<List<empleadoProjection>> empleadoSearch(
            @PathVariable @ApiParam(value = "cui") String cui) {
        return ResponseEntity.ok(solicitudesSvcImpl.empleadoSearch(cui));
    }

    @PutMapping(path = "/updateTurno/{turno}/{nit}")
    @ApiOperation(value = "Actualiza el turno")
    public void updateTurno(@PathVariable("turno") long turno, @PathVariable("nit") String nit) {
        solicitudesSvcImpl.updateTurno(turno, nit);
    }

    @PutMapping(path = "/autorizarRechazarSolicitud/{comentario}/{estado}/{id}")
    @ApiOperation(value = "Actualiza el turno")
    public void updateTurno(@PathVariable("comentario") String comentario, @PathVariable("estado") String estado, @PathVariable("id") long id) {
        solicitudesSvcImpl.autorizarRechazarSolicitud(comentario, estado, id);
    }

    @GetMapping(path = "/catalogoRegistroSolicitud/{nit}")
    @ApiOperation("Busqueda de solicitudes por nit")
    public ResponseEntity<List<solicitudesProjection>> catalogoRegistroSolicitud(
            @PathVariable @ApiParam(value = "nit") String nit) {
        return ResponseEntity.ok(solicitudesSvcImpl.catalogoRegistroSolicitud(nit));
    }

    @GetMapping(path = "/catalogoSearch/{codigoCatalogo}")
    @ApiOperation("Búsqueda de catálogo por código")
    public ResponseEntity<List<CatalogoProjection>> catalogoPorCodigo(
            @PathVariable("codigoCatalogo") Integer codigoCatalogo) {
        return ResponseEntity.ok(solicitudesSvcImpl.catalogo(codigoCatalogo));
    }

}

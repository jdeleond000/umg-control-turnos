/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Empleados;
import com.ia.chatbotia.Repository.EmpleadoRepository;
import com.ia.chatbotia.dto.EmpleadoDto;
import com.ia.chatbotia.projection.RHProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jairo
 */
@Service
public class EmpleadoSvcImpl {
    
    @Autowired
    EmpleadoRepository empleadoRepository;
    
    public Empleados guardarEmpleado(EmpleadoDto datos) {
    Empleados empleados;
    Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());

    String nit = datos.getNit();
    
    Optional<Empleados> empleadoExistente = empleadoRepository.findById(nit);

    if (!empleadoExistente.isPresent()) {
        empleados = new Empleados();
        empleados.setNit(nit); 
        empleados.setNombre(datos.getNombre());
        empleados.setApellido(datos.getApellido());
        empleados.setContrasena(datos.getContrasena());
        empleados.setDpi(datos.getDpi());
        empleados.setCorreoElectronico(datos.getCorreoElectronico());
        empleados.setNumeroTelefono(datos.getNumeroTelefono());
        empleados.setDireccion(datos.getDireccion());
        empleados.setFechaAdicion(fechaAhora);
        empleados.setUsuarioAdicion(datos.getUsuarioAdicion());
        empleados.setCargoId(datos.getCargoId());
        empleados.setEmail(datos.getEmail());
        empleados.setFechaContratacion(datos.getFechaContratacion());
        empleados.setSalario(datos.getSalario());
        empleados.setTurno_id(datos.getTurno_id());
        empleados.setEstado(Long.parseLong("1"));
    } else {
        empleados = empleadoExistente.get();
        empleados.setFechaAdicion(fechaAhora);
        empleados.setUsuarioModificacion(String.valueOf(datos.getNit()));
    }
    
    return empleadoRepository.save(empleados);
}
    
    public List<empleadoProjection> listaEmpleado() {
        return this.empleadoRepository.showEmpleados();
    }
    
    public List<RHProjection> listaEmpleadoRH() {
        return this.empleadoRepository.showEmpleadosbyRH();
    }
}

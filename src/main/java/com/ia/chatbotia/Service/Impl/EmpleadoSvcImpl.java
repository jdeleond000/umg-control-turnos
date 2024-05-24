/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Empleados;
import com.ia.chatbotia.Repository.EmpleadoRepository;
import com.ia.chatbotia.dto.EmpleadoDto;
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
    
    public Empleados guardarEmpleado(EmpleadoDto empleado) {
        Empleados empleados = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (empleados.getNit() == null) {
            empleados = new Empleados();
        } else {
            Optional<Empleados> solicitudesDB = empleadoRepository.findById(empleado);
            empleados = solicitudesDB.get();
        }
        empleados.setDireccion(empleados.getDireccion());
        return empleadoRepository.save(empleados);
    }
    
    public List<empleadoProjection> listaEmpleado() {
        return this.empleadoRepository.showEmpleados();
    }
}

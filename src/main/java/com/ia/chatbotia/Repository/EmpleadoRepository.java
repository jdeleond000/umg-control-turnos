/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Empleados;
import com.ia.chatbotia.projection.RHProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jairo
 */
public interface EmpleadoRepository extends CrudRepository<Empleados, Object> {

    @Query(value = "select * from umg_control_turnos.empleados e where e.nit =? limit 1",
            nativeQuery = true)
    public Empleados findEmpleadoByNit(String nit);

    @Query(value = "select \n"
            + "e.nit as nit, \n"
            + "e.nombre as nombre, \n"
            + "e.apellido as apellido, \n"
            + "e.dpi as dpi, \n"
            + "e.correo_electronico as correo, \n"
            + "e.numero_telefono as tel, \n"
            + "e.direccion as direccion, \n"
            + "e.fecha_contratacion as fechaContratacion, \n"
            + "e.estado as estado \n"
            + "from umg_control_turnos.empleados e ",
            nativeQuery = true)
    public List<empleadoProjection> showEmpleados();

    @Query(value = "select \n"
            + "e.nit as nit, \n"
            + "e.nombre as nombre, \n"
            + "e.apellido as apellido, \n"
            + "e.dpi as dpi, \n"
            + "e.correo_electronico as correo, \n"
            + "e.numero_telefono as tel, \n"
            + "e.direccion as direccion, \n"
            + "e.fecha_contratacion as fechaContratacion, \n"
            + "e.estado as estado,\n"
            + "e.salario as salario\n"
            + "from umg_control_turnos.empleados e ",
            nativeQuery = true)
    public List<RHProjection> showEmpleadosbyRH();

}

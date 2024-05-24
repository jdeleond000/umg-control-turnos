/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Solicitudes;
import com.ia.chatbotia.projection.solicitudesProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jairo
 */
public interface SolicitudesRepository extends CrudRepository<Solicitudes, Object> {

    @Query(value = "select * from umg_control_turnos.solicitudes s where s.id_solicitud =? limit 1",
            nativeQuery = true)
    public Solicitudes findSolicitudesById(Long id);

    @Query(value = "select \n"
            + "s.nit as nit,\n"
            + "s.tipo_solicitud as tipoSolicitud,\n"
            + "s.fecha_inicio as fechaInicio,\n"
            + "s.fecha_inicio as fechaFin,\n"
            + "s.estado as estado,\n"
            + "s.fecha_solicitud as fechaSolicitud,\n"
            + "s.revisor as revisor,\n"
            + "s.fecha_revision as fechaRevision,\n"
            + "s.comentario_revision as comentarioRevision\n"
            + " from umg_control_turnos.solicitudes s ",
            nativeQuery = true)
    public List<solicitudesProjection> showSolicitudes();
}

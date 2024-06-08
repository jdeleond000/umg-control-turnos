/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Solicitudes;
import com.ia.chatbotia.projection.CatalogoProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import com.ia.chatbotia.projection.solicitudesProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    @Query(value = "select e.nombre as nombre,\n"
            + "e.apellido as apellido,\n"
            + "e.nit as nit,\n"
            + "e.direccion as direccion \n"
            + "from umg_control_turnos.empleados e \n"
            + "where e.dpi = :cui",
            nativeQuery = true)
    public List<empleadoProjection> empleadoSearch(@Param("cui") String cui);

    @Modifying
    @Query(value = "update umg_control_turnos.empleados e \n"
            + "set turno_id = :idTurno\n"
            + "where e.nit = :nit", nativeQuery = true)
    void updateTurno(@Param("idTurno") long idTurno, @Param("nit") String nit);

    @Modifying
    @Query(value = "update umg_control_turnos.solicitudes \n"
            + "set comentario_revision = :comentario,\n"
            + "estado = :estado\n"
            + "where id_solicitud = :id", nativeQuery = true)
    void autorizarRechazarSolicitud(@Param("comentario") String comentario, @Param("estado") String estado, @Param("id") long id);

    @Query(value = "select s.id_solicitud as idSolicitud,\n"
            + "s.tipo_solicitud as tipoSolicitud,\n"
            + "s.fecha_inicio as fechaInicio,\n"
            + "s.fecha_fin as fechaFin,\n"
            + "s.estado as estado,\n"
            + "s.comentario_revision as comentario \n"
            + "from umg_control_turnos.solicitudes s\n"
            + "where s.nit = :nit",
            nativeQuery = true)
    public List<solicitudesProjection> catalogoRegistroSolicitud(@Param("nit") String nit);

    @Query(value = "select c.id_catalogo as idCatalogo, \n"
        + "        c.nombre_catalogo as nombreCatalogo,\n"
        + "        c.descripcion_catalogo as descripcionCatalogo\n"
        + "from umg_control_turnos.catalogos c \n"
        + "where c.codigo_catalogo = :codigoCatalogo",
        nativeQuery = true)
public List<CatalogoProjection> catalogo(@Param("codigoCatalogo") Integer codigoCatalogo);

}

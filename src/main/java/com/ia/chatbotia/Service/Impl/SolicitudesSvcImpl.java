/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;
import com.ia.chatbotia.Repository.SolicitudesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ia.chatbotia.Entity.Solicitudes;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import com.ia.chatbotia.dto.SolicitudesDto;
import com.ia.chatbotia.projection.CatalogoProjection;
import com.ia.chatbotia.projection.empleadoProjection;
import com.ia.chatbotia.projection.solicitudesProjection;
import java.util.List;
import javax.transaction.Transactional;
/**
 *
 * @author jairo
 */
@Service
public class SolicitudesSvcImpl {
    
    @Autowired
    SolicitudesRepository solicitudesRepository;
    
    public Solicitudes guardarsolicitudes(SolicitudesDto solicitudes) {
        Solicitudes solicitud = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (solicitud.getNit() == null) {
            solicitud = new Solicitudes();
        } else {
            Optional<Solicitudes> solicitudesDB = solicitudesRepository.findById(solicitud.getIdSolicitud());
            solicitud = solicitudesDB.get();
            solicitud.setRevisor(solicitudes.getRevisor());
        }
        solicitud.setNit(solicitudes.getNit());
        solicitud.setFechaRevision(solicitudes.getFechaRevision());
        solicitud.setComentarioRevision(solicitudes.getComentarioRevision());
        return solicitudesRepository.save(solicitud);
    }
    
    public List<solicitudesProjection> listSolicitud() {
        return this.solicitudesRepository.showSolicitudes();
    }

    public List<empleadoProjection> empleadoSearch(String cui) {
        return this.solicitudesRepository.empleadoSearch(cui);
    }
    
    @Transactional
    public void updateTurno(long turno, String nit) {
        try {
            solicitudesRepository.updateTurno(turno, nit);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional
    public void autorizarRechazarSolicitud(String comentario, String estado, long id) {
        try {
            solicitudesRepository.autorizarRechazarSolicitud(comentario, estado, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<solicitudesProjection> catalogoRegistroSolicitud(String cui) {
        return this.solicitudesRepository.catalogoRegistroSolicitud(cui);
    }
    
    public List<CatalogoProjection> catalogo(Integer codigoCatalogo) {
    return this.solicitudesRepository.catalogo(codigoCatalogo);
}

}

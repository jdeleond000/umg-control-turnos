/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Marcajes;
import com.ia.chatbotia.Repository.MarcajesRepository;
import com.ia.chatbotia.dto.MarcajesDto;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jairo
 */
@Service
public class MarcajeSvcImpl {
    
    @Autowired
    MarcajesRepository marcajesRespository;
    
    public Marcajes guardarMarcajes(MarcajesDto marcajes) {
        Marcajes marcaje = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (marcajes.getNit() == null) {
            marcaje = new Marcajes();
        } else {
            Optional<Marcajes> solicitudesDB = marcajesRespository.findById(marcaje.getIdMarcaje());
            marcaje = solicitudesDB.get();
            //marcaje.setLlegadaTardia(solicitudes.getRevisor());
        }
        marcaje.setNit(marcaje.getNit());
//        marcaje.setFechaRevision(solicitudes.getFechaRevision());
//        marcaje.setComentarioRevision(solicitudes.getComentarioRevision());
        return marcajesRespository.save(marcaje);
    }
}

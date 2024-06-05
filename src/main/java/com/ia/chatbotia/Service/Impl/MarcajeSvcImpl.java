package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Marcajes;
import com.ia.chatbotia.Repository.MarcajesRepository;
import com.ia.chatbotia.dto.MarcajesDto;
import com.ia.chatbotia.projection.catalogoGeneral;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcajeSvcImpl {

    @Autowired
    MarcajesRepository marcajesRepository;

    public Marcajes guardarMarcajes(MarcajesDto datos) {
        Marcajes marcajes;

        if (datos.getIdMarcaje() == null || datos.getIdMarcaje() == 0) {
            marcajes = new Marcajes();
        } else {
            Optional<Marcajes> marcajeExistente = marcajesRepository.findById(datos.getIdMarcaje());
            if (marcajeExistente.isPresent()) {
                marcajes = marcajeExistente.get();
            } else {
                marcajes = new Marcajes(); 
            }
        }

        marcajes.setNit(datos.getNit());
        marcajes.setTipoMarcaje(datos.getTipoMarcaje());
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        
        java.sql.Date fecha;
        if (datos.getFecha() != null) {
            fecha = java.sql.Date.valueOf(LocalDate.parse(datos.getFecha()));
        } else {
            fecha = new java.sql.Date(fechaAhora.getTime());
        }

        marcajes.setHora(fechaAhora); 
        marcajes.setFecha(fecha); 
        marcajes.setLlegadaTardia(datos.getLlegadaTardia());
        return marcajesRepository.save(marcajes);
    }
    
    public List<catalogoGeneral> listCatalogo() {
        return this.marcajesRepository.showCatalogo();
    }
}

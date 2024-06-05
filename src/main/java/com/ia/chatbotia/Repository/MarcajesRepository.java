/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Marcajes;
import com.ia.chatbotia.projection.catalogoGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jairo
 */
public interface MarcajesRepository extends CrudRepository<Marcajes, Object> {

    @Query(value = "select * from umg_control_turnos.marcajes m where m.id_marcaje =? limit 1 ",
            nativeQuery = true)
    public Marcajes findMarcajesById(Long id);

    @Query(value = "select c.id_catalogo  as idCatalogo,\n"
            + "c.codigo_catalogo as codigoCatalogo,\n"
            + "c.nombre_catalogo as nombreCatalogo,\n"
            + "c.descripcion_catalogo as descripcionCatalogo\n"
            + "from umg_control_turnos.catalogos c",
            nativeQuery = true)
    public List<catalogoGeneral> showCatalogo();
}

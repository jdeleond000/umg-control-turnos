/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Marcajes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jairo
 */
public interface MarcajesRepository extends CrudRepository<Marcajes, Object>{
    
    @Query(value = "select * from umg_control_turnos.marcajes m where m.id_marcaje =? limit 1 ",
            nativeQuery = true)
    public Marcajes findMarcajesById(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jairo
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "solicitudes", schema = "umg_control_turnos")
public class Marcajes {
    
    @Id
    @Column(name = "id_marcaje")
    private Long idMarcaje;
    
    @Column(name = "nit", unique = true, nullable = false)
    private String nit;
    
    @Column(name = "tipo_marcaje", unique = true, nullable = false)
    private String tipoMarcaje;
    
    @Column(name = "hora", unique = true, nullable = false)
    private Date hora;
    
    @Column(name = "fecha", unique = true, nullable = false)
    private Date fecha;
    
    @Column(name = "llegada_tardia", unique = true, nullable = false)
    private Boolean llegadaTardia;
}

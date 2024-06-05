/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Entity;

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
public class Solicitudes {
    
    @Id
    @Column(name = "id_solicitud")
    private Long idSolicitud;
    
    @Column(name = "nit", unique = true, nullable = false)
    private String nit;
    
    @Column(name = "tipo_solicitud", unique = true, nullable = false)
    private String tipo_solicitud;
    
    @Column(name = "fecha_inicio", unique = true, nullable = false)
    private String fechaInicio;
    
    @Column(name = "fecha_fin", unique = true, nullable = false)
    private String fechaFin;
    
    @Column(name = "estado", unique = true, nullable = false)
    private String estado;
    
    @Column(name = "fecha_solicitud", unique = true, nullable = false)
    private String fechaSolicitud;
    
    @Column(name = "revisor", unique = true, nullable = false)
    private String revisor;
    
    @Column(name = "fecha_revision", unique = true, nullable = false)
    private String fechaRevision;
    
    @Column(name = "comentario_revision", unique = true, nullable = false)
    private String comentarioRevision;
}

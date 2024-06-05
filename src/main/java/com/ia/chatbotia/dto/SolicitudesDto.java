/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import lombok.Data;

/**
 *
 * @author jairo
 */
@Data
public class SolicitudesDto {
    private Long idSolicitud;
    private String nit;
    private String tipo_solicitud;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private String fechaSolicitud;
    private String revisor;
    private String fechaRevision;
    private String comentarioRevision;
    
}

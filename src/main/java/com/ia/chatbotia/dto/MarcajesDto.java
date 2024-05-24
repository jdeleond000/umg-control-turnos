/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author jairo
 */
@Data
public class MarcajesDto {
    private Long idMarcaje;
    private String nit;
    private String tipoMarcaje;
    private Date hora;
    private Date fecha;
    private Boolean llegadaTardia;
}

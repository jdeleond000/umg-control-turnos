/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import java.util.Date;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 *
 * @author jairo
 */
@Data
@NoArgsConstructor
public class EmpleadoDto {
    private String nit;
    private String nombre;
    private String apellido;
    private String contrasena;
    private Integer dpi;
    private String correoElectronico;
    private long numeroTelefono;
    private String direccion;
    private Date fechaAdicion;
    private String usuarioAdicion;
    private Date fechaModificacion;
    private String usuarioModificacion;
    private Integer cargoId;
    private String email;
    private Date fechaContratacion;
    private Long salario;
    private long estado;
    private Integer turno_id;
    
    
}

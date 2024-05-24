/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Service.Impl.MarcajeSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.MarcajesDto;
import com.ia.chatbotia.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jairo
 */
@RestController
@Slf4j
@RequestMapping("/marcajes")
public class MarcajesController {
    
    @Autowired
    MarcajeSvcImpl marcajeSvcImpl;
    
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody MarcajesDto dato) {
        try {
            return ResponseEntity.ok(marcajeSvcImpl.guardarMarcajes(dato));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ahorro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
}

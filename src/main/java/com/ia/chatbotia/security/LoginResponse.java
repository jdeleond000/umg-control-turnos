/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.security;

import lombok.Data;

/**
 *
 * @author Oscar
 */
@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String nit;
    private String rol;

    public LoginResponse(String accessToken, String nit, String rol) {
        this.accessToken = accessToken;
        this.nit = nit;
        this.rol = rol;
    }
}

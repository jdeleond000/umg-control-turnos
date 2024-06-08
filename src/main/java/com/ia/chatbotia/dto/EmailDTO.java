/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author jairo
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailDTO {
    private String[] toUser;

    private String subject;

    private String message;
}

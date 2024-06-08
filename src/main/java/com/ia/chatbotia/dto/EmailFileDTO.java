/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jairo
 */
@Data
public class EmailFileDTO {
    private String[] toUser;

    private String subject;

    private String message;

    MultipartFile file;
}

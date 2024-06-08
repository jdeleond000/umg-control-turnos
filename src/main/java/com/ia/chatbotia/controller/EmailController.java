/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.ia.chatbotia.dto.EmailDTO;
import com.ia.chatbotia.dto.EmailFileDTO;
import com.ia.chatbotia.services.IEmailService;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jairo
 */

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDTO emailDTO) {

        System.out.println("Llega mensaje: " + emailDTO.toString());

        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sendMailFile")
    public ResponseEntity<?> sendMailFile(@ModelAttribute EmailFileDTO emailFileDTO) {

        System.out.println("Llega mensaje: " + emailFileDTO.toString());

        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/main/files" + fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailFile(emailFileDTO.getToUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Email sent successfully");
            response.put("file", fileName);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            throw new RuntimeException("Error sending email " + e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.services;

import java.io.File;

/**
 *
 * @author jairo
 */
public interface IEmailService {
    void sendEmail(String[] toUser, String subject, String message);
    void sendEmailFile(String[] toUser, String subject, String message, File file);

}

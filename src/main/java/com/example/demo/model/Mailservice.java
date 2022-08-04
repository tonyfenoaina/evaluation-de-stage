/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author User
 */
public class Mailservice {
     @Autowired
    private JavaMailSender emailSender;
    
    public void sendSimpleMessage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
//        System.out.println(" send to " + to);

        message.setFrom("tfenoaina@gmail.com");
        message.setTo(to.trim());
        message.setSubject("Validation inscription");
        message.setText("Votre compte est activé");

//        System.out.println(" send to " + to);
        emailSender.send(message);
        System.out.println("Mail send to " + to);

    }
}

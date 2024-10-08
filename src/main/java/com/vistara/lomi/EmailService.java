package com.vistara.lomi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmail(MyAppUser myAppUser) throws MessagingException {
        // Create email message
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("prakharsen2204@gmail.com");
        helper.setTo(myAppUser.getEmail());
        helper.setSubject("Welcome Email");

        Context context = new Context();
        context.setVariable("username", myAppUser.getUsername());
        String htmlContent = templateEngine.process("emailTemplate", context);

        helper.setText(htmlContent, true); // Set to true to send HTML

        // Send email
        mailSender.send(message);
    }
}

package com.vistara.lomi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.mail.MessagingException;

@Controller
public class EmailSendController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private MyAppUserRepository repo;

    @GetMapping("/send-email")
    public String sendEmail() {
        // Fetch employee from database (with id 1 for demonstration)
        Optional<MyAppUser> myAppUser = repo.findById(1L);

        if (myAppUser.isPresent()) {
            try {
                emailService.sendEmail(myAppUser.get());
                return "emaillook";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Failed to send email: " + e.getMessage();
            }
        } else {
            return "User not found!";
        }
    }
}

package be.sn.web;

import be.sn.entities.Skill;
import be.sn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSendController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody SimpleMailMessage message) {
        System.out.println(message.getTo()[0]);
        System.out.println(message.getSubject());
        System.out.println(message.getText());

        emailService.sendSimpleMessage(message.getTo()[0], message.getSubject(), message.getText());
    }
}

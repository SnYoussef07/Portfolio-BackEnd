package be.sn.web;

import be.sn.entities.Skill;
import be.sn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSendController {
    @Autowired
    private EmailService emailService;


    @PostMapping("/sendEmail")
    public void sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {

    }
}

package be.sn;

import be.sn.dao.ProjectRepository;
import be.sn.dao.SkillRepository;
import be.sn.entities.AppRole;
import be.sn.entities.AppUser;
import be.sn.entities.Project;
import be.sn.entities.Skill;
import be.sn.service.AccountService;
import be.sn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PortfolioSnoussApplication implements CommandLineRunner {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioSnoussApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
//        accountService.saveUser(new AppUser(null, "admin", "admin", null));
//        accountService.saveRole(new AppRole(null, "ADMIN"));
//        accountService.addRoleToUse("admin", "ADMIN");
    }

}

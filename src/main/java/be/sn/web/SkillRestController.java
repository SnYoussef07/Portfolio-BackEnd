package be.sn.web;

import be.sn.dao.SkillRepository;
import be.sn.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillRestController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/skills")
    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }
}

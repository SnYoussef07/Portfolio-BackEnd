package be.sn.web;

import be.sn.dao.SkillRepository;
import be.sn.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class SkillRestController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/skills")
    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }

    @PostMapping("uploadLogoSkill/{id}")
    public void addSkill(MultipartFile file, @PathVariable Long id) throws Exception {
        Skill skill = skillRepository.findById(id).get();
        skill.setLogo(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home") + "/portfoliosn/skills/" + skill.getLogo()), file.getBytes());
        skillRepository.save(skill);
    }

    @PostMapping("skills")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @GetMapping(path = "/logoSkill/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getLogo(@PathVariable("id") Long id) throws Exception {
        Skill skill = skillRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/portfoliosn/skills" + skill.getLogo()));
    }

}

package be.sn.web;

import be.sn.dao.ProjectRepository;
import be.sn.entities.Project;
import be.sn.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ProjectRestController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @PostMapping("projects")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PostMapping("uploadImageProject/{id}")
    public void uploadImageProject(MultipartFile file, @PathVariable Long id) throws Exception {
        Project project = projectRepository.findById(id).get();
        project.setImage(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home") + "/portfoliosn/projects/" + project.getImage()), file.getBytes());
        projectRepository.save(project);
    }

    @GetMapping(path = "/imageProject/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("id") Long id) throws Exception {
        Project project = projectRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/portfoliosn/projects/" + project.getImage()));
    }
}

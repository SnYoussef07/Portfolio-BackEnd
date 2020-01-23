package be.sn.web;

import be.sn.dao.ProjectRepository;
import be.sn.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

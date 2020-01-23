package be.sn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String link;
    private String image;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Skill> skills = new ArrayList<>();
}

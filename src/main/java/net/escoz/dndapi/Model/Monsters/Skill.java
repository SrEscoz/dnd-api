package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "monster_skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "skills")
    private Set<Monster> monsters;
}

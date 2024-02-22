package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "monster_skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Monster> monsters;
}

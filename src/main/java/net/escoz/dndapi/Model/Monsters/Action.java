package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "monster_actions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {

    @Id
    private String name;

    @Column(length = 3000)
    private String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "actions")
    private Set<Monster> monsters;
}

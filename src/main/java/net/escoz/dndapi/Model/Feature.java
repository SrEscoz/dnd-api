package net.escoz.dndapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.escoz.dndapi.Model.Monsters.Monster;

import java.util.Set;

@Entity
@Table(name = "monster_features")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    @Id
    private String name;

    @Column(length = 3000)
    private String description;

    @ManyToMany(mappedBy = "features")
    private Set<Monster> monsters;
}

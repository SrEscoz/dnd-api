package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "monster_types")
@Data
@AllArgsConstructor
public class Type {

    @Id
    private String name;

    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "type")
    private Set<Monster> monsters;
}

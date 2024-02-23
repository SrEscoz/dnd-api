package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "monster_senses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sense {

    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "senses")
    private Set<Monster> monsters;
}


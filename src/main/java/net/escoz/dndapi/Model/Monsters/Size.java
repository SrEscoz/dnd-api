package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monster_sizes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    @Id
    private String name;

    private String space;

    @ToString.Exclude
    @OneToMany(mappedBy = "size", cascade = CascadeType.PERSIST)
    private Set<Monster> monsters;
}

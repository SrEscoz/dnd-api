package net.escoz.dndapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.escoz.dndapi.Model.Monsters.Monster;

import java.util.Set;

@Entity
@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "languages")
    private Set<Monster> monsters;
}

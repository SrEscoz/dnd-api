package net.escoz.dndapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @ManyToMany(mappedBy = "languages")
    private Set<Monster> monsters;
}

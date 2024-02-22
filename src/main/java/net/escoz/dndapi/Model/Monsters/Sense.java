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
@Table(name = "monster_senses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sense {

    @Id
    private String name;

    @ManyToMany(mappedBy = "senses")
    private Set<Monster> monsters;
}


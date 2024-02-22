package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "size")
    private Set<Monster> monsters;
}

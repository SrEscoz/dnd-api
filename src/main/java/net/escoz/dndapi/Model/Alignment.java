package net.escoz.dndapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import net.escoz.dndapi.Model.Monsters.Monster;

import java.util.Set;

@Entity
@Table(name = "alignments")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Alignment {

    @Id
    @NonNull
    private String name;

    @OneToMany(mappedBy = "alignment")
    private Set<Monster> monsters;
}

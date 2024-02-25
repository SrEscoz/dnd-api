package net.escoz.dndapi.Model;

import jakarta.persistence.*;
import lombok.*;
import net.escoz.dndapi.Model.Monsters.Monster;

import java.util.Set;

@Entity
@Table(name = "monster_features")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(length = 3000)
    private String description;

    @ManyToMany(mappedBy = "features")
    private Set<Monster> monsters;
}

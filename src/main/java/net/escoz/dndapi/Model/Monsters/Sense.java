package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "monster_senses")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Sense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "senses")
    private Set<Monster> monsters;
}


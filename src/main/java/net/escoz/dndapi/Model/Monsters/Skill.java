package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "monster_skills")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "skills")
    private Set<Monster> monsters;
}

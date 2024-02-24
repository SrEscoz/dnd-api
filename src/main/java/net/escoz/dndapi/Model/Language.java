package net.escoz.dndapi.Model;

import jakarta.persistence.*;
import lombok.*;
import net.escoz.dndapi.Model.Monsters.Monster;

import java.util.Set;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "languages")
    private Set<Monster> monsters;
}

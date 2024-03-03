package net.escoz.dndapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
    @NonNull
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "languages")
    private Set<Monster> monsters;
}

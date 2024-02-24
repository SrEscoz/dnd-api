package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monster_sizes")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Size {

    @Id
    @NonNull
    private String name;

    private String space;

    @ToString.Exclude
    @OneToMany(mappedBy = "size")
    private Set<Monster> monsters;
}

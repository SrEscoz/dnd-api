package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "monster_types")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Type {

    @Id
    @NonNull
    private String name;

    @Column(length = 3000)
    private String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "type")
    private Set<Monster> monsters;
}

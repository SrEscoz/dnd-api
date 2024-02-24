package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

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

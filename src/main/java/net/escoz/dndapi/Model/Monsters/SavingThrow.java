package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "savingThrows")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class SavingThrow {

    @Id
    @NonNull
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "savingThrows")
    private Set<Monster> savingThrows;
}

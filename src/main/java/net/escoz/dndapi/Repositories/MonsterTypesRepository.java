package net.escoz.dndapi.Repositories;

import net.escoz.dndapi.Model.Monsters.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterTypesRepository extends JpaRepository<Type, String> {
}

package net.escoz.dndapi.Repositories;

import net.escoz.dndapi.Model.Monsters.Sense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterSensesRepository extends JpaRepository<Sense, String> {
}

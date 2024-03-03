package net.escoz.dndapi.Repositories;

import net.escoz.dndapi.Model.Monsters.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, String> {

    Monster findByNameIgnoreCase(String name);
}

package net.escoz.dndapi.Repositories;

import net.escoz.dndapi.Model.Monsters.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterSizeRepository extends JpaRepository<Size, String> {
}

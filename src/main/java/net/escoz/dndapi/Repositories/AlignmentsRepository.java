package net.escoz.dndapi.Repositories;

import net.escoz.dndapi.Model.Alignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlignmentsRepository extends JpaRepository<Alignment, String> {
}

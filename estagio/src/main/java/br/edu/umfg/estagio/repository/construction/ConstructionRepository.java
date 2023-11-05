package br.edu.umfg.estagio.repository.construction;

import br.edu.umfg.estagio.entity.construction.Construction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionRepository extends JpaRepository<Construction, Long> {
}

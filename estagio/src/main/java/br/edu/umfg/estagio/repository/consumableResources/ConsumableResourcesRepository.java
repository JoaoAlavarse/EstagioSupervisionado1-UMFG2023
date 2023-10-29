package br.edu.umfg.estagio.repository.consumableResources;

import br.edu.umfg.estagio.entity.consumableResources.ConsumableResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumableResourcesRepository extends JpaRepository<ConsumableResource, Long> {
}

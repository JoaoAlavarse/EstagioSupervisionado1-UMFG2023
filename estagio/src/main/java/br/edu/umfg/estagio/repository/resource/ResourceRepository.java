package br.edu.umfg.estagio.repository.resource;

import br.edu.umfg.estagio.entity.resource.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

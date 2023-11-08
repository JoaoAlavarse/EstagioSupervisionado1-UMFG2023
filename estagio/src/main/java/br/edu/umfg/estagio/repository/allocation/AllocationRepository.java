package br.edu.umfg.estagio.repository.allocation;

import br.edu.umfg.estagio.entity.allocation.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}

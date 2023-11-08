package br.edu.umfg.estagio.entity.allocation;

import java.sql.Date;

public record AllocationRequestDTO(Long id_construction, Long id_resource, Date allocation_date, Date devolution_date) {
}

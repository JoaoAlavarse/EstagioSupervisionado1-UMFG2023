package br.edu.umfg.estagio.entity.allocation;

import java.sql.Date;

public record AllocationResponseDTO(Long id_allocation, Long id_construction, Long id_resource, Date allocation_date, Date devolution_date) {
    public AllocationResponseDTO(Allocation allocation){
        this(allocation.getId_allocation(), allocation.getId_construction(), allocation.getId_resource(), allocation.getAllocation_date(), allocation.getDevolution_date());
    }
}

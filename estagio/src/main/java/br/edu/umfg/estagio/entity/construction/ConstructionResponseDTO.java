package br.edu.umfg.estagio.entity.construction;

import br.edu.umfg.estagio.enums.ConstructionStatus;

import java.sql.Date;

public record ConstructionResponseDTO(Long id_construction, String company, String cnpj, Date delivery_date, Date start_date, String address, ConstructionStatus status) {
    public ConstructionResponseDTO(Construction construction){
        this(construction.getId_construction(), construction.getCompany(), construction.getCnpj(), construction.getDelivery_date(), construction.getStart_date(), construction.getAddress(), construction.getStatus());
    }
}

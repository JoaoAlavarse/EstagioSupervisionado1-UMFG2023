package br.edu.umfg.estagio.entity.construction;

import br.edu.umfg.estagio.enums.ConstructionStatus;

import java.sql.Date;

public record ConstructionRequestDTO(String company, String cnpj, Date delivery_date, Date start_date, String address, ConstructionStatus status) {
}

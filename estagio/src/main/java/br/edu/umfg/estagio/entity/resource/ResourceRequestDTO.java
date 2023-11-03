package br.edu.umfg.estagio.entity.resource;

import br.edu.umfg.estagio.enums.ResourceType;

import java.sql.Date;

public record ResourceRequestDTO(String name, String brand, Long quantity, ResourceType type, String observation, Date purchase) {
}

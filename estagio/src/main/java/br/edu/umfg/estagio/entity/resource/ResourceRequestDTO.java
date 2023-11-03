package br.edu.umfg.estagio.entity.resource;

import java.sql.Date;

public record ResourceRequestDTO(String name, String brand, Long quantity, Integer type, String observation, Date purchase) {
}

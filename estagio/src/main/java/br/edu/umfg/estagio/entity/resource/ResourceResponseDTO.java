package br.edu.umfg.estagio.entity.resource;

import java.sql.Date;

public record ResourceResponseDTO(Long id_resource, String name, String brand, Long quantity, Integer type, String observation, Date purchase) {
    public  ResourceResponseDTO(Resource resource){
        this(resource.getId_resource(), resource.getName(), resource.getBrand(), resource.getQuantity(), resource.getType(), resource.getObservation(), resource.getPurchase());
    }

}

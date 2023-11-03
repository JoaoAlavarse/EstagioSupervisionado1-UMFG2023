package br.edu.umfg.estagio.entity.resource;


import java.util.Date;

public record ResourceResponseDTO(Long id_resource, String name, String brand, Long quantity, Integer resourceType, String observation, Date purchaseDate) {
    public ResourceResponseDTO(Resource resource){
        this(resource.getId_resource(), resource.getName(), resource.getBrand(), resource.getQuantity(), resource.getResourceType(), resource.getObservation(), resource.getPurchaseDate());
    }
}

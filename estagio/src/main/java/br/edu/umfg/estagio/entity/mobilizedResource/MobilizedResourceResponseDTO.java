package br.edu.umfg.estagio.entity.mobilizedResource;

public record MobilizedResourceResponseDTO(Long id, String name, String brand, String renavam, Long quantity) {
    public MobilizedResourceResponseDTO(MobilizedResource mobilizedResource) {
        this(mobilizedResource.getId(), mobilizedResource.getName(), mobilizedResource.getBrand(), mobilizedResource.getRenavam(), mobilizedResource.getQuantity());
    }
}

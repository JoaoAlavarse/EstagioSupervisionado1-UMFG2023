package br.edu.umfg.estagio.entity.consumableResources;


public record ConsumableResourceResponseDTO(Long id, String name, String brand, Long quantity) {

  public ConsumableResourceResponseDTO(ConsumableResource consumableResource){
      this(consumableResource.getId(), consumableResource.getName(), consumableResource.getBrand(), consumableResource.getQuantity());
  }
}

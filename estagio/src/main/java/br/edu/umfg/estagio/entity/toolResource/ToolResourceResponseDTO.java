package br.edu.umfg.estagio.entity.toolResource;



public record ToolResourceResponseDTO(Long id, String name, String brand, Long quantity) {
    public ToolResourceResponseDTO(ToolResource tollResurce){
        this(tollResurce.getId(), tollResurce.getName(), tollResurce.getBrand(), tollResurce.getQuantity());
    }
}

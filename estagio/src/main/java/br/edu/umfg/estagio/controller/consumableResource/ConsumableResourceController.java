package br.edu.umfg.estagio.controller.consumableResource;


import br.edu.umfg.estagio.entity.consumableResources.ConsumableResourceRequestDTO;
import br.edu.umfg.estagio.entity.consumableResources.ConsumableResourceResponseDTO;
import br.edu.umfg.estagio.service.consumableResource.ConsumableResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("consumableResource")
public class ConsumableResourceController {
    @Autowired
    private ConsumableResourceService consumableResourceService;

    @GetMapping
    public ResponseEntity<List<ConsumableResourceResponseDTO>> getAll(){
        List<ConsumableResourceResponseDTO> consumableResourceList = consumableResourceService.getAll();
        return ResponseEntity.ok(consumableResourceList);
    }

    @PostMapping
    public ResponseEntity<Objects> saveConsumableResource(@RequestBody ConsumableResourceRequestDTO data){
        consumableResourceService.saveConsumableResource(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Objects> updateConsumableResource(@PathVariable Long id, @RequestBody ConsumableResourceRequestDTO data){
        consumableResourceService.updateConsumableResource(id, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Objects> deleteConsumableResource(@PathVariable Long id){
        consumableResourceService.deleteConsumableResource(id);
        return  ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ConsumableResourceResponseDTO>> getById(@PathVariable Long id){
        Optional<ConsumableResourceResponseDTO> consumableResource = consumableResourceService.getById(id);
        return ResponseEntity.ok(consumableResource);
    }
}

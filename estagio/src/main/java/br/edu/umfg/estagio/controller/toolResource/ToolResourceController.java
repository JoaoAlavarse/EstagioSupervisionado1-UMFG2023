package br.edu.umfg.estagio.controller.toolResource;

import br.edu.umfg.estagio.entity.toolResource.ToolResourceRequestDTO;
import br.edu.umfg.estagio.entity.toolResource.ToolResourceResponseDTO;
import br.edu.umfg.estagio.service.toolResource.ToolResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("toolResource")
public class ToolResourceController {
    @Autowired
    private ToolResourceService toolResourceService;

    @GetMapping
    public ResponseEntity<List<ToolResourceResponseDTO>> getAll(){
        List<ToolResourceResponseDTO> consumableResourceList = toolResourceService.getAll();
        return ResponseEntity.ok(consumableResourceList);
    }

    @PostMapping
    public ResponseEntity<Objects> saveConsumableResource(@RequestBody ToolResourceRequestDTO data){
        toolResourceService.saveToolResource(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Objects> updateConsumableResource(@PathVariable Long id, @RequestBody ToolResourceRequestDTO data){
        toolResourceService.updateToolResource(id, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Objects> deleteConsumableResource(@PathVariable Long id){
        toolResourceService.deleteToolResource(id);
        return  ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ToolResourceResponseDTO>> getById(@PathVariable Long id){
        Optional<ToolResourceResponseDTO> consumableResource = toolResourceService.getById(id);
        return ResponseEntity.ok(consumableResource);
    }
}

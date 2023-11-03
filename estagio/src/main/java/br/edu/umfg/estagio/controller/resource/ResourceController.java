package br.edu.umfg.estagio.controller.resource;

import br.edu.umfg.estagio.entity.resource.ResourceRequestDTO;
import br.edu.umfg.estagio.entity.resource.ResourceResponseDTO;
import br.edu.umfg.estagio.service.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<ResourceResponseDTO>> getAll(){
        List<ResourceResponseDTO> resourceList = resourceService.getAll();
        return ResponseEntity.ok(resourceList);
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody ResourceRequestDTO data){
        resourceService.saveResource(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id_resource}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id_resource, @RequestBody ResourceRequestDTO data){
        resourceService.updateResource(id_resource, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_resource}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id_resource){
        resourceService.deleteResource(id_resource);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_resource}")
    public ResponseEntity<Optional<ResourceResponseDTO>> getById(@PathVariable Long id_resource){
        Optional<ResourceResponseDTO> resource = resourceService.getById(id_resource);
        return ResponseEntity.ok(resource);
    }
}

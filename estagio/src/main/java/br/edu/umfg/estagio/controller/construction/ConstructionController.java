package br.edu.umfg.estagio.controller.construction;

import br.edu.umfg.estagio.entity.construction.ConstructionRequestDTO;
import br.edu.umfg.estagio.entity.construction.ConstructionResponseDTO;
import br.edu.umfg.estagio.service.construction.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("construction")
public class ConstructionController {
    @Autowired
    private ConstructionService service;

    @GetMapping
    public ResponseEntity<List<ConstructionResponseDTO>> getAll(){
        List<ConstructionResponseDTO> constructionResponseDTOList = service.getAll();
        return ResponseEntity.ok(constructionResponseDTOList);
    }

    @PostMapping
    public ResponseEntity<Object> saveConstruction(@RequestBody ConstructionRequestDTO data){
        service.saveConstruction(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id_construction}")
    public ResponseEntity<Object> updateConstruction(@PathVariable Long id_construction, @RequestBody ConstructionRequestDTO data){
        service.updateConstruction(id_construction, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_construction}")
    public ResponseEntity<Object> deleteConstruction(@PathVariable Long id_construction){
        service.deleteConstruction(id_construction);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_construction}")
    public ResponseEntity<Optional<ConstructionResponseDTO>> getById(@PathVariable Long id_construction){
        Optional<ConstructionResponseDTO> construction = service.getById(id_construction);
        return ResponseEntity.ok(construction);
    }
}

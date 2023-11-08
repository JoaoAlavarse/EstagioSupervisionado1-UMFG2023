package br.edu.umfg.estagio.controller.allocation;

import br.edu.umfg.estagio.entity.allocation.AllocationRequestDTO;
import br.edu.umfg.estagio.entity.allocation.AllocationResponseDTO;
import br.edu.umfg.estagio.service.allocation.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("allocation")
public class AllocationController {
    @Autowired
    private AllocationService service;

    @GetMapping
    public ResponseEntity<List<AllocationResponseDTO>> getAll(){
        List<AllocationResponseDTO> allocationList = service.getAll();
        return ResponseEntity.ok(allocationList);
    }

    @PostMapping
    public ResponseEntity<Object> saveAllocation(@RequestBody AllocationRequestDTO data){
        service.save(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id_allocation}")
    public ResponseEntity<Object> updateAllocation(@PathVariable Long id_allocation, @RequestBody AllocationRequestDTO data){
        service.update(id_allocation, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_allocation}")
    public ResponseEntity<Object> deleteAllocation(@PathVariable Long id_allocation){
        service.delete(id_allocation);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_allocation}")
    public ResponseEntity<Optional<AllocationResponseDTO>> getById(@PathVariable Long id_allocation){
        Optional<AllocationResponseDTO> allocation = service.getById(id_allocation);
        return ResponseEntity.ok(allocation);
    }
}

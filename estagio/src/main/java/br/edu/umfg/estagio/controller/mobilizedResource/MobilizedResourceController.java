package br.edu.umfg.estagio.controller.mobilizedResource;

import br.edu.umfg.estagio.entity.mobilizedResource.MobilizedResourceResponseDTO;
import br.edu.umfg.estagio.entity.mobilizedResource.MobilizedResourceRequestDTO;
import br.edu.umfg.estagio.service.mobilizedResource.MobilizedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("mobilizedResourceService")
public class MobilizedResourceController {
    @Autowired
    private MobilizedResourceService mobilizedResourceService;

    @GetMapping
    public ResponseEntity<List<MobilizedResourceResponseDTO>> getAll() {
        List<MobilizedResourceResponseDTO> mobilizedResourceList = mobilizedResourceService.getAll();
        return ResponseEntity.ok(mobilizedResourceList);
    }

    @PostMapping
    public ResponseEntity<Objects> saveMobilizedResource(@RequestBody MobilizedResourceRequestDTO data) {
        mobilizedResourceService.saveMobilizedResource(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Objects> updateMobilizedResource(@PathVariable Long id, @RequestBody MobilizedResourceRequestDTO data) {
        mobilizedResourceService.updateMobilizedResource(id, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Objects> deleteMobilizedResource(@PathVariable Long id) {
        mobilizedResourceService.deleteMobilizedResource(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<MobilizedResourceResponseDTO>> getById(@PathVariable Long id) {
        Optional<MobilizedResourceResponseDTO> mobilizedResource = mobilizedResourceService.getById(id);
        return ResponseEntity.ok(mobilizedResource);
    }
}
package br.edu.umfg.estagio.controller.constructionEmployee;

import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployeeRequestDTO;
import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployeeResponseDTO;
import br.edu.umfg.estagio.service.constructionEmployee.ConstructionEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("constructionEmployee")
public class ConstructionEmployeeController {
    @Autowired
    private ConstructionEmployeeService service;

    @GetMapping
    public ResponseEntity<List<ConstructionEmployeeResponseDTO>> getAll(){
        List<ConstructionEmployeeResponseDTO> constructionEmployeeResponseDTOList = service.getAll();
        return ResponseEntity.ok(constructionEmployeeResponseDTOList);
    }

    @PutMapping(value = "/{id_construction_employee}")
    public ResponseEntity<Object> updateConstructionEmployee(@PathVariable Long id_construction_employee, @RequestBody ConstructionEmployeeRequestDTO data){
        service.updateConstructionEmployee(id_construction_employee, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_construction_employee}")
    public ResponseEntity<Object> deleteConstructionEmployee(@PathVariable Long id_construction_employee){
        service.deleteConstructionEmployee(id_construction_employee);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_construction_employee}")
    public ResponseEntity<Optional<ConstructionEmployeeResponseDTO>> getById(@PathVariable Long id_construction_employee){
        Optional<ConstructionEmployeeResponseDTO> constructionEmployeeResponseDTO = service.getById(id_construction_employee);
        return ResponseEntity.ok(constructionEmployeeResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Object> saveConstructionEmployee(@RequestBody ConstructionEmployeeRequestDTO data){
        service.saveConstructionEmployee(data);
        return ResponseEntity.ok(null);
    }
}

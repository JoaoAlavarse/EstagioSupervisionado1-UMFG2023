package br.edu.umfg.estagio.controller.employee;

import br.edu.umfg.estagio.entity.employee.EmployeeRequestDTO;
import br.edu.umfg.estagio.entity.employee.EmployeeResponseDTO;
import br.edu.umfg.estagio.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        List<EmployeeResponseDTO> employeeList = employeeService.getAll();
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeRequestDTO data){
        employeeService.saveEmployee(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO data){
        employeeService.updateEmployee(id, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(null);
    }
}

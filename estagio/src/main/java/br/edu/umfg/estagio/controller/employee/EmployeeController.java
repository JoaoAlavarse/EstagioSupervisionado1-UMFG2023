package br.edu.umfg.estagio.controller.employee;

import br.edu.umfg.estagio.entity.employee.Employee;
import br.edu.umfg.estagio.entity.employee.EmployeeRequestDTO;
import br.edu.umfg.estagio.entity.employee.EmployeeResponseDTO;
import br.edu.umfg.estagio.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<EmployeeResponseDTO> saveEmployee(@Valid @RequestBody EmployeeRequestDTO data){
        Employee employee = employeeService.saveEmployee(data);
        EmployeeResponseDTO response = new EmployeeResponseDTO(employee);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id_employee}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id_employee, @RequestBody EmployeeRequestDTO data){
        employeeService.updateEmployee(id_employee, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_employee}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id_employee){
        employeeService.deleteEmployee(id_employee);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_employee}")
    public ResponseEntity<Optional<EmployeeResponseDTO>> getById(@PathVariable Long id_employee){
        Optional<EmployeeResponseDTO> employee = employeeService.getById(id_employee);
        return ResponseEntity.ok(employee);
    }
}

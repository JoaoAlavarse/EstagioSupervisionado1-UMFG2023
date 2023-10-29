package br.edu.umfg.estagio.controller;

import br.edu.umfg.estagio.entity.employee.Employee;
import br.edu.umfg.estagio.entity.employee.EmployeeRequestDTO;
import br.edu.umfg.estagio.entity.employee.EmployeeResponseDTO;
import br.edu.umfg.estagio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<EmployeeResponseDTO> getAll(){
        List<EmployeeResponseDTO> employeeList = repository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeRequestDTO data){
        Employee employee = new Employee(data);
        repository.save(employee);
    }

    @PutMapping(value = "/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO data){
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.updateFromDTO(data);
            repository.save(employee);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable Long id){
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            repository.delete(employee);
        }
    }
}

package br.edu.umfg.estagio.service.employee;

import br.edu.umfg.estagio.entity.employee.Employee;
import br.edu.umfg.estagio.entity.employee.EmployeeRequestDTO;
import br.edu.umfg.estagio.entity.employee.EmployeeResponseDTO;
import br.edu.umfg.estagio.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void updateEmployee(Long id_employee, EmployeeRequestDTO data){
        Optional<Employee> optionalEmployee = repository.findById(id_employee);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.updateFromDTO(data);
            repository.save(employee);
        }
    }

    public List<EmployeeResponseDTO> getAll(){
        List<EmployeeResponseDTO> employeeList = repository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }

    public void saveEmployee(@RequestBody EmployeeRequestDTO data){
        Employee employee = new Employee(data);
        repository.save(employee);
    }

    public void deleteEmployee(@PathVariable Long id_employee){
        Optional<Employee> optionalEmployee = repository.findById(id_employee);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            repository.delete(employee);
        }
    }

    public Optional<EmployeeResponseDTO> getById(Long id_employee){
        Optional<EmployeeResponseDTO> employee = repository.findById(id_employee).map(EmployeeResponseDTO::new);
        return employee;
    }
}

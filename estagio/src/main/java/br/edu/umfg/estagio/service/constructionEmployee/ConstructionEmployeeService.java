package br.edu.umfg.estagio.service.constructionEmployee;


import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployee;
import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployeeRequestDTO;
import br.edu.umfg.estagio.entity.constructionEmployee.ConstructionEmployeeResponseDTO;
import br.edu.umfg.estagio.repository.constructionEmployee.ConstructionEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructionEmployeeService {
    @Autowired
    private ConstructionEmployeeRepository repository;

    public void updateConstructionEmployee(Long id_construction_employee, ConstructionEmployeeRequestDTO data){
        Optional<ConstructionEmployee> optionalConstructionEmployee = repository.findById(id_construction_employee);
        if (optionalConstructionEmployee.isPresent()){
            ConstructionEmployee constructionEmployee = optionalConstructionEmployee.get();
            constructionEmployee.updateFromDTO(data);
            repository.save(constructionEmployee);
        }
    }

    public List<ConstructionEmployeeResponseDTO> getAll(){
        List<ConstructionEmployeeResponseDTO> constructionEmployeeList = repository.findAll().stream().map(ConstructionEmployeeResponseDTO::new).toList();
        return constructionEmployeeList;
    }

    public void saveConstructionEmployee(@RequestBody ConstructionEmployeeRequestDTO data){
        ConstructionEmployee constructionEmployee = new ConstructionEmployee(data);
        repository.save(constructionEmployee);
    }

    public void deleteConstructionEmployee(@PathVariable Long id_construction_employee){
        Optional<ConstructionEmployee> optionalConstructionEmployee = repository.findById(id_construction_employee);
        if (optionalConstructionEmployee.isPresent()){
            ConstructionEmployee constructionEmployee = optionalConstructionEmployee.get();
            repository.delete(constructionEmployee);
        }
    }

    public Optional<ConstructionEmployeeResponseDTO> getById(Long id_construction_employee){
        Optional<ConstructionEmployeeResponseDTO> constructionEmployee = repository.findById(id_construction_employee).map(ConstructionEmployeeResponseDTO::new);
        return constructionEmployee;
    }
}

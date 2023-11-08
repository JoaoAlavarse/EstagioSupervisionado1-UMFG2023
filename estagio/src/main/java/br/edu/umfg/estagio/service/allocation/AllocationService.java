package br.edu.umfg.estagio.service.allocation;

import br.edu.umfg.estagio.entity.allocation.Allocation;
import br.edu.umfg.estagio.entity.allocation.AllocationRequestDTO;
import br.edu.umfg.estagio.entity.allocation.AllocationResponseDTO;
import br.edu.umfg.estagio.repository.allocation.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {
    @Autowired
    private AllocationRepository repository;

    public void update(Long id_allocation, AllocationRequestDTO data){
        Optional<Allocation> optionalAllocation = repository.findById(id_allocation);
        if (optionalAllocation.isPresent()){
            Allocation allocation = optionalAllocation.get();
            allocation.updateFromDTO(data);
            repository.save(allocation);
        }
    }

    public List<AllocationResponseDTO> getAll(){
        List<AllocationResponseDTO> list = repository.findAll().stream().map(AllocationResponseDTO::new).toList();
        return list;
    }

    public void save(@RequestBody AllocationRequestDTO data){
        Allocation allocation = new Allocation(data);
        repository.save(allocation);
    }

    public void delete(@PathVariable Long id_allocation){
        Optional<Allocation> optionalAllocation = repository.findById(id_allocation);
        if (optionalAllocation.isPresent()){
            Allocation allocation = optionalAllocation.get();
            repository.delete(allocation);
        }
    }

    public Optional<AllocationResponseDTO> getById(Long id_allocation){
        Optional<AllocationResponseDTO> optionalAllocation = repository.findById(id_allocation).map(AllocationResponseDTO::new);
        return optionalAllocation;
    }
}

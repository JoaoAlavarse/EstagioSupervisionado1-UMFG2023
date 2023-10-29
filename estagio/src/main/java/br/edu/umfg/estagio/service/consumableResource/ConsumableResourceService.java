package br.edu.umfg.estagio.service.consumableResource;

import br.edu.umfg.estagio.entity.consumableResources.ConsumableResource;
import br.edu.umfg.estagio.entity.consumableResources.ConsumableResourceRequestDTO;
import br.edu.umfg.estagio.entity.consumableResources.ConsumableResourceResponseDTO;
import br.edu.umfg.estagio.repository.consumableResources.ConsumableResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumableResourceService {

    @Autowired
    private ConsumableResourcesRepository repository;
    public void updateConsumableResource(Long id, ConsumableResourceRequestDTO data){
        Optional<ConsumableResource> optionalConsumableResource = repository.findById(id);
        if (optionalConsumableResource.isPresent()){
            ConsumableResource consumableResource = optionalConsumableResource.get();
            consumableResource.updateFromDTO(data);
            repository.save(consumableResource);
        }
    }

    public List<ConsumableResourceResponseDTO> getAll(){
        List<ConsumableResourceResponseDTO> consumableResourceList = repository.findAll().stream().map(ConsumableResourceResponseDTO::new).toList();
        return consumableResourceList;
    }

    public void saveConsumableResource(@RequestBody ConsumableResourceRequestDTO data){
        ConsumableResource consumableResource = new ConsumableResource(data);
        repository.save(consumableResource);
    }

    public Optional<ConsumableResourceResponseDTO> getById(Long id){
        Optional<ConsumableResourceResponseDTO> consumableResource = repository.findById(id).map(ConsumableResourceResponseDTO::new);
        return consumableResource;
    }

    public void deleteConsumableResource(Long id){
        Optional<ConsumableResource> optionalConsumableResource = repository.findById(id);
        if (optionalConsumableResource.isPresent()){
            ConsumableResource consumableResource = optionalConsumableResource.get();
            repository.delete(consumableResource);
        }
    }

}

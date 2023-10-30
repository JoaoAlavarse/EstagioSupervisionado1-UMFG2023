package br.edu.umfg.estagio.service.toolResource;


import br.edu.umfg.estagio.entity.toolResource.ToolResource;
import br.edu.umfg.estagio.entity.toolResource.ToolResourceRequestDTO;
import br.edu.umfg.estagio.entity.toolResource.ToolResourceResponseDTO;
import br.edu.umfg.estagio.repository.toolResource.ToolResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ToolResourceService {
    @Autowired
    private ToolResourceRepository repository;
    public void updateToolResource(Long id, ToolResourceRequestDTO data){
        Optional<ToolResource> optionalToolResource = repository.findById(id);
        if (optionalToolResource.isPresent()){
            ToolResource consumableResource = optionalToolResource.get();
            consumableResource.updateFromDTO(data);
            repository.save(consumableResource);
        }
    }

    public List<ToolResourceResponseDTO> getAll(){
        List<ToolResourceResponseDTO> consumableResourceList = repository.findAll().stream().map(ToolResourceResponseDTO::new).toList();
        return consumableResourceList;
    }

    public void saveToolResource(@RequestBody ToolResourceRequestDTO data){
        ToolResource consumableResource = new ToolResource(data);
        repository.save(consumableResource);
    }

    public Optional<ToolResourceResponseDTO> getById(Long id){
        Optional<ToolResourceResponseDTO> consumableResource = repository.findById(id).map(ToolResourceResponseDTO::new);
        return consumableResource;
    }

    public void deleteToolResource(Long id){
        Optional<ToolResource> optionalToolResource = repository.findById(id);
        if (optionalToolResource.isPresent()){
            ToolResource consumableResource = optionalToolResource.get();
            repository.delete(consumableResource);
        }
    }
}

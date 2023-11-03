package br.edu.umfg.estagio.service.resource;

import br.edu.umfg.estagio.entity.resource.Resource;
import br.edu.umfg.estagio.entity.resource.ResourceRequestDTO;
import br.edu.umfg.estagio.entity.resource.ResourceResponseDTO;
import br.edu.umfg.estagio.repository.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository repository;

    public void updateResource(Long id_resource, ResourceRequestDTO data){
        Optional<Resource> optionalResource = repository.findById(id_resource);
        if (optionalResource.isPresent()){
            Resource resource = optionalResource.get();
            resource.updateFromDTO(data);
            repository.save(resource);
        }
    }

    public List<ResourceResponseDTO> getAll(){
        List<ResourceResponseDTO> resourceList = repository.findAll().stream().map(ResourceResponseDTO::new).toList();
        return resourceList;
    }

    public void saveResource(@RequestBody ResourceRequestDTO data){
        Resource resource = new Resource(data);
        repository.save(resource);
    }

    public void deleteResource(@PathVariable Long id_resource){
        Optional<Resource> optionalResource = repository.findById(id_resource);
        if (optionalResource.isPresent()){
            Resource resource = optionalResource.get();
            repository.delete(resource);
        }
    }

    public Optional<ResourceResponseDTO> getById(Long id_resource){
        Optional<ResourceResponseDTO> resource = repository.findById(id_resource).map(ResourceResponseDTO::new);
        return resource;
    }
}

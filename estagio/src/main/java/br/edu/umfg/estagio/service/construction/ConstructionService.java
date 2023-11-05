package br.edu.umfg.estagio.service.construction;

import br.edu.umfg.estagio.entity.construction.Construction;
import br.edu.umfg.estagio.entity.construction.ConstructionRequestDTO;
import br.edu.umfg.estagio.entity.construction.ConstructionResponseDTO;
import br.edu.umfg.estagio.repository.construction.ConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructionService {
    @Autowired
    private ConstructionRepository repository;

    public void updateConstruction(Long id_construction, ConstructionRequestDTO data){
        Optional<Construction> optionalConstruction = repository.findById(id_construction);
        if (optionalConstruction.isPresent()){
            Construction construction = optionalConstruction.get();
            construction.updateFromDTO(data);
            repository.save(construction);
        }
    }

    public List<ConstructionResponseDTO> getAll(){
        List<ConstructionResponseDTO> constructionResponseDTOList = repository.findAll().stream().map(ConstructionResponseDTO::new).toList();
        return constructionResponseDTOList;
    }

    public void saveConstruction(@RequestBody ConstructionRequestDTO data){
        Construction construction = new Construction(data);
        repository.save(construction);
    }

    public void deleteConstruction(@PathVariable Long id_construction){
        Optional<Construction> optionalConstruction = repository.findById(id_construction);
        if (optionalConstruction.isPresent()){
            Construction construction = optionalConstruction.get();
            repository.delete(construction);
        }
    }

    public Optional<ConstructionResponseDTO> getById(Long id_construction){
        Optional<ConstructionResponseDTO> construction = repository.findById(id_construction).map(ConstructionResponseDTO::new);
        return construction;
    }
}

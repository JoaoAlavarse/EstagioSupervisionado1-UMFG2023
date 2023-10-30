package br.edu.umfg.estagio.service.mobilizedResource;

import br.edu.umfg.estagio.entity.mobilizedResource.MobilizedResource;
import br.edu.umfg.estagio.entity.mobilizedResource.MobilizedResourceRequestDTO;
import br.edu.umfg.estagio.entity.mobilizedResource.MobilizedResourceResponseDTO;
import br.edu.umfg.estagio.repository.mobilizedResource.MobilizedResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MobilizedResourceService {
    @Autowired
    private MobilizedResourceRepository repository;
    public void updateMobilizedResource(Long id, MobilizedResourceRequestDTO data){
        Optional<MobilizedResource> optionalMobilizedResource = repository.findById(id);
        if (optionalMobilizedResource.isPresent()){
            MobilizedResource mobilizedResource = optionalMobilizedResource.get();
            mobilizedResource.updateFromDTO(data);
            repository.save(mobilizedResource);
        }
    }

    public List<MobilizedResourceResponseDTO> getAll(){
        List<MobilizedResourceResponseDTO> mobilizedResourceList = repository.findAll().stream().map(MobilizedResourceResponseDTO::new).toList();
        return mobilizedResourceList;
    }

    public void saveMobilizedResource(@RequestBody MobilizedResourceRequestDTO data){
        MobilizedResource mobilizedResource = new MobilizedResource(data);
        repository.save(mobilizedResource);
    }

    public Optional<MobilizedResourceResponseDTO> getById(Long id){
        Optional<MobilizedResourceResponseDTO> mobilizedResource = repository.findById(id).map(MobilizedResourceResponseDTO::new);
        return mobilizedResource;
    }

    public void deleteMobilizedResource(Long id){
        Optional<MobilizedResource> optionalMobilizedResource = repository.findById(id);
        if (optionalMobilizedResource.isPresent()){
            MobilizedResource mobilizedResource = optionalMobilizedResource.get();
            repository.delete(mobilizedResource);
        }
    }
}

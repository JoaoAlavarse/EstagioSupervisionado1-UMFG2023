package br.edu.umfg.estagio.entity.constructionEmployee;

public record ConstructionEmployeeResponseDTO(Long id_construction_employee, Long id_construction, Long id_employee) {
    public ConstructionEmployeeResponseDTO(ConstructionEmployee constructionEmployee){
        this(constructionEmployee.getId_construction_employee(), constructionEmployee.getId_construction(), constructionEmployee.getId_employee());
    }
}

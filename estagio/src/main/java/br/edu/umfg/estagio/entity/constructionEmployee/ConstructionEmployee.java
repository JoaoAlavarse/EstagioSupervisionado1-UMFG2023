package br.edu.umfg.estagio.entity.constructionEmployee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "construction_employee")
@Entity(name = "construction_employee")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_construction_employee")
public class ConstructionEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_construction_employee;
    private Long id_construction;
    private Long id_employee;

    public ConstructionEmployee(ConstructionEmployeeRequestDTO data){
        this.id_construction = data.id_construction();
        this.id_employee = data.id_employee();
    }

    public void updateFromDTO(ConstructionEmployeeRequestDTO data){
        if (data.id_employee() != null){
            this.id_employee = data.id_employee();
        }
        if (data.id_construction() != null){
            this.id_construction = data.id_construction();
        }
    }
}

package br.edu.umfg.estagio.entity.allocation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "allocation")
@Entity(name = "allocation")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_allocation")
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_allocation;
    private Long id_construction;
    private Long id_resource;
    private Date allocation_date;
    private Date devolution_date;

    public Allocation(AllocationRequestDTO data){
        this.id_construction = data.id_construction();
        this.id_resource = data.id_resource();
        this.allocation_date = data.allocation_date();
        this.devolution_date = data.devolution_date();
    }

    public void updateFromDTO(AllocationRequestDTO data){
        if (data.id_construction() != null){
            this.id_construction = data.id_construction();
        }
        if (data.id_resource() != null){
            this.id_resource = data.id_resource();
        }
        if (data.allocation_date() != null){
            this.allocation_date = data.allocation_date();
        }
        this.devolution_date = data.devolution_date();
    }
}

package br.edu.umfg.estagio.entity.construction;

import br.edu.umfg.estagio.enums.ConstructionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "construction")
@Entity(name = "construction")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_construction")
public class Construction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_construction;
    private String company;
    private String cnpj;
    private Date delivery_date;
    private Date start_date;
    private String address;
    @Enumerated(EnumType.STRING)
    private ConstructionStatus status;

    public Construction(ConstructionRequestDTO data){
        this.company = data.company();
        this.cnpj = data.cnpj();
        this.delivery_date = data.delivery_date();
        this.start_date = data.start_date();
        this.address = data.address();
        this.status = data.status();
    }

    public void updateFromDTO(ConstructionRequestDTO data){
        if (data.company() != null){
            this.company = data.company();
        }
        if (data.cnpj() != null){
            this.cnpj = data.cnpj();
        }
        if (data.delivery_date() != null){
            this.delivery_date = data.delivery_date();
        }
        if (data.start_date() != null){
            this.start_date = data.start_date();
        }
        if (data.address() != null){
            this.address = data.address();
        }
        if (data.status() != null){
            this.status = data.status();
        }
    }
}

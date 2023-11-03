package br.edu.umfg.estagio.entity.resource;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "resource")
@Entity(name = "resource")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resource;
    private String name;
    private String brand;
    private Long quantity;
    private Integer type;
    private String observation;
    private Date purchase;

    public Resource(ResourceRequestDTO data){
        this.name = data.name();
        this.brand = data.brand();
        this.quantity = data.quantity();
        this.type = data.type();
        this.observation = data.observation();
        this.purchase = data.purchase();
    }

    public void updateFromDTO(ResourceRequestDTO data){
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.brand() != null){
            this.brand = data.brand();
        }
        if (data.quantity() != null){
            this.quantity = data.quantity();
        }
        if (data.type() != null){
            this.type = data.type();
        }
        if (data.purchase() != null){
            this.purchase = data.purchase();
        }
        this.observation = data.observation();
    }
}

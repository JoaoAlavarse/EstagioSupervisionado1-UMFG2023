package br.edu.umfg.estagio.entity.consumableResources;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "consumable_resource")
@Entity(name = "consumable_resource")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConsumableResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Long quantity;

    public ConsumableResource(ConsumableResourceRequestDTO data){
        this.name = data.name();
        this.brand = data.brand();
        this.quantity = data.quantity();
    }

    public void updateFromDTO(ConsumableResourceRequestDTO data){
            if(data.name() != null){
                this.name = data.name();
            }
            if(data.brand() != null){
                this.brand = data.brand();
            }
            if(data.quantity() != null) {
                this.quantity = data.quantity();
            }
    }
}

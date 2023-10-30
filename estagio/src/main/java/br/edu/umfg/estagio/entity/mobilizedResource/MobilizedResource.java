package br.edu.umfg.estagio.entity.mobilizedResource;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "mobilized_resource")
@Entity(name = "mobilized_resource")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MobilizedResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String renavam;
    private Long quantity;



    public MobilizedResource(MobilizedResourceRequestDTO data){
        this.name = data.name();
        this.brand = data.brand();
        this.renavam = data.renavam();
        this.quantity = data.quantity();
    }

    public void updateFromDTO(MobilizedResourceRequestDTO data){
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.brand() != null){
            this.brand = data.brand();
        }
        if(data.quantity() != null) {
            this.quantity = data.quantity();
        }
        if(data.renavam() != null){
            this.renavam = data.renavam();
        }
    }
}

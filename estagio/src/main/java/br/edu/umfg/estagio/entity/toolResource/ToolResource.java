package br.edu.umfg.estagio.entity.toolResource;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tool_resource")
@Entity(name = "tool_resource")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ToolResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private  Long quantity;

    public ToolResource(ToolResourceRequestDTO data){
        this.name = data.name();
        this.brand = data.brand();
        this.quantity = data.quantity();
    }

    public void updateFromDTO(ToolResourceRequestDTO data){
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

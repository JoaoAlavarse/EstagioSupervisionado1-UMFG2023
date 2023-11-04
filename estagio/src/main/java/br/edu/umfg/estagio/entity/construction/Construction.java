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
}

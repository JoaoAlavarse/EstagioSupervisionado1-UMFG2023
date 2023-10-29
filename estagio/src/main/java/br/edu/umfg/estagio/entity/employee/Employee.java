package br.edu.umfg.estagio.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "funcionario")
@Entity(name = "employee")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String address;
    private String charge;

    public Employee(EmployeeRequestDTO data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.phone = data.phone();
        this.address = data.address();
        this.charge = data.charge();
    }

    public void updateFromDTO(EmployeeRequestDTO data){
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.cpf() != null){
            this.cpf = data.cpf();
        }
        if(data.phone() != null){
            this.phone = data.phone();
        }
        if(data.address() != null){
            this.address = data.address();
        }
        if(data.charge() != null){
            this.charge = data.charge();
        }
    }
}

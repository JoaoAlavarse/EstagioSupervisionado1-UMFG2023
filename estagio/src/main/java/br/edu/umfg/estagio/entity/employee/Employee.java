package br.edu.umfg.estagio.entity.employee;

import br.edu.umfg.estagio.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "employee")
@Entity(name = "employee")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String name;
    private String cpf;
    private String phone;
    private String address;
    private String charge;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date birth_date;

    public Employee(EmployeeRequestDTO data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.phone = data.phone();
        this.address = data.address();
        this.charge = data.charge();
        this.gender = data.gender();
        this.birth_date = data.birth_date();
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
        if (data.gender() != null){
            this.gender = data.gender();
        }
        if (data.birth_date() != null){
            this.birth_date = data.birth_date();
        }
    }
}

package br.edu.umfg.estagio.entity.employee;

import br.edu.umfg.estagio.enums.Gender;

import java.sql.Date;

public record EmployeeResponseDTO(Long id_employee, String name, String cpf, String phone, String address, String charge, Gender gender, Date birth_date) {

   public  EmployeeResponseDTO(Employee employee){
        this(employee.getId_employee(), employee.getName(), employee.getCpf(), employee.getPhone(), employee.getAddress(), employee.getCharge(), employee.getGender(), employee.getBirth_date());
   }
}

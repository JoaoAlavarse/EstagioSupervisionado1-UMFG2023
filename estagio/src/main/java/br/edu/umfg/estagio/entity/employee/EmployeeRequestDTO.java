package br.edu.umfg.estagio.entity.employee;

import br.edu.umfg.estagio.enums.Gender;

import java.sql.Date;

public record EmployeeRequestDTO(String name, String cpf, String phone, String address, String charge, Gender gender, Date birth_date) {
}

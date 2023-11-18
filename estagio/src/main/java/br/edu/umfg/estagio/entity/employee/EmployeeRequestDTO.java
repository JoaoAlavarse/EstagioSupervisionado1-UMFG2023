package br.edu.umfg.estagio.entity.employee;

import br.edu.umfg.estagio.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class EmployeeRequestDTO {
    @NotNull
    public String name;
    @NotNull
    public String cpf;
    @NotNull
    public String phone;
    @NotNull
    public String address;
    @NotNull
    @NotBlank(message = "TESTE")
    public String charge;
    @NotNull
    public Gender gender;
    @NotNull
    public Date birth_date;

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCharge() {
        return charge;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}

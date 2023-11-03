package br.edu.umfg.estagio.entity.employee;

public record EmployeeResponseDTO(Long id_employee, String name, String cpf, String phone, String address, String charge) {

   public  EmployeeResponseDTO(Employee employee){
        this(employee.getId_employee(), employee.getName(), employee.getCpf(), employee.getPhone(), employee.getAddress(), employee.getCharge());
   }
}

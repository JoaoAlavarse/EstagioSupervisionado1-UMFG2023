package br.edu.umfg.estagio.entity.employee;

public record EmployeeResponseDTO(Long id, String name, String cpf, String phone, String address, String charge) {

   public  EmployeeResponseDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getCpf(), employee.getPhone(), employee.getAddress(), employee.getCharge());
   }
}

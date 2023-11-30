package br.edu.umfg.estagio.enums;

public enum EmployeeStatus {
    ATIVO(1),
    INATIVO(2);

    private final int value;

    EmployeeStatus(int value){this.value = value;}

    public int getValue() {
        return value;
    }

    public static br.edu.umfg.estagio.enums.EmployeeStatus fromValue(int value){
        for (br.edu.umfg.estagio.enums.EmployeeStatus status : br.edu.umfg.estagio.enums.EmployeeStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ConstructionStatus value: " + value);
    }
}

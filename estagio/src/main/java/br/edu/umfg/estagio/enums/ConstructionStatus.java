package br.edu.umfg.estagio.enums;

public enum ConstructionStatus {
    APROVADA(1),
    PARALISADA(2),
    CANCELADA(3),
    EM_ANDAMENTO(4),
    CONCLUIDA(5);

    private final int value;

    ConstructionStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static ConstructionStatus fromValue(int value){
        for (ConstructionStatus status : ConstructionStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ConstructionStatus value: " + value);
    }
}

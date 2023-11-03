package br.edu.umfg.estagio.enums;

public enum ResourceType {
    CONSUMIVEL(1),
    FERRAMENTA(2),
    MOBILIZADO(3);

    private final int value;

    ResourceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ResourceType fromValue(int value) {
        for (ResourceType type : ResourceType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ResourceType value: " + value);
    }
}

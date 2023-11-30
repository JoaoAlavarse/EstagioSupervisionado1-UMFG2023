package br.edu.umfg.estagio.enums;

public enum Gender {

        MASCULINO(1),
        FEMININO(2),
        OUTRO(3);
        private final int value;

        Gender(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static br.edu.umfg.estagio.enums.Gender fromValue(int value){
            for (br.edu.umfg.estagio.enums.Gender status : br.edu.umfg.estagio.enums.Gender.values()){
                if (status.getValue() == value){
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid ConstructionStatus value: " + value);
        }


}

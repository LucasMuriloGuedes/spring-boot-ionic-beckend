package com.lucasmurilo.cursospringboot.domain.emuns;

public enum TipoCliente {

    PESSOA_FISICA(1),
    PESSOA_JURIDICA(2);

    private int cod;

    TipoCliente(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public static TipoCliente toEnum(Integer cod){

        if(cod ==null){
            return null;
        }

        for(TipoCliente x : TipoCliente.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido! " + cod);

    }
}

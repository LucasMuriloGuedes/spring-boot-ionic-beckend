package com.lucasmurilo.cursospringboot.domain.emuns;

public enum EstadoPagamento {
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private Integer cod;

    EstadoPagamento(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(EstadoPagamento x: EstadoPagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido : " + cod);

    }
}

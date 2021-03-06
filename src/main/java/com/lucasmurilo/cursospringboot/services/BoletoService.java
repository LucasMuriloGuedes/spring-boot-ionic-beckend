package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instantePedido){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instantePedido);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pgto.setDataVencimento(cal.getTime());
    }
}

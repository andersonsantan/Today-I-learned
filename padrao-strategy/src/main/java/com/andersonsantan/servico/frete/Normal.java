package com.andersonsantan.servico.frete;

import com.andersonsantan.servico.Frete;

public class Normal implements Frete {

    @Override
    public double calcularPreco(int distancia) {
        return distancia * 1.35 + 10;
    }
}

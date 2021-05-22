package com.andersonsantan.servico;

import java.util.Scanner;

public class Exemplo {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)){
            System.out.println("Informe a distância: ");
            int distancia = entrada.nextInt();
            System.out.println("Qual o tipo de frete (1) Mormal, (2) Sedex: ");
            int opcaoFrete = entrada.nextInt();
            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete -1];

            Frete frete = tipoFrete.obterFrete();
            double preco = frete.calcularPreco(distancia);
            System.out.printf("O valor do frete é de R$%.2f", preco);

        }

    }
}

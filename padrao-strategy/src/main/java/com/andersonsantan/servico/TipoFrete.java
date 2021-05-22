package com.andersonsantan.servico;

import com.andersonsantan.servico.frete.Normal;
import com.andersonsantan.servico.frete.Sedex;

public enum TipoFrete {
    NORMAL {
        @Override
        public Frete obterFrete() {
            return new Normal();
        }
    },
    SEDEX {
        @Override
        public Frete obterFrete() {
            return new Sedex();
        }
    };

    public abstract Frete obterFrete();
}

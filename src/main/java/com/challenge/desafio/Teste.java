package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Teste {
    @Somar()
    protected BigDecimal um = new BigDecimal(10);

    @Somar()
    protected BigDecimal dois = new BigDecimal(20);

    @Somar()
    protected BigDecimal tres = new BigDecimal(30);

    //@Somar(number=10)
    // protected int dez = 10;

    @Subtrair()
    protected BigDecimal quatro = new BigDecimal(70);

    @Subtrair()
    protected BigDecimal cinco = new BigDecimal(80);

    public BigDecimal getUm() {
        return um;
    }

    public void setUm(BigDecimal um) {
        this.um = um;
    }

    public BigDecimal getDois() {
        return dois;
    }

    public void setDois(BigDecimal dois) {
        this.dois = dois;
    }

    public BigDecimal getTres() {
        return tres;
    }

    public void setTres(BigDecimal tres) {
        this.tres = tres;
    }
}

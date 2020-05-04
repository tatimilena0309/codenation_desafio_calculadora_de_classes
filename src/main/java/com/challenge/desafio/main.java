package com.challenge.desafio;

public class main {
    private static CalculadorDeClasses classe = new CalculadorDeClasses();

    public static void main (String args[]){
        
        CalculadorDeClasses app = new CalculadorDeClasses();
        Teste teste = new Teste();
        System.out.println("Subtrair " + app.subtrair(teste));
        System.out.println("Somar " + app.somar(teste));
        System.out.println("Totalizar " + app.totalizar(teste));

    }
}

package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculadorDeClasses implements Calculavel {

    private List<BigDecimal> numeros = new ArrayList<>();

    @Override
    public BigDecimal somar(Object classe) {

        BigDecimal retorno = isAnotacao(classe);
        if (retorno == null) {
            this.numeros.clear();
            List<BigDecimal> numeros = buscadorDeAnnotations(classe);
            if (numeros.contains(BigDecimal.ZERO)) {
                retorno = BigDecimal.ZERO;
            } else {
                retorno = new BigDecimal(0);
                for (BigDecimal value : numeros) {
                    retorno = retorno.add(value);
                }
            }
        }
        return retorno;
    }

    @Override
    public BigDecimal subtrair(Object classe) {

        BigDecimal retorno = isAnotacao(classe);
        if (retorno == null) {
            this.numeros.clear();
            List<BigDecimal> numeros = buscadorDeAnnotations(classe);
            if (numeros.contains(BigDecimal.ZERO)) {
                retorno = BigDecimal.ZERO;
            } else {
                retorno = new BigDecimal(0);
                for (BigDecimal value : numeros) {
                    retorno = retorno.add(value);
                }
            }
        }
        return retorno;
    }

    @Override
    public BigDecimal totalizar(Object classe) {

        somar(classe);
        subtrair(classe);
        return somar(classe).subtract(subtrair(classe));
    }

    public List<BigDecimal> buscadorDeAnnotations(Object classe) {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Class<?> obj = classe.getClass();
        for (Field field : (obj.getDeclaredFields())) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Somar.class) && stackTrace[2].getMethodName().equals("somar")) {
                adicionar(field,classe);
            } else {
                if (field.isAnnotationPresent(Subtrair.class) && stackTrace[2].getMethodName().equals("subtrair")) {
                    adicionar(field,classe);
                }
            }
        }
        return numeros;
    }

    public BigDecimal isAnotacao(Object classe) {

        Class<?> obj = classe.getClass();
        if (obj.getDeclaredFields().length == 0) {
            return BigDecimal.ZERO;
        }
        return null;
    }

    public void adicionar(Field field, Object classe) {

        if (field.getType().equals(BigDecimal.class)) {
            try {
                field.setAccessible(true);
                this.numeros.add((BigDecimal) field.get(classe));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            this.numeros.add(BigDecimal.ZERO);
        }
    }
}


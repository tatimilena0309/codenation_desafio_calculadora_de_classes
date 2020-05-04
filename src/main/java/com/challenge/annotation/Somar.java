package com.challenge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD) //onde eu vou colocar esses annotations
@Retention(RetentionPolicy.RUNTIME) //Vai executar em tempo de execução
public @interface Somar{
}
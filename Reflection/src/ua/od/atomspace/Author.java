package ua.od.atomspace;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    // в полях нужно указывать () как в методах
    String author() default "d1sam";// по дэфолту будет d1sam
    int dateOfCreation() default 2021;// по дэфолту будет 2021
}

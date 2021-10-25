package ua.od.atomspace;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// Аннотации аннотирующие аннотации
// Target указывает с чем может применяться аннотация
// в данном случае {} с помощью фигурных кавычек перечислено, что аннотация может использоваться с методам и конструкторами
// ElementType.TYPE - класс, интерфейс, перечисление
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
// Retention - политика удержания аннотации (то есть на каком моменте она исчезнет из кода
// source - при компиляции (видна только в исходном коде)
// class - сохранится в байт-коде, но в рантайме уже не будет доступна
// runtime - сохранится в байт-коде и будет доступна в рантайме (рефлексия)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    // в полях нужно указывать () как в методах
    String author() default "d1sam";// по дэфолту будет d1sam
    int dateOfCreation() default 2021;// по дэфолту будет 2021
    String purpose();
}

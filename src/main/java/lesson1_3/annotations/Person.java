package lesson1_3.annotations;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@MyAnnotation(message = "Я персона номер 1", flag = true)
@AllArgsConstructor
public class Person {
    private  final  String name;
    private boolean isGood;
}

package lesson1_3.hw;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Department(message = "Кафедра биологии")
@AllArgsConstructor
@ToString
public class BiologyStudent {
    private final String name;
    private final String surname;
    private int course;

}

package lesson1_3.hw;

@Department(message = "Кафедра математики")
public class MathStudent {
    private String name = "Pavel";
    private String surname = "Konovalov";
    private int course = 3;

    public String toString() {
        return "MathStudent(Имя = " + this.name + ", Фамилия = " + this.surname + ", курс = " + this.course + ")";
    }
}

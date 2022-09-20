package lesson1_3.hw;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyPractice {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        MathStudent student1 = new MathStudent();
        System.out.println(student1);

        Class<?> mathStudentClass = student1.getClass();
        System.out.println("Класс: " + mathStudentClass.getSimpleName());

        Field[] fields = mathStudentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName() + ", тип: " + field.getType().getSimpleName());
        }

        Field field = mathStudentClass.getDeclaredField("course");
        field.setAccessible(true);
        field.setInt(student1, 5);
        System.out.println(student1);

        System.out.println(mathStudentClass.getAnnotation(Department.class));
        Department department = mathStudentClass.getAnnotation(Department.class);
        System.out.println(department.message());

        System.out.println(student1 + ": " + department.message());


        Class<?> biologyStudentClass = Class.forName("lesson1_3.hw.BiologyStudent");
        System.out.println(biologyStudentClass.getSimpleName());
        BiologyStudent student2 = (BiologyStudent) biologyStudentClass.getConstructor(String.class, String.class, int.class)
                .newInstance("Ivan", "Sergeev", 4);
        System.out.println(student2);

        System.out.println(biologyStudentClass.getAnnotations()[0]);

        Department department1 = biologyStudentClass.getAnnotation(Department.class);
        System.out.println(department1.message());

        System.out.println(student2 + ": " + department1.message());


    }
}

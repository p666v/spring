package lesson1_3.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationPractice {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Person ivan = new Person("Ivan", true);
//        System.out.println(ivan);
//
//        Class<? extends Person> personClass = ivan.getClass();
//        System.out.println(personClass.getName());
//        System.out.println(personClass.getSimpleName());


        Class<?> personClass = Class.forName("lesson1_3.annotations.Person");
        System.out.println(personClass.getName());
        Person ivan = (Person) personClass.getConstructor(String.class, Boolean.TYPE)
                .newInstance("Ivan", true);
        System.out.println(ivan);

        System.out.println(personClass.getAnnotations()[0]);

        Field isGood = personClass.getDeclaredField("isGood");
        isGood.setAccessible(true);
        isGood.set(ivan, false);
        System.out.println(ivan);


    }
}

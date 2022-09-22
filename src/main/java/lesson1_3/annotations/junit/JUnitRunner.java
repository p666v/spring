package lesson1_3.annotations.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnitRunner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MyFavoriteTest myFavoriteTest = new MyFavoriteTest();
        Method[] methodsMyFavoriteTest = MyFavoriteTest.class.getDeclaredMethods();

        int passedTest = 0;
        int failedTest = 0;

        for (Method method : methodsMyFavoriteTest) {
            if (method.isAnnotationPresent(Test.class)) {
                System.out.println(method.getName());
                try {
                    method.invoke(myFavoriteTest);
                    System.out.println(method.getName() + "PASSED");
                    passedTest++;
                } catch (InvocationTargetException exception) {
                    System.err.println(method.getName() + "FAILED");
                    failedTest++;
                }
            }
        }

        System.out.println("Колличество пройденных тестов: " + passedTest);
        System.out.println("Колличество упавших тестов: " + failedTest);


    }


}

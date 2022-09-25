package lesson1_3.annotations.junit;

import lesson1_3.annotations.junit.myAnnotation.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class MyJUnit {
    private final Object objTestClass;
    private int passedTest = 0;
    private int failedTest = 0;

    public void start() {
        beforeAllTest();

        testMethod();

        afterAllTest();

        printResults();
    }

    private void beforeAllTest() {
        for (Method method : objTestClass.getClass().getDeclaredMethods()) {
            try {
                if (method.isAnnotationPresent(BeforeAll.class) && method.isAnnotationPresent(DisplayName.class)) {
                    System.out.println(method.getAnnotation(DisplayName.class).value());
                    method.invoke(objTestClass);
                } else if (method.isAnnotationPresent(BeforeAll.class)) {
                    method.invoke(objTestClass);
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void afterAllTest() {
        for (Method method : objTestClass.getClass().getDeclaredMethods()) {
            try {
                if (method.isAnnotationPresent(AfterAll.class) && method.isAnnotationPresent(DisplayName.class)) {
                    System.out.println(method.getAnnotation(DisplayName.class).value());
                    method.invoke(objTestClass);
                } else if (method.isAnnotationPresent(AfterAll.class)) {
                    method.invoke(objTestClass);
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void beforeTest() {
        for (Method method : objTestClass.getClass().getDeclaredMethods()) {
            try {
                if (method.isAnnotationPresent(Before.class) && method.isAnnotationPresent(DisplayName.class)) {
                    System.out.println(method.getAnnotation(DisplayName.class).value());
                    method.invoke(objTestClass);
                } else if (method.isAnnotationPresent(Before.class)) {
                    method.invoke(objTestClass);
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void afterTest() {
        for (Method method : objTestClass.getClass().getDeclaredMethods()) {
            try {
                if (method.isAnnotationPresent(After.class) && method.isAnnotationPresent(DisplayName.class)) {
                    System.out.println(method.getAnnotation(DisplayName.class).value());
                    method.invoke(objTestClass);
                } else if (method.isAnnotationPresent(After.class)) {
                    method.invoke(objTestClass);
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void testMethod() {
        for (Method method : objTestClass.getClass().getDeclaredMethods()) {
            try {
                if (method.isAnnotationPresent(Test.class) && method.isAnnotationPresent(DisplayName.class)) {
                    beforeTest();
                    System.out.println(method.getAnnotation(DisplayName.class).value());
                    method.invoke(objTestClass);
                    System.out.println(method.getName() + " PASSED");
                    passedTest++;
                    afterTest();
                } else if (method.isAnnotationPresent(Test.class)) {
                    beforeTest();
                    method.invoke(objTestClass);
                    System.out.println(method.getName() + " PASSED");
                    passedTest++;
                    afterTest();
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                System.out.println(method.getName() + " FAILED");
                failedTest++;
                afterTest();
            }
        }
    }

    private void printResults() {
        System.out.println("============================================");
        System.out.println("Колличество пройденных тестов: " + passedTest);
        System.out.println("Колличество упавших тестов: " + failedTest);
        System.out.println("============================================");
    }
}

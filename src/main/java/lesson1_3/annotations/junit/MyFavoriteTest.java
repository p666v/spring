package lesson1_3.annotations.junit;

import lesson1_3.annotations.junit.myAnnotation.*;

public class MyFavoriteTest {

    @BeforeAll
    @DisplayName(value = "Выполнить первым действием beforeAllMethods")
    public void beforeAllMethods() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    public void afterAllMethods() {
        System.out.println("AFTER ALL");
    }

    @DisplayName(value = "ТЕСТ 1")
    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @DisplayName(value = "ТЕСТ 4")
    @Test
    public void test4() {
    }

    @Test
    public void test5() {
    }

    @Test
    public void test3() {
        throw new RuntimeException();
    }

    public void noTestMethod() {
    }

    @Before
    public void before() {
        System.out.println("До");
    }

    @After
    public void after() {
        System.out.println("После");
    }


}

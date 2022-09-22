package lesson1_3.annotations.junit;

public class MyFavoriteTest {
    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
        throw new RuntimeException();
    }

    public void noTestMethod() {
    }


}

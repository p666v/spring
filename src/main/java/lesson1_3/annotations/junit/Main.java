package lesson1_3.annotations.junit;

public class Main {
    public static void main(String[] args) {
        MyJUnit myJUnit = new MyJUnit(new MyFavoriteTest());
        myJUnit.start();

    }


}

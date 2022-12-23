package abstractTest;

public abstract class abstClass {

    private int a = 1;
    private int b = 1;
    private int c = 1;


    public abstClass() {}

    public void test1(){
        System.out.println("true = " + true);
    }

    public abstract void test2();

    public static void test3(){
        System.out.println("true = " + true);
    }
}

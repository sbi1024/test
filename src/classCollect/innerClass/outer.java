package classCollect.innerClass;

public class outer {

    private int a = 1;
    private int b = 1;

    public void outerMethod() {
        System.out.println("outerMethod play");
    }

    public class inner {
        int a = 1;
        int b = 2;
        int c = this.a;


        public void innerMethod() {
            System.out.println("innerMethod play");
            System.out.println("c = " + c);
        }

    }

    public class normalInner {
        int a = 4;
        int b = 4;

        public void normalInnerMethod() {
            System.out.println("innerMethod ");
        }
    }

    public static class stInner {
        int a = 3;
        int b = 3;

        public void stinnerMethod() {
            System.out.println("stinnerMethod play");
        }

        public void stInnerMethod1() {
            int a = 2;
            int i = a + this.a;
            System.out.println("i = " + i);
        }

    }
}

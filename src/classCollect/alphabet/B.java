package classCollect.alphabet;

public class B extends A{
    public String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public void soutData() {
        System.out.println("b = " + b);
    }
}

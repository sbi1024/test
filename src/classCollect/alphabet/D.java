package classCollect.alphabet;

public class D extends A {
    public String d;

    public D() {
        this.d = "d";
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    @Override
    public void soutData() {
        System.out.println("d = " + d);
    }
}

package classCollect.thread;

public class thread0 {
    private String abc;

    private thread0(String str) {
        this.abc = str;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public static thread0 createThread1(String str) {
        return new thread0(str);
    }
}

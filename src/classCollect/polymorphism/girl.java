package classCollect.polymorphism;

public class girl extends parent{
    private String shose;

    public girl() {
        this.shose = "여자 신발";
    }

    public String getShose() {
        return shose;
    }

    public void setShose(String shose) {
        this.shose = shose;
    }

    @Override
    public void parentMethod(){
        System.out.println("parentMethod ========> girlMethod 실행 !!!!!");
    }
}

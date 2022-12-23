package classCollect.polymorphism;

public class boy extends parent{
    private String hobby;
    public boy(){
        this.hobby = "남자 취미";
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    @Override
    public void parentMethod(){
        System.out.println("parentMethod ========> boyMethod 실행 !!!!!");
    }


}

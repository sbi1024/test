package classCollect.polymorphism;

public class parent {
    private int age;
    private String sex;
    private String phoneNumber;
    private String address;

    public parent() {}

    public parent(int age, String sex, String phoneNumber, String address) {
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void parentMethod(){
        System.out.println("parentMethod ========> parentMethod 실행 !!!!!");
    }
}

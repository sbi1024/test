package classCollect.person;

import interfaceCollect.personable;

public class female extends personCommon implements personable {
    public female(personCommon p) {
        this.name = p.getName();
        this.age = p.getAge();
        this.sex = p.getSex();
        this.job = p.getJob();
        this.phoneNumber = p.getPhoneNumber();
    }
    public female() {}
    @Override
    public void walk() {
        System.out.println("female =======> walk");
    }

    @Override
    public void eat() {
        System.out.println("female =======> eat");
    }

    @Override
    public void sleep() {
        System.out.println("female =======> sleep");
    }

    @Override
    public void fight() {
        System.out.println("female =======> fight");
    }

    @Override
    public String toString() {
        return "female{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

package classCollect.person;

import interfaceCollect.personable;

public class male extends personCommon implements personable {
    public male(personCommon p) {
        this.name = p.getName();
        this.age = p.getAge();
        this.sex = p.getSex();
        this.job = p.getJob();
        this.phoneNumber = p.getPhoneNumber();
    }

    public male() {}

    @Override
    public void walk() {
        System.out.println("male =======> walk");
    }

    @Override
    public void eat() {
        System.out.println("male =======> eat");
    }

    @Override
    public void sleep() {
        System.out.println("male =======> sleep");
    }

    @Override
    public void fight() {
        System.out.println("male =======> fight");
    }

    @Override
    public String toString() {
        return "male{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

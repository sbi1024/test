package classCollect.person;

/**
 * 1. person class의 공통 멤버 선언
 * 2. 공통 멤버 getter, setter 구현
 */
public class personCommon {
    public String name;
    public String age;
    public String sex;
    public String job;

    public personCommon() {}

    public personCommon(String name, String age, String sex, String job, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.job = job;
        this.phoneNumber = phoneNumber;
    }

    public String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

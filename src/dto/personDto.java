package dto;

public class personDto implements Cloneable{
    private String sex ;
    private String age ;
    private String size;

    public personDto(String sex, String age, String size) {
        this.sex = sex;
        this.age = age;
        this.size = size;
    }

    public personDto() {}

    @Override
    public personDto clone() throws CloneNotSupportedException {
        return (personDto) super.clone();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(
            String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "personDto{" +
                "sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public static personDto createPerson(String sex ,String age ,String size) {
        return new personDto(sex, age, size);
    }
}

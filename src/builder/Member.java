package builder;

public class Member {
    private String name;
    private int age;
    private String address;
    private String phone;

    private Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    // 빌더 호출, 외부에서 Member.builder() 으로 접근할 수 있도록 static 메소드로 생성
    public static Builder builder() {
        return new Builder();
    }

    // static 형태의 inner class 생성
    public static class Builder {
        private String name;
        private int age;
        private String address;
        private String phone;

        private Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        // 마지막에 build 메소드를 실행하면 this가 return 되도록 구현
        public Member build() {
            return new Member(this);
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package utilCollect.logic;

import java.util.Arrays;

public enum ValuesEnum {
    TEST1("TEST11" , "-1") {
        @Override
        public void systemOut1() {
            System.out.println("TEST1 의 systemOut1 메소드 입니다.");
        }

        @Override
        public void systemOut2() {
            System.out.println("TEST1 의 systemOut2 메소드 입니다.");
        }
    }, TEST2("TEST22" , "-2") {
        @Override
        public void systemOut1() {
            System.out.println("TEST2 의 systemOut1 메소드 입니다.");
        }

        @Override
        public void systemOut2() {
            System.out.println("TEST2 의 systemOut2 메소드 입니다.");
        }
    }, TEST3("TEST33" , "-3") {
        @Override
        public void systemOut1() {
            System.out.println("TEST3 의 systemOut1 메소드 입니다.");
        }

        @Override
        public void systemOut2() {
            System.out.println("TEST3 의 systemOut2 메소드 입니다.");
        }
    }, TEST4("TEST44", "-4") {
        @Override
        public void systemOut1() {
            System.out.println("TEST4 의 systemOut1 메소드 입니다.");
        }

        @Override
        public void systemOut2() {
            System.out.println("TEST4 의 systemOut2 메소드 입니다.");
        }
    };

    private final String name1;
    private final String name2;

    ValuesEnum(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;

    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public abstract void systemOut1();

    public abstract void systemOut2();

    @Override
    public String toString() {
        return "ValuesEnum{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }

    public static ValuesEnum findEnumDate(){
        System.out.println("ValuesEnum.values() = " + ValuesEnum.values());
        
        ValuesEnum finalEnum = Arrays.stream(ValuesEnum.values())
                .filter(value -> value.getName1().equals("-1"))
                .findAny()
                .orElse(null);

        return finalEnum;
    }
}

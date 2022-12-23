package utilCollect.enumclass;

public enum statusEnumDouble {
    STATUS_MALE_DOUBLE("male", 10000) {
        @Override
        public void soutSexAndCode() {
            System.out.println("sex = " + getSex());
            System.out.println("sexCode = " + getSexCode());
        }
    },
    STATUS_FEMALE_DOUBLE("female", 20000) {
        @Override
        public void soutSexAndCode() {
            System.out.println("sex = " + sex);
            System.out.println("sexCode = " + sexCode);
        }
    },
    STATUS_UNKNOWN_DOUBLE("unknown", 30000) {
        @Override
        public void soutSexAndCode() {
            System.out.println("sex = " + sex);
            System.out.println("sexCode = " + sexCode);
        }
    };

    String sex;
    int sexCode;

    public String getSex() {
        return sex;
    }

    public int getSexCode() {
        return sexCode;
    }

    statusEnumDouble(String sex, int sexCode) {
        this.sex = sex;
        this.sexCode = sexCode;
    }

    public abstract void soutSexAndCode();
}

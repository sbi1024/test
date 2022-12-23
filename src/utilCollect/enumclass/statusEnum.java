package utilCollect.enumclass;

/**
 * 남자 , 여자 성별의 값을 enum Class로 관리
 */
public enum statusEnum {
    STATUS_MALE("male"){
        @Override
        public void soutStatus() {
            System.out.println("남자 입니다.");
        }
    }, STATUS_FEMALE("female"){
        @Override
        public void soutStatus() {
            System.out.println("여자 입니다.");
        }
    }, STATUS_UNKNOWN("unknown"){
        @Override
        public void soutStatus() {
            System.out.println("알수없는 성별 입니다.");
        }
    };
    String sex;

    statusEnum(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
    
    // 추상 메소드를 통한 구현
    public abstract void soutStatus();

}

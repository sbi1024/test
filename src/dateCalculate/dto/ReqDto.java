package dateCalculate.dto;

import java.util.Objects;

/**
 * date : 2022.12.29 목요일
 * writer : SeoBoIn
 * request 요청값에 사용할 DTO 클래스 정의
 */
public class ReqDto {
    private static ReqDto reqDto;
    // 시작 날짜 EX) 202301051530
    private String startDate;
    // 종료 날짜 EX) 202301051730
    private String endDate;
    // 반복 타입
    private String repeatType;
    // 반복 요일 EX) "1,2,5,6" 월요일 , 화요일 , 금요일 , 토요일
    private String repeatByDay;
    // 반복 종료일
    private String repeatEndDay;

    /** TODO 접근 제어자를 private 로 설정하여 , new 연산자를 통해 객체 생성을 불가하게 지정 */
    private ReqDto() {}

    // get , set startDate
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // get , set endDate
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // get , set repeatType
    public String getRepeatType() {
        return repeatType;
    }
    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType;
    }

    // get , set repeatByDay
    public String getRepeatByDay() {
        return repeatByDay;
    }
    public void setRepeatByDay(String repeatByDay) {
        this.repeatByDay = repeatByDay;
    }

    // get , set repeatEndDay
    public String getRepeatEndDay() {
        return repeatEndDay;
    }
    public void setRepeatEndDay(String repeatEndDay) {
        this.repeatEndDay = repeatEndDay;
    }
    /*******************************************************************************************************************
     * 갹체를 생성하는 방법에는 하기 아래와 같은 방법이 존재한다
     * 1. new 연산자를 통한 객체 생성
     * 2. 정적 팩토리 메소드를 통한 객체 생성
     * 3. builder를 통한 객체 생성 */

    /** TODO 이번 경우는 정적 팩토리 메소드를 통해 구성할 예정 */
    public static ReqDto createReqDto(){
        if (reqDto == null) {
            return new ReqDto();
        }
        reqDto.dtoClear();
        return reqDto;
    }

    /**
     * TODO Clear 메소드를 통해 , 해당 객체를 계속해서 재 활용할수 있도록 구성
     */
    private void dtoClear() {
        this.startDate = "";
        this.endDate = "";
        this.repeatType = "";
        this.repeatByDay = "";
        this.repeatEndDay = "";
    }


    /*******************************************************************************************************************
     * 하기 아래 method 는 Efective Java 내용에 따라 , 반드시 재 정의 해야하는 메소드를 구성
     * 1. toString
     * 2. equals
     * 3. hashCode
     */

    // toString 메소드 정의
    @Override
    public String toString() {
        return "startDate='" + startDate + '\'' + System.lineSeparator() +
                "endDate='" + endDate + '\'' + System.lineSeparator() +
                "repeatType='" + repeatType + '\'' + System.lineSeparator() +
                "repeatByDay='" + repeatByDay + '\'' + System.lineSeparator() +
                "repeatEndDay='" + repeatEndDay + '\'' + System.lineSeparator();
    }

    // equals 메소드 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReqDto reqDto = (ReqDto) o;
        return startDate.equals(reqDto.startDate)
                && endDate.equals(reqDto.endDate)
                && repeatType.equals(reqDto.repeatType)
                && repeatByDay.equals(reqDto.repeatByDay)
                && repeatEndDay.equals(reqDto.repeatEndDay);
    }

    // hashCode 메소드 재정의
    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, repeatType, repeatByDay, repeatEndDay);
    }
}

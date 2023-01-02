package dateCalculate.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * date : 2022.12.29 목요일
 * writer : SeoBoIn
 * request 반환값에 사용할 DTO 클래스 정의
 */
public class RetDto {
    // 반복일정 등록시 , 등록될 일정의 갯수가 30개 이상인 경우 , 30개까지 등록될수 있는 반복일정 종료일 값
    private String checkRepeatEndDay;
    // 반복 일정 종료일까지의 등록될 일정 count 갯수 반환
    private String checkRepeatEndDayCount;
    // 등록될 일정의 갯수가 30개 초과 유무 EX) 30개 초과인 경우 , Y 아닌경우 N
    private String beyondYn;
    // 일정 시작일 로부터의 10개 등록될 시 반복 종료일자
    private String minDate;
    // 일정 시작일 로부터의 30개 등록될 시 반복 종료일자
    private String maxDate;
    // 30개 날짜 데이터가 담겨있는 변수
    private List<LocalDate> thirtyDateList;
    // 요청값으로 들어온 반복종료일자 까지의 날짜 데이터가 담겨있는 변수
    private List<LocalDate> repeatDateList;


    /**
     * TODO 접근 제어자를 private 로 설정하여 , new 연산자를 통해 객체 생성을 불가하게 지정
     * 최초 객체 생성시 , List 변수는 new 연산자를 통해 null 값이 아닌 상태로 초기화
     */
    private RetDto() {
        // 초기값 설정
        this.thirtyDateList = new ArrayList<>();
        this.repeatDateList = new ArrayList<>();
    }

    /**
     * TODO Clear 메소드를 통해 , 해당 객체를 계속해서 재 활용할수 있도록 구성
     */
    public void dtoClear() {
        this.checkRepeatEndDay = "";
        this.checkRepeatEndDayCount = "";
        this.beyondYn = "";
        this.minDate = "";
        this.maxDate = "";
        this.thirtyDateList = new ArrayList<>();
        this.repeatDateList = new ArrayList<>();
    }

    // get , set checkRepeatEndDay
    public String getCheckRepeatEndDay() {
        return checkRepeatEndDay;
    }

    public void setCheckRepeatEndDay(String checkRepeatEndDay) {
        this.checkRepeatEndDay = checkRepeatEndDay;
    }

    // get , set checkRepeatEndDayCount
    public String getCheckRepeatEndDayCount() {
        return checkRepeatEndDayCount;
    }

    public void setCheckRepeatEndDayCount(String checkRepeatEndDayCount) {
        this.checkRepeatEndDayCount = checkRepeatEndDayCount;
    }

    // get , set beyondYn
    public String getBeyondYn() {
        return beyondYn;
    }

    public void setBeyondYn(String beyondYn) {
        this.beyondYn = beyondYn;
    }

    // get , set minDate
    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    // get , set maxDate
    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    // get , set thirtyDateList
    public List<LocalDate> getThirtyDateList() {
        return thirtyDateList;
    }

    public void setThirtyDateList(List<LocalDate> thirtyDateList) {
        this.thirtyDateList = thirtyDateList;
    }

    // get , set repeatDateList
    public List<LocalDate> getRepeatDateList() {
        return repeatDateList;
    }

    public void setRepeatDateList(List<LocalDate> repeatDateList) {
        this.repeatDateList = repeatDateList;
    }

    /*******************************************************************************************************************
     * 갹체를 생성하는 방법에는 하기 아래와 같은 방법이 존재한다
     * 1. new 연산자를 통한 객체 생성
     * 2. 정적 팩토리 메소드를 통한 객체 생성
     * 3. builder를 통한 객체 생성 */

    /**
     * TODO 이번 경우는 정적 팩토리 메소드를 통해 구성할 예정
     */
    public static RetDto createRetDto() {
        return new RetDto();
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
        return "RetDto{" +
                "checkRepeatEndDay='" + checkRepeatEndDay + '\'' +
                ", checkRepeatEndDayCount='" + checkRepeatEndDayCount + '\'' +
                ", beyondYn='" + beyondYn + '\'' +
                ", minDate='" + minDate + '\'' +
                ", maxDate='" + maxDate + '\'' +
                ", thirtyDateList=" + thirtyDateList +
                ", repeatDateList=" + repeatDateList +
                '}';
    }

    // equals 메소드 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetDto retDto = (RetDto) o;
        return checkRepeatEndDay.equals(retDto.checkRepeatEndDay)
                && checkRepeatEndDayCount.equals(retDto.checkRepeatEndDayCount)
                && beyondYn.equals(retDto.beyondYn)
                && minDate.equals(retDto.minDate)
                && maxDate.equals(retDto.maxDate)
                && thirtyDateList.equals(retDto.thirtyDateList)
                && repeatDateList.equals(retDto.repeatDateList);
    }

    // hashCode 메소드 재정의
    @Override
    public int hashCode() {
        return Objects.hash(checkRepeatEndDay, checkRepeatEndDayCount, beyondYn, minDate, maxDate, thirtyDateList, repeatDateList);
    }
}

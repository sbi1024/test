package dateCalculate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class CalculateUseTime {
    /**
     * 2022.12.23 서보인 작성
     * mainLogic 메소드 실행시 , 해당 메소드 안에 map 변수를 통해 -> 각각의 케이스 테스트 진행
     *
     * @param
     * @return void
     */
    public static void mainLogic() {
        // 요청값 테스트 20 -> 매일 반복 설정시 케이스
        Map<String, Object> requestMap20 = new HashMap<>();
        requestMap20.put("startDate", "202301051530"); // 일정 시작 일자
        requestMap20.put("endDate", "202301051530"); // 일정 종료 일자
        requestMap20.put("repeatType", "20"); // 반복 타입
        requestMap20.put("repeatByDay", ""); // 반복 요일
        requestMap20.put("repeatEndDay", "20230105");

        // 요청값 테스트 30 -> 매 주 마다 설정시 케이스
        Map<String, Object> requestMap30 = new HashMap<>();
        requestMap30.put("startDate", "202301311530"); // 일정 시작 일자
        requestMap30.put("endDate", "202301311530"); // 일정 종료 일자
        requestMap30.put("repeatType", "30"); // 반복 타입
        requestMap30.put("repeatByDay", "1,2,5,6"); // 반복 요일
        requestMap30.put("repeatEndDay", "20240330");

        // 요청값 테스트 40 -> 매 주 마다 설정시 케이스
        Map<String, Object> requestMap40 = new HashMap<>();
        requestMap40.put("startDate", "202212020900"); // 일정 시작 일자
        requestMap40.put("endDate", "202212021800"); // 일정 종료 일자
        requestMap40.put("repeatType", "40"); // 반복 타입
        requestMap40.put("repeatByDay", "1,2,5,6"); // 반복 요일
        requestMap40.put("repeatEndDay", "");

        // 요청값 테스트 50 -> 2주 마다 설정시 케이스
        Map<String, Object> requestMap50 = new HashMap<>();
        requestMap50.put("startDate", "202301311530"); // 일정 시작 일자
        requestMap50.put("endDate", "202301311530"); // 일정 종료 일자
        requestMap50.put("repeatType", "50"); // 반복 타입
        requestMap50.put("repeatByDay", "1,2,5,6"); // 반복 요일
        requestMap50.put("repeatEndDay", "20240330");

        // 요청값 테스트 60 -> 매월 X번째주 X요일 설정시 케이스
        Map<String, Object> requestMap60 = new HashMap<>();
        requestMap60.put("startDate", "202301311530"); // 일정 시작 일자
        requestMap60.put("endDate", "202301311530"); // 일정 종료 일자
        requestMap60.put("repeatType", "60"); // 반복 타입
        requestMap60.put("repeatByDay", ""); // 반복 요일
        requestMap60.put("repeatEndDay", "20240330");

        // 요청값 테스트 70 -> 매월 X일 설정시 케이스
        Map<String, Object> requestMap70 = new HashMap<>();
        requestMap70.put("startDate", "202301311530"); // 일정 시작 일자
        requestMap70.put("endDate", "202301311530"); // 일정 종료 일자
        requestMap70.put("repeatType", "70"); // 반복 타입
        requestMap70.put("repeatByDay", ""); // 반복 요일
        requestMap70.put("repeatEndDay", "20240330");

        // 요청값 테스트 71 -> 매월 마지막 주 X 요일 설정시 케이스
        Map<String, Object> requestMap71 = new HashMap<>();
        requestMap71.put("startDate", "202301051530"); // 일정 시작 일자
        requestMap71.put("endDate", "202301051530"); // 일정 종료 일자
        requestMap71.put("repeatType", "71"); // 반복 타입
        requestMap71.put("repeatByDay", ""); // 반복 요일
        requestMap71.put("repeatEndDay", "20240330");

        // 요청값 테스트 72 -> 매월 마지막 날 반복 설정시 케이스
        Map<String, Object> requestMap72 = new HashMap<>();
        requestMap72.put("startDate", "202301051530"); // 일정 시작 일자
        requestMap72.put("endDate", "202301051530"); // 일정 종료 일자
        requestMap72.put("repeatType", "72"); // 반복 타입
        requestMap72.put("repeatByDay", ""); // 반복 요일
        requestMap72.put("repeatEndDay", "20250330");


        // 요청값 테스트 80 -> 매년 반복 설정시 케이스
        Map<String, Object> requestMap80 = new HashMap<>();
        requestMap80.put("startDate", "202301051530"); // 일정 시작 일자
        requestMap80.put("endDate", "202301051530"); // 일정 종료 일자
        requestMap80.put("repeatType", "80"); // 반복 타입
        requestMap80.put("repeatByDay", ""); // 반복 요일
        requestMap80.put("repeatEndDay", "20250330");

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 20 실행)
        Map<String, Object> result20 = switchCalculate(requestMap20);
        printRequestAndResult(requestMap20, result20);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 30 실행)
        Map<String, Object> result30 = switchCalculate(requestMap30);
        printRequestAndResult(requestMap30, result30);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 40 실행)
        Map<String, Object> result40 = switchCalculate(requestMap40);
        printRequestAndResult(requestMap40, result40);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 50 실행)
        Map<String, Object> result50 = switchCalculate(requestMap50);
        printRequestAndResult(requestMap50, result50);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 60 실행)
        Map<String, Object> result60 = switchCalculate(requestMap60);
        printRequestAndResult(requestMap60, result60);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 70 실행)
        Map<String, Object> result70 = switchCalculate(requestMap70);
        printRequestAndResult(requestMap70, result70);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 71 실행)
        Map<String, Object> result71 = switchCalculate(requestMap71);
        printRequestAndResult(requestMap71, result71);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 72 실행)
        Map<String, Object> result72 = switchCalculate(requestMap72);
        printRequestAndResult(requestMap72, result72);

        // 반복 옵션값에 따라 일치하는 메소드가 호출됨 (요청값 테스트 80 실행)
        Map<String, Object> result80 = switchCalculate(requestMap80);
        printRequestAndResult(requestMap80, result80);
    }

    /**
     * 2022.12.23 서보인 작성
     * request , return 값 항목에 맞게 정리하여 출력
     *
     * @param result
     * @return void
     */

    public static void printRequestAndResult(Map<String, Object> request, Map<String, Object> result) {
        // request 변수에 할당된 키값들 전부 타입이 맞게 데이터 재 할당
        String startDate = String.valueOf(request.get("startDate"));
        String endDate = String.valueOf(request.get("endDate"));
        String repeatType = String.valueOf(request.get("repeatType"));
        String repeatByDay = String.valueOf(request.get("repeatByDay")).length() > 1 ?
                String.valueOf(request.get("repeatByDay")) : "요청값이 존재하지 않음";
        String repeatEndDay = String.valueOf(request.get("repeatEndDay"));

        // 포맷 변경
        LocalDate formatStartDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMddHHss"));
        LocalDate formatEndDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMddHHss"));

        // request 요청값 출력
        System.out.println("startDate = " + formatStartDate);
        System.out.println("endDate = " + formatEndDate);
        System.out.println("repeatType = " + repeatType);
        System.out.println("repeatByDay = " + repeatByDay);
        System.out.println("repeatEndDay = " + repeatEndDay);
        System.out.println("");

        // result 변수에 할당된 키값들 전부 타입에 맞게 데이터 재 할당
        List<LocalDate> thirtyDateList = (List<LocalDate>) result.get("thirtyDateList");
        List<LocalDate> repeatDateList = (List<LocalDate>) result.get("repeatDateList");
        String checkRepeatEndDay = String.valueOf(result.get("checkRepeatEndDay"));
        String checkRepeatEndDayCount = String.valueOf(result.get("checkRepeatEndDayCount"));
        String beyond_yn = String.valueOf(result.get("beyond_yn"));
        String maxDate = String.valueOf(result.get("maxDate"));
        String minDate = String.valueOf(result.get("minDate"));

        // result 변수의 키값 데이터 출력
        System.out.println("checkRepeatEndDay = " + checkRepeatEndDay);
        System.out.println("checkRepeatEndDayCount = " + checkRepeatEndDayCount);
        System.out.println("beyond_yn = " + beyond_yn);
        System.out.println("maxDate = " + maxDate);
        System.out.println("minDate = " + minDate);

        // 공백으로 라인 정렬
        System.out.println("");

        // 반복문을 통해 한줄씩 출력
        for (int i = 0; i < thirtyDateList.size(); i++) {
            System.out.println("thirtyDateList index : " + "(" + (i + 1) + ")" + " thirtyDateList data : " + thirtyDateList.get(i));
        }

        // 공백으로 라인 정렬
        System.out.println("");

        // 반복문을 통해 한줄씩 출력
        for (int i = 0; i < repeatDateList.size(); i++) {
            System.out.println("repeatDateList index : " + "(" + (i + 1) + ")" + " repeatDateList data : " + repeatDateList.get(i));
        }

        // 공백으로 라인 정렬
        System.out.println("");

        // 절취선 라인
        System.out.println("===============================================================================");
        System.out.println("");
    }

    /**
     * 2022.12.18 서보인 작성
     * 반복 종료일 값이 빈값으로 들어 오는 경우 , 반복 종료일 정책상의 최대 일자로 계산
     *
     * @param request
     * @return Map<String, Object>
     */
    public static String getRepeatEndDay(Map<String, Object> request) {
        // return 변수 선언
        String returnData = "";

        // request 에서 startDate 값과 , endDate 값을 추출 -> String 타입으로 변환
        String requestStartDate = String.valueOf(request.get("startDate"));

        // startDate 값에 대한 연 , 월 , 일 , 분 , 초 값 생성
        int startYear = Integer.parseInt(requestStartDate.substring(0, 4));
        int startMonth = Integer.parseInt(requestStartDate.substring(4, 6));
        int startDay = Integer.parseInt(requestStartDate.substring(6, 8));

        // startDate 값에 대한 LocalDate 값을 선언
        LocalDate startLocalDate = LocalDate.of(startYear, startMonth, startDay);

        // 반복 타입 추출
        String repeatType = String.valueOf(request.get("repeatType"));
        // 반복 종료일자 변수 선언
        LocalDate repeatEndLocalDate = null;
        switch (repeatType) {
            // 매일 반복
            case "20":
                // 매일
                repeatEndLocalDate = startLocalDate.plusMonths(1);
                break;
            // ???
            case "30":
                repeatEndLocalDate = startLocalDate.plusWeeks(12);
                break;
            // 매주
            case "40":
                repeatEndLocalDate = startLocalDate.plusWeeks(12);
                break;
            // 매주 2주 간격
            case "50":
                repeatEndLocalDate = startLocalDate.plusMonths(12);
                break;
            // 매월 X번째 X요일 반복
            case "60":
                repeatEndLocalDate = startLocalDate.plusMonths(12);
                break;
            // 매월 X일 반복
            case "70":
                repeatEndLocalDate = startLocalDate.plusMonths(12);
                break;
            // 매월 마지막 X요일
            case "71":
                repeatEndLocalDate = startLocalDate.plusMonths(12);
                break;
            // 매월 마지막 날
            case "72":
                repeatEndLocalDate = startLocalDate.plusMonths(12);
                break;
            // 매년 반복
            case "80":
                repeatEndLocalDate = startLocalDate.plusYears(5);
                break;
        }
        // repeatEndLocalDate 파싱 -> String 값으로 변환
        returnData = repeatEndLocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // return
        return returnData;
    }

    /**
     * 2022.12.18 서보인 작성
     * 요청값에 대한 switch case 문을 통해 , 분기처리 및 return 값 반환
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> switchCalculate(Map<String, Object> request) {
        // return 변수 선언
        Map<String, Object> returnData = new HashMap<>();
        // 반복 종료일자 값 확인
        if (request.get("repeatEndDay") == null || String.valueOf(request.get("repeatEndDay")).isEmpty()) {
            // 반복 종료일자가 없다면 정책상 종료일자 값 계산해서 넣어주기
            request.put("repeatEndDay", getRepeatEndDay(request));
        }
        // 반복 타입 추출
        String repeatType = String.valueOf(request.get("repeatType"));
        // switch case 문을 통한 , 반복 옵션별 메소드 호출
        switch (repeatType) {
            // 매일 반복
            case "20":
                returnData = everyDayCalculate(request);
                break;
            /** TODO
             * 기존 정책상으로는 추측상 , repeatType이 30인 경우 , 1주일중 월 ~ 금 에 해당하는 케이스만 선택되었을때 실행하는듯 하나
             * 실제 개발서버에서는 요청값으로 30을 쓰는 경우는 없고 , 40으로 보내고 있다. (기존 정책상 repeatType 40 : 주말 (토 , 일))
             * 요약 : ( repeatType = 30 ) == ( repeatType = 40 )
             */
            case "30":
                returnData = everyWeekXDayCalculate(request);
                break;
            // 매주
            case "40":
                returnData = everyWeekXDayCalculate(request);
                break;
            // 매주 2주 간격
            case "50":
                returnData = everyTwoWeekXDayCalculate(request);
                break;
            // 매월 X번째 X요일 반복
            case "60":
                returnData = everyMonthXnumberXdayCalculate(request);
                break;
            // 매월 X일 반복
            case "70":
                // returnData = everyMonthXDayCalculate(request);
                returnData = everyMonthXDayCalculateV2(request);
                break;
            // 매월 마지막 X요일
            case "71":
                returnData = everyMonthLastWeekXDayCalculate(request);
                break;
            // 매월 마지막 날
            case "72":
                returnData = everyMonthLastDayCalculate(request);
                break;
            // 매년 반복
            case "80":
                returnData = everyYearCalculate(request);
                break;
        }
        // return
        return returnData;
    }

    /**
     * repeatType : 매일 (20)
     * 2022.12.19 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 1번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지 더해야함 -> 무조건 30번을 돌아야함
        for (LocalDate i = startLocalDate; i.isBefore(startLocalDate.plusDays(30)); i = i.plusDays(1)) {
            thirtyDateList.add(i);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = startLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusDays(1)) {
            repeatDateList.add(i);
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 매주 - 요일 지정 (30 , 40) -> 추후에 나누어서 케이스 관리할지 생각해야함
     * 2022.12.23 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyWeekXDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate cloneStartLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 지정된 요일이 언제인지 확인 EX) 1 = 월요일 , 2 = 화요일 ... 7 = 일요일
        String[] repeatByDay = (String[]) ldtData.get("splitRepeatByDay");

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 반복문을 돌면서 확인할 값 변수 선언
        LocalDate localDate = null;

        // 1번 반복문 -> 30번 등록될 시점까지의 반복문 실행
        while (true) {
            // 30개 까지의 데이터만 담기에 , 30개 break
            if (thirtyDateList.size() == 30) {
                break;
            }
            // 1주마다 , 해당 주에 속하는 요일값 계산 반복문
            for (String day : repeatByDay) {
                // 해당 월의 첫날을 정수값으로 계산 EX ) 4 = 목요일 , 7 = 일요일
                int firstDayOfMonthNumberDay = startLocalDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
                // 해당 월의 몇째주 인지 계산
                int startLocalDateNumberWeek = startLocalDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
                // repeatByDay -> day 값 추출 EX) 1 , 2 , 3 , 4
                int dayNumber = Integer.parseInt(day);
                // 요청값의 요일 < 계산하고자 하는 월의 첫날 요일 -> 주차 계산이 달라짐
                if (dayNumber < firstDayOfMonthNumberDay) {
                    localDate = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek, DayOfWeek.of(dayNumber)));
                } else {
                    localDate = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek + 1, DayOfWeek.of(dayNumber)));
                }
                // 30개 까지의 데이터만 담기에 , 30개 break
                if (thirtyDateList.size() == 30) {
                    break;
                }
                // thirtyDateList add
                thirtyDateList.add(localDate);
            } // end for
            // 1주마다 반복하기에 , plus 1 week
            startLocalDate = startLocalDate.plusWeeks(1);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = cloneStartLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusWeeks(1)) {
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
            // 1주마다 , 해당 주에 속하는 요일값 계산 반복문
            for (String day : repeatByDay) {
                // 해당 월의 첫날을 정수값으로 계산 EX ) 4 = 목요일 , 7 = 일요일
                int firstDayOfMonthNumberDay = i.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
                // 해당 월의 몇째주 인지 계산
                int startLocalDateNumberWeek = i.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
                // repeatByDay -> day 값 추출 EX) 1 , 2 , 3 , 4
                int dayNumber = Integer.parseInt(day);
                // 요청값의 요일 < 계산하고자 하는 월의 첫날 요일 -> 주차 계산이 달라짐
                if (dayNumber < firstDayOfMonthNumberDay) {
                    localDate = i.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek, DayOfWeek.of(dayNumber)));
                } else {
                    localDate = i.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek + 1, DayOfWeek.of(dayNumber)));
                }
                // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
                if (repeatDateList.size() == 30) {
                    break;
                }
                // thirtyDateList add
                repeatDateList.add(localDate);
            } // end for2
        } // end for 1
        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 2주 - 요일 지정 (50)
     * 2022.12.22 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyTwoWeekXDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate cloneStartLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 지정된 요일이 언제인지 확인 EX) 1 = 월요일 , 2 = 화요일 ... 7 = 일요일
        String[] repeatByDay = (String[]) ldtData.get("splitRepeatByDay");

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 반복문을 돌면서 확인할 값 변수 선언
        LocalDate localDate = null;

        // 1번 반복문 -> 30번 등록될 시점까지의 반복문 실행
        while (true) {
            // 30개 까지의 데이터만 담기에 , 30개 break
            if (thirtyDateList.size() == 30) {
                break;
            }
            // 2주마다 , 해당 주에 속하는 요일값 계산 반복문
            for (String day : repeatByDay) {
                // 해당 월의 첫날을 정수값으로 계산 EX ) 4 = 목요일 , 7 = 일요일
                int firstDayOfMonthNumberDay = startLocalDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
                // 해당 월의 몇째주 인지 계산
                int startLocalDateNumberWeek = startLocalDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
                // repeatByDay -> day 값 추출 EX) 1 , 2 , 3 , 4
                int dayNumber = Integer.parseInt(day);
                // 요청값의 요일 < 계산하고자 하는 월의 첫날 요일 -> 주차 계산이 달라짐
                if (dayNumber < firstDayOfMonthNumberDay) {
                    localDate = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek, DayOfWeek.of(dayNumber)));
                } else {
                    localDate = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek + 1, DayOfWeek.of(dayNumber)));
                }
                // 30개 까지의 데이터만 담기에 , 30개 break
                if (thirtyDateList.size() == 30) {
                    break;
                }
                // thirtyDateList add
                thirtyDateList.add(localDate);
            } // end for
            // 2주마다 반복하기에 , plus 2 week
            startLocalDate = startLocalDate.plusWeeks(2);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = cloneStartLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusWeeks(2)) {
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
            // 2주마다 , 해당 주에 속하는 요일값 계산 반복문
            for (String day : repeatByDay) {
                // 해당 월의 첫날을 정수값으로 계산 EX ) 4 = 목요일 , 7 = 일요일
                int firstDayOfMonthNumberDay = i.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
                // 해당 월의 몇째주 인지 계산
                int startLocalDateNumberWeek = i.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
                // repeatByDay -> day 값 추출 EX) 1 , 2 , 3 , 4
                int dayNumber = Integer.parseInt(day);
                // 요청값의 요일 < 계산하고자 하는 월의 첫날 요일 -> 주차 계산이 달라짐
                if (dayNumber < firstDayOfMonthNumberDay) {
                    localDate = i.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek, DayOfWeek.of(dayNumber)));
                } else {
                    localDate = i.with(TemporalAdjusters.dayOfWeekInMonth(startLocalDateNumberWeek + 1, DayOfWeek.of(dayNumber)));
                }
                // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
                if (repeatDateList.size() == 30) {
                    break;
                }
                // thirtyDateList add
                repeatDateList.add(localDate);
            } // end for2
        } // end for 1
        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : (60) 매월 X번째 X요일 반복
     * 2022.12.20 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */

    public static Map<String, Object> everyMonthXnumberXdayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate cloneStartLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 요청값의 시작날짜가 몇번째 주인지 확인 ( EX) 1~5 )
        int weekNumber = startLocalDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        // 요청값의 시작날짜가 무슨 요일인지 확인 ( EX) MONDAY ~ SUNDAY )
        DayOfWeek dayOfWeek = startLocalDate.getDayOfWeek();

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // thirtyDateList 에 add 하기 위한 변수 선언
        LocalDate xNumberXday = null;

        // 1번 반복문 -> 30번 등록될 시점까지의 반복문 실행
        while (true) {
            if (thirtyDateList.size() == 30) {
                break;
            } else {
                // 달의 X번째 X요일 할당
                xNumberXday = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(weekNumber, dayOfWeek));
                // X번째 주 값 체크
                int checkWeekNumber = xNumberXday.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
                // 할당한 값이 정말 X번째 X요일인지 확인
                if (weekNumber != checkWeekNumber) {
                    //  시작일자의 주차와 , 반복문을 통해 얻어낸 xNumberXday 변수의 주차가 다르다면 , 전주의 값으로 계산
                    // -> 현재까지 테스트 진행중에 , 마지막 주 X요일 값을 계산시에 , 오차가 발생함
                    xNumberXday = startLocalDate.with(TemporalAdjusters.dayOfWeekInMonth(weekNumber - 1, dayOfWeek));
                }
            }
            // thirtyDateList add 
            thirtyDateList.add(xNumberXday);
            // 반복문을 위한 한달 더하기
            startLocalDate = startLocalDate.plusMonths(1);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = cloneStartLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusMonths(1)) {
            // 달의 X번째 X요일 할당
            xNumberXday = i.with(TemporalAdjusters.dayOfWeekInMonth(weekNumber, dayOfWeek));
            // X번째 주 값 체크
            int checkWeekNumber = xNumberXday.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
            // 할당한 값이 정말 X번째 X요일인지 확인
            if (weekNumber != checkWeekNumber) {
                // 시작일자의 주차와 , 반복문을 통해 얻어낸 xNumberXday 변수의 주차가 다르다면 , 전주의 값으로 계산
                // 현재까지 테스트 진행중에 , 마지막 주 X요일 값을 계산시에 , 오차가 발생함 !!!!!!!
                xNumberXday = i.with(TemporalAdjusters.dayOfWeekInMonth(weekNumber - 1, dayOfWeek));
            }
            // repeatDateList add
            repeatDateList.add(xNumberXday);

            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : (70) 매월 X일 반복
     * 2022.12.20 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyMonthXDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate cloneStartLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 일자 계산
        int dayOfMonth = startLocalDate.getDayOfMonth();

        // 1번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지 더해야함 -> 무조건 30번을 돌아야함
        for (LocalDate i = startLocalDate; i.isBefore(startLocalDate.plusMonths(30)); i = i.plusMonths(1)) {
            // 매월 x일
            LocalDate xDay = i.withDayOfMonth(dayOfMonth);
            thirtyDateList.add(xDay);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = startLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusMonths(1)) {
            repeatDateList.add(i.withDayOfMonth(dayOfMonth));
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    public static Map<String, Object> everyMonthXDayCalculateV2(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate cloneStartLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // test
        System.out.println("repeatEndLocalDate = " + repeatEndLocalDate);
        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 일자 계산 (시작 일자가 , 몇일 인지 확인 EX) startDate 가 22.01.31 인 경우 , condDayOfMonth : 31)
        int condDayOfMonth = startLocalDate.getDayOfMonth();

        // 매월 X 일 변수 할당 (재활용을 위해 , 선언)
        LocalDate everyMonthXDay = null;

        // 1번 반복문 -> 30개가 등록되었을 시점의 날짜 계산
        while (true) {
            if (thirtyDateList.size() == 30) {
                break;
            } else {
                // 마지막 날짜
                int monthLastDay = startLocalDate.withDayOfMonth(startLocalDate.lengthOfMonth()).getDayOfMonth();
                // 기준이 되는 , startDate의 일자 <= 다음 달 일자 조건을 만족하는 경우 , 날짜값 할당을 할 수 있음 ( EX) 2월 인 경우 31일이 존재 하지 않음 )
                if (condDayOfMonth <= monthLastDay) {
                    // 매월 x일
                    everyMonthXDay = startLocalDate.withDayOfMonth(condDayOfMonth);
                    // repeatDateList add
                    thirtyDateList.add(everyMonthXDay);
                }
                // 매 달마다 계산 이기에 plus 1 month
                startLocalDate = startLocalDate.plusMonths(1);
            }
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        while (true) {
            // 반복 종료일자 까지 , 반복문을 실행하고 , 해당 조건문을 만족하면 , break 문 실행
            if (cloneStartLocalDate.isAfter(repeatEndLocalDate)) {
                break;
            } else {
                // 마지막 날짜
                int monthLastDay = cloneStartLocalDate.withDayOfMonth(cloneStartLocalDate.lengthOfMonth()).getDayOfMonth();
                // 기준이 되는 , startDate의 일자 <= 다음 달 일자 조건을 만족하는 경우 , 날짜값 할당을 할 수 있음 ( EX) 2월 인 경우 31일이 존재 하지 않음 )
                if ((condDayOfMonth <= monthLastDay)) {
                    // 매월 x일
                    everyMonthXDay = cloneStartLocalDate.withDayOfMonth(condDayOfMonth);
                    // 부정 논리 연산자를 이용한 , 매월 X 일 <= repeatEndLocalDate 조건을 만족하는 경우만 , repeatDateList add 진행
                    if (!everyMonthXDay.isAfter(repeatEndLocalDate)) {
                        // repeatDateList add
                        repeatDateList.add(everyMonthXDay);
                    }
                }
                // 매 달마다 계산 이기에 plus 1 month
                cloneStartLocalDate = cloneStartLocalDate.plusMonths(1);
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 매월 마지막 주 X요일 (71)
     * 2022.12.19 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyMonthLastWeekXDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 요청값의 시작날짜가 무슨 요일인지 확인
        DayOfWeek dayOfWeek = startLocalDate.getDayOfWeek();

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 1번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지 더해야함 -> 무조건 30번을 돌아야함
        for (LocalDate i = startLocalDate; i.isBefore(startLocalDate.plusMonths(30)); i = i.plusMonths(1)) {
            thirtyDateList.add(i.with(TemporalAdjusters.lastInMonth(dayOfWeek)));
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = startLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusMonths(1)) {
            repeatDateList.add(i.with(TemporalAdjusters.lastInMonth(dayOfWeek)));
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 매월 마지막 날 (72)
     * 2022.12.19 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyMonthLastDayCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 1번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지 더해야함 -> 무조건 30번을 돌아야함
        for (LocalDate i = startLocalDate; i.isBefore(startLocalDate.plusMonths(30)); i = i.plusMonths(1)) {
            // 매월 마지막 날짜 계산
            thirtyDateList.add(i.withDayOfMonth(i.lengthOfMonth()));
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = startLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusMonths(1)) {
            repeatDateList.add(i.withDayOfMonth(i.lengthOfMonth()));
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 매년 (80)
     * 2022.12.19 서보인 작성
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> everyYearCalculate(Map<String, Object> request) {
        // 공통으로 사용할 requestConvertLdt 메소드 호출
        Map<String, Object> ldtData = requestConvertLdt(request);

        // ldtData -> key 값을 통해 각 변수에 데이터 할당
        LocalDate startLocalDate = LocalDate.parse(String.valueOf(ldtData.get("startLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate repeatEndLocalDate = LocalDate.parse(String.valueOf(ldtData.get("repeatLocalDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // callResult 메소드 파라미터에 사용할 변수 선언
        List<LocalDate> thirtyDateList = new ArrayList<>();
        List<LocalDate> repeatDateList = new ArrayList<>();

        // 1번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지 더해야함 -> 무조건 30번을 돌아야함
        for (LocalDate i = startLocalDate; i.isBefore(startLocalDate.plusYears(30)); i = i.plusYears(1)) {
            thirtyDateList.add(i);
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        for (LocalDate i = startLocalDate; (i.isBefore(repeatEndLocalDate) || i.isEqual(repeatEndLocalDate)); i = i.plusYears(1)) {
            repeatDateList.add(i);
            // 반복문이 너무 많이 돌 경우를 대비하여 , 31개인 경우 해당 반복문 탈출
            if (repeatDateList.size() == 30) {
                break;
            }
        }

        // return
        return callResult(thirtyDateList, repeatDateList);
    }

    public static Map<String, Object> requestConvertLdt(Map<String, Object> request) {
        // return 변수 선언
        Map<String, Object> returnData = new HashMap<>();

        // request 에서 startDate 값과 , endDate 값을 추출 -> String 타입으로 변환
        String requestStartDate = String.valueOf(request.get("startDate"));
        String requestEndDate = String.valueOf(request.get("endDate"));
        String requestRepeatEndDay = String.valueOf(request.get("repeatEndDay"));
        String requestRepeatByDay = String.valueOf(request.get("repeatByDay"));

        // 요일 지정하는 반복옵션 관련 케이스를 위한 문자열 자르기 실행
        String[] splitRepeatByDay = requestRepeatByDay.split(",");
        // splitRepeatByDay 길이값 계산
        int splitRepeatByDayLength = splitRepeatByDay.length;

        // startDate 값에 대한 연 , 월 , 일 , 분 , 초 값 생성
        int startYear = Integer.parseInt(requestStartDate.substring(0, 4));
        int startMonth = Integer.parseInt(requestStartDate.substring(4, 6));
        int startDay = Integer.parseInt(requestStartDate.substring(6, 8));
        int startMinute = Integer.parseInt(requestStartDate.substring(8, 10));
        int startSecond = Integer.parseInt(requestStartDate.substring(10, 12));

        // endDate 값에 대한 연 , 월 , 일 , 분 , 초 값 생성
        int endYear = Integer.parseInt(requestEndDate.substring(0, 4));
        int endMonth = Integer.parseInt(requestEndDate.substring(4, 6));
        int endDay = Integer.parseInt(requestEndDate.substring(6, 8));
        int endMinute = Integer.parseInt(requestEndDate.substring(8, 10));
        int endSecond = Integer.parseInt(requestEndDate.substring(10, 12));

        // repeatEndDay 값에 대한 연 , 월 , 일 값 생성
        int repeatEndYear = Integer.parseInt(requestRepeatEndDay.substring(0, 4));
        int repeatEndMonth = Integer.parseInt(requestRepeatEndDay.substring(4, 6));
        int repeatEndDay = Integer.parseInt(requestRepeatEndDay.substring(6, 8));

        // startDate 값에 대한 LocalDate , LocalTime 값을 선언
        LocalDate startLocalDate = LocalDate.of(startYear, startMonth, startDay);
        LocalTime startLocalTime = LocalTime.of(startMinute, startSecond);

        // endDate 값에 대한 LocalDate , LocalTime 값을 선언
        LocalDate endLocalDate = LocalDate.of(endYear, endMonth, endDay);
        LocalTime endLocalTime = LocalTime.of(endMinute, endSecond);

        // repeatEndDay 값에 대한 LocalDate 값을 선언
        LocalDate repeatLocalDate = LocalDate.of(repeatEndYear, repeatEndMonth, repeatEndDay);

        // return 변수에 위 로직에서 생성한 값 할당
        returnData.put("startLocalDate", startLocalDate);
        returnData.put("startLocalTime", startLocalTime);
        returnData.put("endLocalDate", endLocalDate);
        returnData.put("endLocalTime", endLocalTime);
        returnData.put("repeatLocalDate", repeatLocalDate);

        // 요일 지정하는 반복옵션 관련 케이스를 위해 , 길이값이 0 보다 크다면 , returnData 반환
        if (splitRepeatByDayLength > 1) {
            // 문자열로 받은 값 -> 배열값으로 변환하여 리턴
            returnData.put("splitRepeatByDay", splitRepeatByDay);
        }

        // return
        return returnData;
    }

    public static Map<String, Object> callResult(List<LocalDate> thirtyDateList, List<LocalDate> repeatDateList) {
        // return 변수 선언
        Map<String, Object> returnData = new HashMap<>();

        // 반복일정 등록시 , 등록될 일정의 갯수가 30개 이상인 경우 , 30개까지 등록될수 있는 반복일정 종료일 값
        String checkRepeatEndDay = "";
        // 반복 일정 종료일까지의 등록될 일정 count 갯수 반환
        String checkRepeatEndDayCount = "";
        // 등록될 일정의 갯수가 30개 초과 유무 EX) 30개 초과인 경우 , Y 아닌경우 N
        String beyond_yn = "";
        // 일정 시작일 로부터의 10개 등록될 시 반복 종료일자
        String minDate = "";
        // 일정 시작일 로부터의 30개 등록될 시 반복 종료일자
        String maxDate = "";

        // 리스트 변수의 길이 확인
        int thirtyDateSize = thirtyDateList.size();
        int repeatDateSize = repeatDateList.size();

        // 30개가 무조건 들어오는 리스트 < 반복 종료일자까지의 일자 리스트
        if (thirtyDateSize < repeatDateSize) {
            checkRepeatEndDay = String.valueOf(thirtyDateList.get(thirtyDateSize - 1));
            checkRepeatEndDayCount = String.valueOf(thirtyDateSize);
            beyond_yn = "Y";
        } else {
            checkRepeatEndDay = String.valueOf(repeatDateList.get(repeatDateSize - 1));
            checkRepeatEndDayCount = String.valueOf(repeatDateSize);
            beyond_yn = "N";
        }

        // minDate , maxDate 값 할당
        minDate = String.valueOf(thirtyDateList.get(9));
        maxDate = String.valueOf(thirtyDateList.get(29));

        // returnData 변수에 키값에 알맞는 값 할당
        returnData.put("checkRepeatEndDay", checkRepeatEndDay);
        returnData.put("checkRepeatEndDayCount", checkRepeatEndDayCount);
        returnData.put("beyond_yn", beyond_yn);
        returnData.put("minDate", minDate);
        returnData.put("maxDate", maxDate);

        // 계산된 데이터 원본 값 할당
        returnData.put("thirtyDateList", thirtyDateList);
        returnData.put("repeatDateList", repeatDateList);

        // return
        return returnData;
    }
}

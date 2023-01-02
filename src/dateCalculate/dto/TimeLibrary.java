package dateCalculate.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeLibrary {
    /**
     * * TODO line 1) 해당 클래스를 통해 , 날짜계산을 진행을 할때 , 최종적으로 사용되는 return 변수는 RetDto Class의 객체이다.
     *  TODO line 2) 그러므로 전역변수로 사용하여 , 메모리 관리 측면에서 효율성을 가져올수 있도록 구성한다.
     */
    private static RetDto returnData = RetDto.createRetDto();

    public static RetDto callingMethod(ReqDto request) {
        // 전역변수로 사용되는 returnData 값 계속해서 재활용을 위한 clear 진행
        returnData.dtoClear();
        // 파라미터 검증
        if (request == null) {
            // null 값인 경우 , null 로 반환
            return returnData;
        }
        // 요청값의 반복 종료 일자 값 체크 , 빈값 확인
        if (request.getRepeatEndDay().isEmpty() || request.getRepeatEndDay() == "") {
            // 반복 종료일자 값이 빈값이라면 , 정책상의 반복 종료일자 값을 set
            request.setRepeatEndDay(parsingString(getRepeatEndDay(request)));
        }
        // 타입별 계산 진행
        returnData = switchCalculate(request);
        // return 
        return returnData;
    }


    /**
     * 2023.01.02 서보인 작성
     * 반복 종료일 값이 빈값으로 들어 오는 경우 , 반복 종료일 정책상의 최대 일자로 계산
     *
     * @param request
     * @return returnData
     */
    public static LocalDate getRepeatEndDay(ReqDto request) {
        // return 변수 선언
        LocalDate returnData = null;
        // 반복 요일 값 선언
        String repeatType = request.getRepeatType();
        // parsingLocalDate 메소드를 통해 , LocalDate 타입으로 값 변환
        LocalDate startLocalDate = parsingLocalDate(request.getStartDate());

        switch (repeatType) {
            // 매일 반복
            case "20":
                // 매일
                returnData = startLocalDate.plusMonths(1);
                break;
            // ???
            case "30":
                returnData = startLocalDate.plusWeeks(12);
                break;
            // 매주
            case "40":
                returnData = startLocalDate.plusWeeks(12);
                break;
            // 매주 2주 간격
            case "50":
                returnData = startLocalDate.plusMonths(12);
                break;
            // 매월 X번째 X요일 반복
            case "60":
                returnData = startLocalDate.plusMonths(12);
                break;
            // 매월 X일 반복
            case "70":
                returnData = startLocalDate.plusMonths(12);
                break;
            // 매월 마지막 X요일
            case "71":
                returnData = startLocalDate.plusMonths(12);
                break;
            // 매월 마지막 날
            case "72":
                returnData = startLocalDate.plusMonths(12);
                break;
            // 매년 반복
            case "80":
                returnData = startLocalDate.plusYears(5);
                break;
        }
        // return
        return returnData;
    }

    /**
     * 2023.01.02 서보인 작성
     * 요청값에 대한 switch case 문을 통해 , 분기처리 및 return 값 반환
     *
     * @param request
     * @return returnData
     */
    public static RetDto switchCalculate(ReqDto request) {
        // 반복타입 추출
        String repeatType = request.getRepeatType();

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
                break;
            // 매주
            case "40":
                break;
            // 매주 2주 간격
            case "50":
                break;
            // 매월 X번째 X요일 반복
            case "60":
                break;
            // 매월 X일 반복
            case "70":
                break;
            // 매월 마지막 X요일
            case "71":
                break;
            // 매월 마지막 날
            case "72":
                break;
            // 매년 반복
            case "80":
                returnData = everyYearCalculate(request);
                break;
        }
        // return -> returnData
        return returnData;
    }

    public static String[] splitRepeatDay(String repeatByDay) {
        String[] returnData = null;

        // 1. null 값 체크
        // 2. 빈값인지 체크
        if (repeatByDay == null || repeatByDay.isEmpty()) {
            return returnData;
        }

        // split 메소도를 통해 문자열 자르기 -> EX) "1,2,3,4,5" 이런식으로 요청값이 들어오기에
        // 자르기 진행 후 , 배열로 데이터 변환
        try {
            returnData = repeatByDay.split(",");
        } catch (Exception e) {
            /** TODO log 도입 건 확인 필요 */
            e.printStackTrace();
            e.getMessage();
            // 파싱 에러시 null 값으로 리턴
            return returnData;
        }

        return returnData;
    }

    /**
     * 요청값의 문자열을 , yyyyMMdd 형식의 LocalDate 타입의 데이터로 반환해 주는 메소드
     * 2023.01.02 서보인 작성
     *
     * @param localDateStr
     * @return returnData
     */
    public static LocalDate parsingLocalDate(String localDateStr) {
        // return 변수 선언
        LocalDate returnData = null;

        // 1. null 값 체크
        // 2. 빈값인지 체크 조건을 만족하지 못한 경우 null 값의 returnData 리턴
        if (localDateStr == null || localDateStr.isEmpty()) {
            return returnData;
        }

        // 문자열 자르기
        localDateStr = localDateStr.substring(0, 8);

        // 데이터 파싱시에 , 문제가 발생 할 확률이 높은 메소드 이기에 , try catch 문으로 구성
        try {
            // LocalDate ->  String 값으로 변환
            returnData = LocalDate.parse(localDateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            /** TODO log 도입 건 확인 필요 */
            e.printStackTrace();
            e.getMessage();

            // 파싱 에러시 null 값으로 리턴
            return returnData;
        }

        // return returnData
        return returnData;
    }

    /**
     * 요청값의 LocalDate , yyyyMMdd 형식의 String 타입의 데이터로 반환해 주는 메소드
     * 2023.01.02 서보인 작성
     *
     * @param strLocalDate
     * @return returnData
     */
    public static String parsingString(LocalDate strLocalDate) {
        // return 변수 선언
        String returnData = null;

        // null 값 체크
        if (strLocalDate == null) {
            return returnData;
        }

        // 데이터 파싱시에 , 문제가 발생 할 확률이 높은 메소드 이기에 , try catch 문으로 구성
        try {
            // String -> LocalDate 값으로 변환
            returnData = strLocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            /** TODO log 도입 건 확인 필요 */
            e.printStackTrace();
            e.getMessage();

            // 파싱 에러시 null 값으로 리턴
            return returnData;
        }

        // return
        return returnData;
    }

    /**
     * repeatType : 매일 (20)
     * 2023.01.02 서보인 작성
     *
     * @param request
     * @return returnData
     */
    public static RetDto everyDayCalculate(ReqDto request) {
        // 1. 시작 날짜
        String startDate = request.getStartDate();
        // 2. 종료 날짜
        String endDate = request.getEndDate();
        // 3. 반복 요일 splitRepeatDay 메소드를 통해 데이터 변환 진행
        String[] repeatByDay = splitRepeatDay(request.getRepeatByDay());
        // 4. 반복 종료 일자
        String repeatEndDay = request.getRepeatEndDay();

        // 시작날짜 LocalDate 타입 변수 선언
        LocalDate startLocalDate = parsingLocalDate(startDate);
        // 클론 시작날짜 LocalDate 타입 변수 선언
        LocalDate cloneStartLocalDate = parsingLocalDate(startDate);
        // 반복 종료 날짜 LocalDate 타입 변수 선언
        LocalDate repeatEndLocalDate = parsingLocalDate(repeatEndDay);

        List<LocalDate> thirtyDateList = returnData.getThirtyDateList();
        List<LocalDate> repeatDateList = returnData.getRepeatDateList();

        // 1번 반복문 -> 30번 등록될 시점까지의 반복문 실행
        while (true) {
            // 30개 까지의 데이터만 담기에 , 30개 break
            if (thirtyDateList.size() == 30) {
                break;
            } else {
                thirtyDateList.add(startLocalDate);
                startLocalDate = startLocalDate.plusDays(1);
            }
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        while (true) {
            // 30개 까지의 데이터만 담기에 , 30개 break
            if (cloneStartLocalDate.isAfter(repeatEndLocalDate)) {
                break;
            } else {
                repeatDateList.add(cloneStartLocalDate);
                cloneStartLocalDate = cloneStartLocalDate.plusDays(1);
            }
        }

        // 최종 결과값 반환을 위한 계산 진행 return -> returnData
        return callResult(thirtyDateList, repeatDateList);
    }

    /**
     * repeatType : 매월 마지막 날 (72)
     * 2023.01.02 서보인 작성
     *
     * @param request
     * @return returnData
     */
    public static RetDto everyMonthLastDayCalculate(ReqDto request) {
        return returnData;
    }

    /**
     * repeatType : 매일 (80)
     * 2023.01.02 서보인 작성
     *
     * @param request
     * @return returnData
     */
    public static RetDto everyYearCalculate(ReqDto request) {
        // 1. 시작 날짜
        String startDate = request.getStartDate();
        // 2. 종료 날짜
        String endDate = request.getEndDate();
        // 3. 반복 요일 splitRepeatDay 메소드를 통해 데이터 변환 진행
        String[] repeatByDay = splitRepeatDay(request.getRepeatByDay());
        // 4. 반복 종료 일자
        String repeatEndDay = request.getRepeatEndDay();

        // 시작날짜 LocalDate 타입 변수 선언
        LocalDate startLocalDate = parsingLocalDate(startDate);
        // 클론 시작날짜 LocalDate 타입 변수 선언
        LocalDate cloneStartLocalDate = parsingLocalDate(startDate);
        // 반복 종료 날짜 LocalDate 타입 변수 선언
        LocalDate repeatEndLocalDate = parsingLocalDate(repeatEndDay);

        List<LocalDate> thirtyDateList = returnData.getThirtyDateList();
        List<LocalDate> repeatDateList = returnData.getRepeatDateList();

        // 일자 계산 (시작 일자가 , 몇일 인지 확인 EX) startDate 가 22.01.31 인 경우 , condDayOfMonth : 31)
        int condDayOfMonth = startLocalDate.getDayOfMonth();

        // 매년 변수 할당 (재활용을 위해 , 선언)
        LocalDate everyYearDay = null;

        // 1번 반복문 -> 30개가 등록되었을 시점의 날짜 계산
        while (true) {
            if (thirtyDateList.size() == 30) {
                // 조건문 만족시 , 반복문 탈출
                break;
            } else {
                // 마지막 날짜
                int monthLastDay = startLocalDate.withDayOfMonth(startLocalDate.lengthOfMonth()).getDayOfMonth();
                // 기준이 되는 , startDate의 일자 <= 다음 달 일자 조건을 만족하는 경우 , 날짜값 할당을 할 수 있음 ( EX) 2월 인 경우 31일이 존재 하지 않음 )
                if (condDayOfMonth <= monthLastDay) {
                    // 매년
                    everyYearDay = startLocalDate.plusYears(1);
                    // repeatDateList add
                    thirtyDateList.add(everyYearDay);
                }
                // 매 달마다 계산 이기에 plus 1 years
                startLocalDate = startLocalDate.plusYears(1);
            }
        }

        // 2번 반복문 -> 반복문을 통해 시작일자가 , 반복 종료일자까지만 루프문을 돔
        while (true) {
            // 반복 종료일자 까지 , 반복문을 실행하고 , 해당 조건문을 만족하면 , break 문 실행
            if (cloneStartLocalDate.isAfter(repeatEndLocalDate)) {
                // 조건문 만족시 , 반복문 탈출
                break;
            } else {
                // 마지막 날짜
                int monthLastDay = cloneStartLocalDate.withDayOfMonth(cloneStartLocalDate.lengthOfMonth()).getDayOfMonth();
                // 기준이 되는 , startDate의 일자 <= 다음 달 일자 조건을 만족하는 경우 , 날짜값 할당을 할 수 있음 ( EX) 2월 인 경우 31일이 존재 하지 않음 )
                if ((condDayOfMonth <= monthLastDay)) {
                    // 매월 x일
                    everyYearDay = cloneStartLocalDate.withDayOfMonth(condDayOfMonth);
                    // 부정 논리 연산자를 이용한 , 매월 X 일 <= repeatEndLocalDate 조건을 만족하는 경우만 , repeatDateList add 진행
                    if (!everyYearDay.isAfter(repeatEndLocalDate)) {
                        // repeatDateList add
                        repeatDateList.add(everyYearDay);
                    }
                }
                // 매 달마다 계산 이기에 plus 1 years
                cloneStartLocalDate = cloneStartLocalDate.plusYears(1);
            }
        }
        // return
        return callResult(thirtyDateList, repeatDateList);

    }

    private static RetDto callResult(List<LocalDate> thirtyDateList, List<LocalDate> repeatDateList) {
        // 1. 파라미터 null 값 체크
        // 2. 파라미터 size () < 1
        if (thirtyDateList == null || repeatDateList == null ||
                thirtyDateList.size() < 1 || thirtyDateList.size() < 1) {
            return returnData;
        }

        // 리스트 변수의 길이 확인
        int thirtyDateSize = thirtyDateList.size();
        int repeatDateSize = repeatDateList.size();

        // 30개가 무조건 들어오는 리스트 < 반복 종료일자까지의 일자 리스트
        if (thirtyDateSize < repeatDateSize) {
            returnData.setCheckRepeatEndDay(String.valueOf(thirtyDateList.get(thirtyDateSize - 1)));
            returnData.setCheckRepeatEndDayCount(String.valueOf(thirtyDateSize));
            returnData.setBeyondYn("Y");
        } else {
            returnData.setCheckRepeatEndDay(String.valueOf(repeatDateList.get(repeatDateSize - 1)));
            returnData.setCheckRepeatEndDayCount(String.valueOf(repeatDateSize));
            returnData.setBeyondYn("N");
        }

        // minDate , maxDate 값 할당
        returnData.setMinDate(String.valueOf(thirtyDateList.get(9)));
        returnData.setMaxDate(String.valueOf(thirtyDateList.get(29)));

        // 최종 반환값 셋팅
        returnData.setThirtyDateList(thirtyDateList);
        returnData.setRepeatDateList(repeatDateList);

        // return
        return returnData;
    }
}

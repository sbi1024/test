package order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderHelper {
    /**
     * 2022.12.12 서보인 작성
     * method 명 : orderSchList
     *
     * @param schList
     * @return returnData
     */
    public static List<Map<String, Object>> orderSchList(List<Map<String, Object>> schList) {
        // return 변수 선언
        List<Map<String, Object>> returnData = new ArrayList<>();

        // 매개변수 값이 null 이거나 , 리스트의 길이가 0인 경우 return 하여 해당 메소드 종료
        if (schList == null || schList.size() == 0) {
            return returnData;
        }

        // 0_1. 매개변수로 받은 schList 값에 대한 grouping 처리
        // 조건 1. 일정 종료일자와 일정 시작일자가 같지않다 = 1일 이상의 일정이다
        // 조건 2. 종일 여부가 Y 인 경우
        // 결과 1. 조건1을 만족하며 , 조건2를 만족한다 (true , true)
        // 결과 2. 조건1을 만족하며 , 조건2를 만족하지 않는다 (true , false)
        Map<Boolean, Map<Boolean, List<Map<String, Object>>>> anotherDayAndallDay = schList.stream()
                .collect(Collectors.groupingBy(
                        o -> !(String.valueOf(o.get("endDate")).substring(0, 8).equals(String.valueOf(o.get("startDate")).substring(0, 8)))
                        , Collectors.groupingBy(o -> String.valueOf(o.get("allDayYn")).equals("Y"))));

        // 0_2. 매개변수로 받은 schList 값에 대한 grouping 처리
        // 조건 1. 일정 종료일자와 일정 시작일자가 같다 = 1일 이상의 일정이 아니다
        // 조건 2. 일정 마스터 시퀀스와 , 일정 서브 시퀀스의 값이 일치하지 않는다 = 반복일정이다.
        // 조건 3. 종일 여부가 Y인 경우
        // 결과 1. 조건1,2을 만족하며 , 조건3를 만족한다 (true , true)
        // 결과 2. 조건1,2을 만족하며 , 조건3를 만족하지 않는다 (true , false)
        Map<Boolean, Map<Boolean, List<Map<String, Object>>>> repeatDayAndallDay = schList.stream()
                .collect(Collectors.groupingBy(
                        o -> (String.valueOf(o.get("endDate")).substring(0, 8).equals(String.valueOf(o.get("startDate")).substring(0, 8))
                                && !String.valueOf(o.get("schmSeq")).equals(o.get("schSeq")))
                        , Collectors.groupingBy(o -> String.valueOf(o.get("allDayYn")).equals("Y"))));

        // 0_3. 매개변수로 받은 schList 값에 대한 grouping 처리
        // 조건 1. 일정 종료일자와 일정 시작일자가 같다 = 1일 이상의 일정이 아니다
        // 조건 2. 일정 마스터 시퀀스와 , 일정 서브 시퀀스의 값이 일치한다 = 단일 일정이다.
        // 조건 3. 종일 여부가 Y인 경우
        // 결과 1. 조건1,2을 만족하며 , 조건3를 만족한다 (true , true)
        // 결과 2. 조건1,2을 만족하며 , 조건3를 만족하지 않는다 (true , false)
        Map<Boolean, Map<Boolean, List<Map<String, Object>>>> oneDayAndallDay = schList.stream()
                .collect(Collectors.groupingBy(
                        o -> (String.valueOf(o.get("endDate")).substring(0, 8).equals(String.valueOf(o.get("startDate")).substring(0, 8))
                                && String.valueOf(o.get("schmSeq")).equals(o.get("schSeq")))
                        , Collectors.groupingBy(o -> String.valueOf(o.get("allDayYn")).equals("Y"))));

        // 1. 1일 이상의 일정이면서 , 종일 여부가 설정되어 있는 값
        List<Map<String, Object>> maps1 = null;
        if (anotherDayAndallDay.containsKey(true) && anotherDayAndallDay.get(true).containsKey(true)) {
            maps1 = anotherDayAndallDay.get(true).get(true);
        }
        // 2. 1일 이상의 일정이면서 , 종일 여부가 설정되어 있지 않은 값
        List<Map<String, Object>> maps2 = null;
        if (anotherDayAndallDay.containsKey(true) && anotherDayAndallDay.get(true).containsKey(false)) {
            maps2 = anotherDayAndallDay.get(true).get(false);
        }
        // 3. 반복 일정이면서 , 종일 여부가 설정되어 있는 값
        List<Map<String, Object>> maps3 = null;
        if (repeatDayAndallDay.containsKey(true) && repeatDayAndallDay.get(true).containsKey(true)) {
            maps3 = repeatDayAndallDay.get(true).get(true);
        }
        // 4. 반복 일정이면서 , 종일 여부가 설정되어 있지 않은 값
        List<Map<String, Object>> maps4 = null;
        if (repeatDayAndallDay.containsKey(true) && repeatDayAndallDay.get(true).containsKey(false)) {
            maps4 = repeatDayAndallDay.get(true).get(false);
        }
        // 5. 1일 일정 이면서 , 종일 여부가 설정되어 있는 값
        List<Map<String, Object>> maps5 = null;
        if (oneDayAndallDay.containsKey(true) && oneDayAndallDay.get(true).containsKey(true)) {
            maps5 = oneDayAndallDay.get(true).get(true);
        }
        // 6. 1일 일정 이면서 , 종일 여부가 설정되어 있지 않은 값
        List<Map<String, Object>> maps6 = null;
        if (oneDayAndallDay.containsKey(true) && oneDayAndallDay.get(true).containsKey(false)) {
            maps6 = oneDayAndallDay.get(true).get(false);
        }

        // 가장 빠른 시작 날짜 , 가장 빠른 종료 일자 , 제목 텍스트 오름차순 (1번 정렬법) static method (firstOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss1 = firstOrderData(maps1);
        if (mapss1 != null || mapss1.size() == 0) {
            returnData.addAll(mapss1);
        }
        // 가장 빠른 시작 날짜 시간 , 가장 빠른 종료 날짜 시간 , 제목 텍스트 오름차순 (2번 정렬법) static method (secondOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss2 = secondOrderData(maps2);
        if (mapss2 != null || mapss2.size() == 0) {
            returnData.addAll(mapss2);
        }
        // 가장 빠른 시작 날짜 , 가장 빠른 종료 일자 , 제목 텍스트 오름차순 (1번 정렬법) static method (firstOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss3 = firstOrderData(maps3);
        if (mapss3 != null || mapss3.size() == 0) {
            returnData.addAll(mapss3);
        }
        // 가장 빠른 시작 날짜 시간 , 가장 빠른 종료 날짜 시간 , 제목 텍스트 오름차순 (2번 정렬법) static method (secondOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss4 = secondOrderData(maps4);
        if (mapss4 != null || mapss4.size() == 0) {
            returnData.addAll(mapss4);
        }
        // 가장 빠른 시작 날짜 , 가장 빠른 종료 일자 , 제목 텍스트 오름차순 (1번 정렬법) static method (firstOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss5 = firstOrderData(maps5);
        if (mapss5 != null || mapss5.size() == 0) {
            returnData.addAll(mapss5);
        }
        // 가장 빠른 시작 날짜 시간 , 가장 빠른 종료 날짜 시간 , 제목 텍스트 오름차순 (2번 정렬법) static method (secondOrderData) 를 통해 정렬
        List<Map<String, Object>> mapss6 = secondOrderData(maps6);
        if (mapss6 != null || mapss6.size() == 0) {
            returnData.addAll(mapss6);
        }

        return returnData;
    }

    /**
     * 2022.12.12 서보인 작성
     * method 명 : firstOrderData
     *
     * @param schList
     * @return returnSchList
     */
    public static List<Map<String, Object>> firstOrderData(List<Map<String, Object>> schList) {
        // return 변수 선언
        List<Map<String, Object>> returnSchList = new ArrayList<>();

        // null 체크 진행
        if (schList == null || schList.size() == 0) {
            return returnSchList;
        }

        // 정렬 진행
        // 1. 가장 빠른 시작 일자
        // 2. 가장 빠른 종료 일자
        // 3. 제목 텍스트 오름차순
        returnSchList = schList.stream()
                .sorted((o1, o2) -> {
                    long startDate1 = Long.parseLong(String.valueOf(o1.get("startDate")).substring(0, 8));
                    long startDate2 = Long.parseLong(String.valueOf(o2.get("startDate")).substring(0, 8));
                    if (startDate1 < startDate2) {
                        return -1;
                    } else if (startDate1 == startDate2) {
                        long endDate1 = Long.parseLong(String.valueOf(o1.get("endDate")));
                        long endDate2 = Long.parseLong(String.valueOf(o2.get("endDate")));
                        if (endDate1 < endDate2) {
                            return -1;
                        } else if (endDate1 == endDate2) {
                            String schTitle1 = String.valueOf(o1.get("schTitle"));
                            String schTitle2 = String.valueOf(o2.get("schTitle"));
                            return schTitle1.compareTo(schTitle2);
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                }).collect(Collectors.toList());
        // return
        return returnSchList;
    }

    /**
     * 2022.12.12 서보인 작성
     * method 명 : secondOrderData
     *
     * @param schList
     * @return returnSchList
     */
    public static List<Map<String, Object>> secondOrderData(List<Map<String, Object>> schList) {
        // return 변수 선언
        List<Map<String, Object>> returnSchList = new ArrayList<>();

        // null 체크 진행
        if (schList == null || schList.size() == 0) {
            return returnSchList;
        }

        // 정렬 진행
        // 1. 가장 빠른 시작 날짜 시간
        // 2. 가장 빠른 종료 날짜 시간
        // 3. 제목 텍스트 오름차순
        returnSchList = schList.stream()
                .sorted((o1, o2) -> {
                    long startDate1 = Long.parseLong(String.valueOf(o1.get("startDate")));
                    long startDate2 = Long.parseLong(String.valueOf(o2.get("startDate")));
                    if (startDate1 < startDate2) {
                        return -1;
                    } else if (startDate1 == startDate2) {
                        long endDate1 = Long.parseLong(String.valueOf(o1.get("endDate")));
                        long endDate2 = Long.parseLong(String.valueOf(o2.get("endDate")));
                        if (endDate1 < endDate2) {
                            return -1;
                        } else if (endDate1 == endDate2) {
                            String schTitle1 = String.valueOf(o1.get("schTitle"));
                            String schTitle2 = String.valueOf(o2.get("schTitle"));
                            return schTitle1.compareTo(schTitle2);
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                }).collect(Collectors.toList());
        // return
        return returnSchList;
    }
}

package dateCalculate.dto;

public class CalculateUseTimeByDto {
    public static void mainLogic(){
        /** ========================================================================================================== */
        // 요청값 테스트 20 -> 매일 반복 설정시 케이스
        ReqDto reqDto20 = ReqDto.createReqDto();
        reqDto20.setStartDate("202301051530");
        reqDto20.setEndDate("202301051530");
        reqDto20.setRepeatByDay("");
        reqDto20.setRepeatEndDay("20230205");
        reqDto20.setRepeatType("20");
        System.out.println("reqDto20 => " + System.lineSeparator() + reqDto20);

        // callingMethod 를 통한 repeatType 20 인 경우의 결과 반환값을 확인
        RetDto retDto20 = TimeLibrary.createTimeLibrary().callingMethod(reqDto20);
        // retDto 값 확인진행
        System.out.println("retDto20 => " + System.lineSeparator() + retDto20);
        System.out.println("===========================================================================================");

        /** ========================================================================================================== */
        // 요청값 테스트 72 -> 매월 마지막 날 케이스
        ReqDto reqDto72 = ReqDto.createReqDto();
        reqDto72.setStartDate("202301051530");
        reqDto72.setEndDate("202301051530");
        reqDto72.setRepeatByDay("");
        reqDto72.setRepeatEndDay("20230205");
        reqDto72.setRepeatType("72");

        // callingMethod 를 통한 repeatType 72 인 경우의 결과 반환값을 확인
        RetDto retDto72 = TimeLibrary.createTimeLibrary().callingMethod(reqDto72);
        // retDto 값 확인진행
        // System.out.println("retDto72 => " + System.lineSeparator() + retDto72);

        /** ========================================================================================================== */
        // 요청값 테스트 80 -> 매년 반복 설정시 케이스
        ReqDto reqDto80 = ReqDto.createReqDto();
        reqDto80.setStartDate("202307311530");
        reqDto80.setEndDate("202307311530");
        reqDto80.setRepeatByDay("");
        reqDto80.setRepeatEndDay("20300205");
        reqDto80.setRepeatType("80");
        System.out.println("reqDto80 => " + System.lineSeparator() + reqDto80);

        // callingMethod 를 통한 repeatType 80 인 경우의 결과 반환값을 확인
        RetDto retDto80 = TimeLibrary.createTimeLibrary().callingMethod(reqDto80);
        // retDto 값 확인진행
        System.out.println("retDto80 => " + System.lineSeparator() + retDto80);
        System.out.println("===========================================================================================");
    }
}

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

        // callingMethod 를 통한 repeatType 20 인 경우의 결과 반환값을 확인
        RetDto retDto20 = TimeLibrary.callingMethod(reqDto20);
        // retDto 값 확인진행
        System.out.println("retDto20 = " + retDto20);

        /** ========================================================================================================== */






        /** ========================================================================================================== */
        // 요청값 테스트 80 -> 매일 반복 설정시 케이스
        ReqDto reqDto80 = ReqDto.createReqDto();
        reqDto80.setStartDate("202301051530");
        reqDto80.setEndDate("202301051530");
        reqDto80.setRepeatByDay("");
        reqDto80.setRepeatEndDay("20300205");
        reqDto80.setRepeatType("80");

        // callingMethod 를 통한 repeatType 20 인 경우의 결과 반환값을 확인
        RetDto retDto80 = TimeLibrary.callingMethod(reqDto80);
        // retDto 값 확인진행
        System.out.println("retDto80 = " + retDto80);
    }
}

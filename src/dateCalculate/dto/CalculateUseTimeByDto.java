package dateCalculate.dto;

public class CalculateUseTimeByDto {
    public static void mainLogic(){
        // 요청값 테스트 20 -> 매일 반복 설정시 케이스
        ReqDto reqDto20 = ReqDto.createReqDto();
        reqDto20.setStartDate("202301051530");
        reqDto20.setEndDate("202301051530");
        reqDto20.setRepeatByDay("20");
        reqDto20.setRepeatEndDay("20230205");
        reqDto20.setRepeatType("20");

        RetDto retDto = TimeLibrary.switchCalculate(reqDto20);
        System.out.println("retDto = " + retDto);

    }
}

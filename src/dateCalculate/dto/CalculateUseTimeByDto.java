package dateCalculate.dto;

public class CalculateUseTimeByDto {
    public static void mainLogic(){
        /** 20 ========================================================================================================== */
        // 요청값 테스트 20 -> 매일 반복 설정시 케이스
        ReqDto reqDto20 = ReqDto.createReqDto();
        reqDto20.setStartDate("202301051530");
        reqDto20.setEndDate("202301051530");
        reqDto20.setRepeatByDay("");
        reqDto20.setRepeatEndDay("20230205");
        reqDto20.setRepeatType("20");
        // System.out.println("reqDto20 => " + System.lineSeparator() + reqDto20);

        // callingMethod 를 통한 repeatType 20 인 경우의 결과 반환값을 확인
        // RetDto retDto20 = TimeLibrary.createTimeLibrary().callingMethod(reqDto20);
        // retDto 값 확인진행
        // System.out.println("retDto20 => " + System.lineSeparator() + retDto20);
        // System.out.println("===========================================================================================");

        /** 30 ========================================================================================================== */
        // 요청값 테스트 30 -> 매주 요일 지정 케이스
        ReqDto reqDto30 = ReqDto.createReqDto();
        reqDto30.setStartDate("202301051530");
        reqDto30.setEndDate("202301051530");
        reqDto30.setRepeatByDay("1,2,5,6");
        reqDto30.setRepeatEndDay("20230205");
        reqDto30.setRepeatType("30");
        // System.out.println("reqDto30 => " + System.lineSeparator() + reqDto30);

        // callingMethod 를 통한 repeatType 30 인 경우의 결과 반환값을 확인
        // RetDto retDto30 = TimeLibrary.createTimeLibrary().callingMethod(reqDto30);
        // retDto 값 확인진행
        // System.out.println("retDto30 => " + System.lineSeparator() + retDto30);
        // System.out.println("===========================================================================================");

        /** 40 ========================================================================================================== */
        // 요청값 테스트 40 -> 1주마다 요일 지정 케이스
        ReqDto reqDto40 = ReqDto.createReqDto();
        reqDto40.setStartDate("202301011530");
        reqDto40.setEndDate("202301011530");
        reqDto40.setRepeatByDay("1,2,5,6");
        reqDto40.setRepeatEndDay("20230205");
        reqDto40.setRepeatType("40");
        // System.out.println("reqDto40 => " + System.lineSeparator() + reqDto40);

        // callingMethod 를 통한 repeatType 40 인 경우의 결과 반환값을 확인
        RetDto retDto40 = TimeLibrary.createTimeLibrary().callingMethod(reqDto40);
        // retDto 값 확인진행
        System.out.println("retDto40 => " + System.lineSeparator() + retDto40);
        System.out.println("===========================================================================================");


        /** 50 ========================================================================================================== */
        // 요청값 테스트 50 -> 2주마다 요일 지정 케이스
        ReqDto reqDto50 = ReqDto.createReqDto();
        reqDto50.setStartDate("202301311530");
        reqDto50.setEndDate("202301311530");
        reqDto50.setRepeatByDay("1,2,5,6,7");
        reqDto50.setRepeatEndDay("20230205");
        reqDto50.setRepeatType("50");
        // System.out.println("reqDto50 => " + System.lineSeparator() + reqDto50);

        // callingMethod 를 통한 repeatType 50 인 경우의 결과 반환값을 확인
        // RetDto retDto50 = TimeLibrary.createTimeLibrary().callingMethod(reqDto50);
        // retDto 값 확인진행
        // System.out.println("retDto50 => " + System.lineSeparator() + retDto50);
        // System.out.println("===========================================================================================");

        /** 60 ========================================================================================================== */
        // 요청값 테스트 60 -> 매월 X일 반복 지정 케이스
        ReqDto reqDto60 = ReqDto.createReqDto();
        reqDto60.setStartDate("202301311530");
        reqDto60.setEndDate("202301311530");
        reqDto60.setRepeatByDay("1,2,5,6");
        reqDto60.setRepeatEndDay("20230205");
        reqDto60.setRepeatType("60");
        // System.out.println("reqDto60 => " + System.lineSeparator() + reqDto60);

        // callingMethod 를 통한 repeatType 40 인 경우의 결과 반환값을 확인
        // RetDto retDto60 = TimeLibrary.createTimeLibrary().callingMethod(reqDto60);
        // retDto 값 확인진행
        // System.out.println("retDto60 => " + System.lineSeparator() + retDto60);
        // System.out.println("===========================================================================================");

        /** 70 ========================================================================================================== */
        // 요청값 테스트 70 -> 매월 X일 반복 지정 케이스
        ReqDto reqDto70 = ReqDto.createReqDto();
        reqDto70.setStartDate("202301311530");
        reqDto70.setEndDate("202301311530");
        reqDto70.setRepeatByDay("1,2,5,6");
        reqDto70.setRepeatEndDay("20230205");
        reqDto70.setRepeatType("70");
        // System.out.println("reqDto70 => " + System.lineSeparator() + reqDto70);

        // callingMethod 를 통한 repeatType 40 인 경우의 결과 반환값을 확인
        // RetDto retDto70 = TimeLibrary.createTimeLibrary().callingMethod(reqDto70);
        // retDto 값 확인진행
        // System.out.println("retDto70 => " + System.lineSeparator() + retDto70);
        // System.out.println("===========================================================================================");

        /** 71 ========================================================================================================== */
        // 요청값 테스트 71 -> 메월 마지막 X 요일 지정 케이스
        ReqDto reqDto71 = ReqDto.createReqDto();
        reqDto71.setStartDate("202301311530");
        reqDto71.setEndDate("202301311530");
        reqDto71.setRepeatByDay("");
        reqDto71.setRepeatEndDay("20230205");
        reqDto71.setRepeatType("71");
        // System.out.println("reqDto71 => " + System.lineSeparator() + reqDto71);

        // callingMethod 를 통한 repeatType 30 인 경우의 결과 반환값을 확인
        // RetDto retDto71 = TimeLibrary.createTimeLibrary().callingMethod(reqDto71);
        // retDto 값 확인진행
        // System.out.println("retDto71 => " + System.lineSeparator() + retDto71);
        // System.out.println("===========================================================================================");

        /** 72 ========================================================================================================== */
        // 요청값 테스트 72 -> 매월 마지막 날 케이스
        ReqDto reqDto72 = ReqDto.createReqDto();
        reqDto72.setStartDate("202301051530");
        reqDto72.setEndDate("202301051530");
        reqDto72.setRepeatByDay("");
        reqDto72.setRepeatEndDay("20230205");
        reqDto72.setRepeatType("72");

        // callingMethod 를 통한 repeatType 72 인 경우의 결과 반환값을 확인
        // RetDto retDto72 = TimeLibrary.createTimeLibrary().callingMethod(reqDto72);
        // retDto 값 확인진행
        // System.out.println("retDto72 => " + System.lineSeparator() + reqDto72);
        // System.out.println("===========================================================================================");

        /** 80 ========================================================================================================== */
        // 요청값 테스트 80 -> 매년 반복 설정시 케이스
        ReqDto reqDto80 = ReqDto.createReqDto();
        reqDto80.setStartDate("202302281530");
        reqDto80.setEndDate("202302281530");
        reqDto80.setRepeatByDay("");
        reqDto80.setRepeatEndDay("20300205");
        reqDto80.setRepeatType("80");
        // System.out.println("reqDto80 => " + System.lineSeparator() + reqDto80);

        // callingMethod 를 통한 repeatType 80 인 경우의 결과 반환값을 확인
        // RetDto retDto80 = TimeLibrary.createTimeLibrary().callingMethod(reqDto80);
        // retDto 값 확인진행
        // System.out.println("retDto80 => " + System.lineSeparator() + retDto80);
        // System.out.println("===========================================================================================");
    }
}

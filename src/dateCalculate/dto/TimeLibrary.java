package dateCalculate.dto;

public class TimeLibrary {
    public static RetDto switchCalculate(ReqDto reqDto){
        String startDate = reqDto.getStartDate();
        String endDate = reqDto.getEndDate();;
        String repeatEndDay = reqDto.getRepeatEndDay();
        String repeatByDay = reqDto.getRepeatByDay();
        String repeatType = reqDto.getRepeatType();

        RetDto returnData = RetDto.createRetDto();

        switch (repeatType){
            case "20" :
                System.out.println("repeatType = " + repeatType);
                break;
        }

        return returnData;
    }
}

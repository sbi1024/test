package utilCollect.logic;

import classCollect.alphabet.D;
import classCollect.calendar.KoreanLunarCalendar;
import classCollect.comparable.Book;
import classCollect.generic.alphaClassName;
import classCollect.generic.className;
import classCollect.generic.kvClassName;
import classCollect.innerClass.outer;
import classCollect.lamda.lamdaShow;
import classCollect.person.female;
import classCollect.person.male;
import classCollect.person.personCommon;
import classCollect.polymorphism.boy;
import classCollect.polymorphism.girl;
import classCollect.polymorphism.parent;
import classCollect.stream.user;
import classCollect.thread.*;
import dto.personDto;
import utilCollect.enumclass.statusEnum;
import utilCollect.method.utilMethod;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. main 에서 실행 할 logic class
 * 2. logicTest1 , logicTest2 , ... 순으로 이름 붙여서 구성
 */
public class utilLogic {

    /**
     * method 명 : logicTest1
     * method 기능 : male, female 객체에 데이터 바인딩 후 , 해당 객체의 메소드 호출
     * method 결과 : female 객체에서 참조 가능한 메소드 실행
     */
    public static void logicTest1() {
        personCommon p = new personCommon("logicTest1"
                , "27"
                , "male"
                , "백엔드 개발자"
                , "010-2020-3030");

        male male = (male) utilMethod.refBuild(p);
        male.fight();
        male.sleep();
        male.walk();
        male.eat();

    }

    /**
     * method 명 : logicTest2
     * method 기능 : male, female 객체에 데이터 바인딩 후 , 해당 객체의 메소드 호출
     * method 결과 : female 객체에서 참조 가능한 메소드 실행
     */
    public static void logicTest2() {
        personCommon p = new personCommon("logicTest2"
                , "27"
                , "female"
                , "프론트 개발자"
                , "010-2020-3030");

        female female = (female) utilMethod.refBuild(p);
        female.fight();
        female.sleep();
        female.walk();
        female.eat();
    }

    /**
     * method 명 : logicTest3
     * method 기능 : male, female 객체에 데이터 바인딩 후 , 해당 객체의 메소드 호출
     * method 결과 : female 객체에서 참조 가능한 메소드 실행
     */
    public static void logicTest3() {
        personCommon p = new personCommon("logicTest3"
                , "27"
                , "male"
                , "풀스택 개발자"
                , "010-2020-3030");

        if (p.getSex().equals("male")) {
            male male = (male) utilMethod.fixReBuild(p);
            utilMethod.executeMethod(male);
        } else if (p.getSex().equals("female")) {
            female female = (female) utilMethod.fixReBuild(p);
            utilMethod.executeMethod(female);
        } else {
            System.out.println("조건문에 부합하지 않는 , 성별 입니다. ====> ");
        }
    }

    /**
     * method 명 : logicTest4
     * method 기능 : male, female 객체에 데이터 바인딩 후 , 해당 객체의 메소드 호출
     * -----> enum Class 참조를 통한 테스트
     * method 결과 : female 객체에서 참조 가능한 메소드 실행
     */
    public static void logicTest4() {
        personCommon p = new personCommon("logicTest4"
                , "27"
                , "grandFather"
                , "풀스택 개발자"
                , "010-2020-3030");

        if (p.getSex().equals(statusEnum.STATUS_MALE.getSex())) {
            statusEnum.STATUS_MALE.soutStatus();
        } else if (p.getSex().equals(statusEnum.STATUS_FEMALE.getSex())) {
            statusEnum.STATUS_FEMALE.soutStatus();
        } else {
            statusEnum.STATUS_UNKNOWN.soutStatus();
        }
    }

    /**
     * method 명 : logicTest5
     * method 기능 : male, female 객체에 데이터 바인딩 후 , 해당 객체의 메소드 호출
     * -----> enum Class 참조를 통한 테스트
     * method 결과 : female 객체에서 참조 가능한 메소드 실행
     */
    public static void logicTest5() {
        personCommon p = new personCommon("logicTest5"
                , "27"
                , "grandFather"
                , "풀스택 개발자"
                , "010-2020-3030");

        // 남자일 경우 , 여자일 경우 , 그 이외의 경우
        utilMethod.extracted(p);
    }

    /**
     * method 명 : logicTest6
     * method 기능 : 다형성 테스트
     * method 결과 : 부모의 참조변수 타입 = new 연산자를 이용한 자식 인스턴스변수 타입 생성 가능
     * 상속관계에 있는 부모와 자식의 타입의 대한 형변환 (casting)은 가능
     */
    public static void logicTest6() {
        // parent
        parent p = new parent();
        //boy
        boy b = new boy();
        // girl
        girl g = new girl();


        // 참조변수 타입 : parent
        // 인스턴스 타입 : boy
        parent pb = new boy();
        boy bpb = (boy) pb;
        System.out.println("bpb.getHobby() = " + bpb.getHobby());

        // 참조변수 타입 : parent
        // 인스턴스 타입 : girl
        parent pg = new girl();
        girl gpg = (girl) pg;
        System.out.println("gpg.getShose() = " + gpg.getShose());

        if (bpb instanceof parent) {
            System.out.println("bpb = " + bpb);
        }
        if (gpg instanceof parent) {
            System.out.println("gpg = " + gpg);
        }
    }

    /**
     * method 명 : logicTest7
     * method 기능 : 제네릭 AND 다형성 테스트
     * method 결과 : 예측 불가
     */
    public static void logicTest7() {
        personCommon p = new personCommon("logicTest3"
                , "27"
                , "male"
                , "풀스택 개발자"
                , "010-2020-3030");
    }

    public static void logicTest8() {
        // generic class의 타입을 지정하지 않고 new 연산자를 이용해서 객체를 생성하여도
        // 외부에서 주입하는 데이터 타입으로 해당 객체가 생성이 되는것을 확인.
        // 하지만 타입에 대한 불안정성을 고려해야 함
        className c = new className();
        c.setElement("10");
        System.out.println("c data " + c.getElement());
        System.out.println("c E Type = " + c.getElement().getClass().getName());
        System.out.println();

        className<String> a = new className<String>();
        className<Integer> b = new className<Integer>();

        a.setElement("10");
        b.setElement(10);

        System.out.println("a data " + a.getElement());
        System.out.println("a E Type = " + a.getElement().getClass().getName());
        System.out.println();

        System.out.println("b data " + b.getElement());
        System.out.println("b E Type = " + b.getElement().getClass().getName());
        System.out.println();
    }

    public static void logicTest9() {
        kvClassName<String, Integer> a = new kvClassName<String, Integer>();
        a.set("10", 10);
        System.out.println("a.getFirst() = " + a.getFirst());
        System.out.println("a.getFirst().getClass().getName() = " + a.getFirst().getClass().getName());
        System.out.println("a.getSecond() = " + a.getSecond());
        System.out.println("a.getSecond().getClass().getName() = " + a.getSecond().getClass().getName());
    }

    public static void logicTest10() {
        className<String> a = new className<>();
        className<Integer> b = new className<>();

        a.setElement("10");
        b.setElement(10);

        System.out.println("a.getElement() = " + a.getElement());
        System.out.println("b.getElement() = " + b.getElement());

        className<String> stringclassName = a.genericMethod(a);
        className<Integer> integerclassName = a.genericMethod(b);


    }

    public static void logictest11() {
        // alphaClassName의 타입을 D 클래스 타입으로 생성
        alphaClassName<D> alpha = new alphaClassName();
        // alphaClassName 에 setAlpha() 를 하기 위한 D 클래스 타입의 List 생성
        List<D> dList = new ArrayList<>();

        D d1 = new D();
        D d2 = new D();
        D d3 = new D();
        D d4 = new D();
        D d5 = new D();

        dList.add(d1);
        dList.add(d2);
        dList.add(d3);
        dList.add(d4);
        dList.add(d5);

        // alphaCalssName에 dList setAlpha() 실행
        alpha.setAlpha(dList);

        // dList의 toString() 값 기대 ===> 해당 객체의 주소값이 출력됨
        alpha.soutAlpha();
    }

    public static void logictest12() {
        lamdaShow ls = new lamdaShow();
        ls.lamda1();
        ls.lamda2();
        ls.lamda3();
    }

    public static void logicTest13() {
        // 제네릭이 String 타입 List 를 생성
        List<String> list = Arrays.asList("Yanghayan", "Thanggu", "bory"); // 요소가 3개인 리스트 생성

        // 위 변수 데이터 중 , 해당 문자열의 길이가 5 이상인 것들에 대해 필터링을 진행하며
        // 최종연산 collect 전 , map을 통해 새로운 요소값을 생성한다. EX) {Yanghayan}
        List<String> collectList = list.stream()
                .filter(t -> t.length() > 5)
                .map(p -> "{" + p + "}")
                .collect(Collectors.toList());

        // stream을 통해 생성한 collectList console 창에 출력
        for (String str : collectList) {
            System.out.println("str = " + str);
        }
    }

    public static void logicTest14() {
        user user1 = new user("udk1", 10, 10);
        user user2 = new user("udk2", 30, 20);
        user user3 = new user("udk3", 20, 30);

        List<user> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userList.stream()
                .map(u -> u.getName())
                .forEach(u -> System.out.println(u));

        userList.stream()
                .filter(u -> u.getLevel() >= 20)
                .map(u -> u.getName())
                // .sorted()
                .forEach(u -> System.out.println(u));
    }

    public static void logicTest15() {
        List<String> lStr = new ArrayList<>();
        lStr.add("1");
        lStr.add("7");
        lStr.add("9");
        lStr.add("2");
        lStr.add("90");

        //
        List<String> collect = lStr.stream()
                .sorted()
                .collect(Collectors.toList());

        for (String str : collect) {
            System.out.println("str = " + str);
        }

        List<Integer> lIt = new ArrayList<>();
        lIt.add(1);
        lIt.add(5);
        lIt.add(2);
        lIt.add(100);
        lIt.add(12);

        List<Integer> itCollect = lIt.stream()
                .sorted()
                .collect(Collectors.toList());

        for (Integer it : itCollect) {
            System.out.println("it = " + it);
        }


        Map<byte[], Integer> collectMap = lStr.stream()
                .sorted()
                .collect(Collectors.toMap(e -> e.getBytes(), e -> e.length()));
        System.out.println("collectMap = " + collectMap);

    }

    public static void logicTest16() {
        int[] intArr = new int[10];
        for (int i = 0; i < 10; i++) {
            intArr[i] = i * 10;
        }

        int[] ints = Arrays.stream(intArr)
                .filter(intA -> intA == 10 | intA == 20)
                .toArray();

        for (int s : ints) {
            System.out.println("s = " + s);
        }

    }

    public static void logicTest17() {
        thread0 thread1 = thread0.createThread1("test1");
        String abc = thread1.getAbc();
        System.out.println("abc = " + abc);
    }

    public static void logicTest18() {
        Thread t = new Thread(new thread2());
        t.start();
    }

    public static void logicTest19() {
        System.out.println("현재 대출한 책의 갯수 : " + Library.student.getBookCount());

        BorrowThread bt = new BorrowThread();
        ReturnThread rt = new ReturnThread();

        bt.start();
        rt.start();

        String name1 = bt.getName();
        String name2 = rt.getName();

        System.out.println("name1 = " + name1);
        System.out.println("name2 = " + name2);

        try {
            bt.join();
            rt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void logicTest20() {
        KoreanLunarCalendar calendar = KoreanLunarCalendar.getInstance();
        // 대표 윤달 날짜 (2023_03_22 ~ 2023_04_19)

        calendar.setSolarDate(2023, 03, 22);
        // Lunar Date (ISO format)
        System.out.println(calendar.getLunarIsoFormat());
        // Korean GapJa String
        System.out.println(calendar.getGapjaString());
        // Chinese GapJa String
        System.out.println(calendar.getChineseGapJaString());

        // param : year(년), month(월), day(일), intercalation(윤달여부)
        calendar.setLunarDate(2023, 3, 22, true);
        // Solar Date (ISO format)
        System.out.println(calendar.getSolarIsoFormat());
        // Korean GapJa String
        System.out.println(calendar.getGapjaString());
        // Chinese GapJa String
        System.out.println(calendar.getChineseGapJaString());
    }

    public static void logicTest21() {
        // 1. 해당 클래스의 인스턴스 객체를 받아온다
        KoreanLunarCalendar calendar = KoreanLunarCalendar.getInstance();

        // 2-1. 데이터는 양력 기준으로 들어오므로 , 현재 해당 양력 날짜를 음력으로 변환하기 위한 과정을 진행한다.
        // 2-2. 테스트 진행을 위한 , 2022.10.20 값 설정 (양력 값) - !!!!  윤월이 아닌경우 !!!!
        calendar.setSolarDate(2022, 10, 20);

        String lunarIsoFormat = calendar.getLunarIsoFormat();
        String gapjaString = calendar.getGapjaString();

        // 3. 위 변수에 할당되어 있는 리터럴 값 출력 하여 확인
        System.out.println("lunarIsoFormat = " + lunarIsoFormat);
        System.out.println("gapjaString = " + gapjaString);

        /**
         * lunarIsoFormat = 2022-09-25
         * gapjaString = 임인년 경술월 병오일
         */
    }

    public static void logicTest22() {
        // 1. 해당 클래스의 인스턴스 객체를 받아온다
        KoreanLunarCalendar calendar = KoreanLunarCalendar.getInstance();

        // 2-1. 데이터는 양력 기준으로 들어오므로 , 현재 해당 양력 날짜를 음력으로 변환하기 위한 과정을 진행한다.
        // 2-2. 테스트 진행을 위한 , 2023.03.22 값 설정 (양력 값) - !!!!  윤월인 경우 !!!!
        calendar.setSolarDate(2023, 03, 22);

        String lunarIsoFormat = calendar.getLunarIsoFormat();
        String gapjaString = calendar.getGapjaString();

        // 3. 위 변수에 할당되어 있는 리터럴 값 출력 하여 확인
        System.out.println("lunarIsoFormat = " + lunarIsoFormat);
        System.out.println("gapjaString = " + gapjaString);

        /**
         * lunarIsoFormat = 2023-02-01 Intercalation
         * gapjaString = 계묘년 을묘월 기묘일 (윤월)
         */
    }

    public static void logicTest23() {
        /**
         * ========================================================================================
         * 위 logicTest22 , logicTest23 메소드의 결과를 통해 추측 할수 있는 내용은
         * 1. 양력 데이터를 통해 음력데이터를 변환하여 , 해당 음력일자가 윤월인지 아닌지 판별가능
         * 2. 윤월인지 아닌지는 , lunarIsoFormat 변수의 데이터 안에 ,
         *          Intercalation 값이 포함된 경우 (TRUE) -> 윤월에 해당하는 음력일자라고 판별 가능
         *          Intercalation 값이 포함된 경우 (FALSE) -> 윤월에 해당하지 않는 음력일자라고 판별 가능
         * 3. 추가적으로 , 윤년인지에 대한 판단도 필요한데 , 음력기준으로 윤년이라는 개념이 포함되어 있는지 확인 필요.
         * ========================================================================================
         */

        // 0. abstract class를 정적 팩토리 메소드 (getInstance)를 통해 해당 객체를 반환한다
        // 해당 캘린더는 기본생성자를 호출하여 , 현재 시점의 날짜값을 설정하여 반환한다.
        KoreanLunarCalendar calendar = KoreanLunarCalendar.getInstance();
        for (int i = 1; i < 30; i++) {
            // 1. 캘린더 객체를 생성하여 해당 객체에 양력으로 데이터를 할당한다
            calendar.setSolarDate(2023, 03, i);
            // 2. 위 1번에서 설정한 양력 값을 음력 값으로 변환한다
            String lunarIsoFormat = calendar.getLunarIsoFormat();
            // 3. 음력 값으로 셋팅한 값을 split (공백값 기준)을 통해 값을 나눈다
            String[] lunarIsoFormatSplit = lunarIsoFormat.split(" ");
            // 4_1. 공백 기준으로 값을 split 할 경우 , 윤월일 경우엔 배열의 마지막 인덱스에는 "Intercalation" 값이 포함되어 있다
            if (lunarIsoFormatSplit[lunarIsoFormatSplit.length - 1].equals("Intercalation")) {
                // String type의 값을 "+" 연산자를 통해 콘솔창에 출력
                System.out.println("윤월인 경우 : "
                        + calendar.getSolarYear()
                        + "_"
                        + calendar.getSolarMonth()
                        + "_"
                        + calendar.getSolarDay());
            }
            // 4_2. 공백 기준으로 값을 split 할 경우 , 윤월일 아닌 경우엔 배열의 마지막 인덱스에는 "Intercalation" 값이 포함되어 있지 않다.
            else {
                // String type의 값을 "+" 연산자를 통해 콘솔창에 출력
                System.out.println("윤월인 아닌 경우 : "
                        + calendar.getSolarYear()
                        + "_"
                        + calendar.getSolarMonth()
                        + "_"
                        + calendar.getSolarDay());
            }

        }
    }

    public static void logicTest24() {
        // 캘린더 인스턴스 객체 생성 -> 추상 클래스 이므로 , getInstance 메소드를 통하여 객체 생성
        Calendar cal = Calendar.getInstance();

        // 해당 cal 객체는 현재 시점의 날짜값으로 초기화 되어 값을 가지고 있음
        int calYear = cal.get(Calendar.YEAR);
        int calMonth = cal.get(Calendar.MONTH);

        // DAY_OF_MONTH 와 DATE 는 반환값이 같다.
        int calDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int calDate = cal.get(Calendar.DATE);

        // 일년으로부터 , 해당 일이 몇일이 지났는지 알수 있음
        // EX) 2022-10-21 기준으로 반환값이 294일 반환
        int calDay = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("calYear = " + calYear);
        System.out.println("calMonth = " + calMonth);
        System.out.println("calDayOfMonth = " + calDayOfMonth);
        System.out.println("calDate = " + calDate);
        System.out.println("calDay = " + calDay);

        // 1년 중에서 해당 날짜가 , 몇번째 주인지 반환
        int calWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        // 이번달에서 해당 날짜가 , 몇번째 주인지 반환
        int calWeekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

        System.out.println("calWeekOfYear = " + calWeekOfYear);
        System.out.println("calWeekOfMonth = " + calWeekOfMonth);

        // 반환값이 0이라면 , 오전
        // 반환값이 1이라면 , 오후
        int calAmPm = cal.get(Calendar.AM_PM);
        // 지금 몇시인지 반환 (12시 기준)
        int calHour = cal.get(Calendar.HOUR);
        // 지금 몇시인지 반환 (24시 기준)
        int calHourOfDay = cal.get(Calendar.HOUR_OF_DAY);

        System.out.println("calAmPm = " + calAmPm);
        System.out.println("calHour = " + calHour);
        System.out.println("calHourOfDay = " + calHourOfDay);

        int calMinute = cal.get(Calendar.MINUTE);
        int calSecond = cal.get(Calendar.SECOND);

        System.out.println("calMinute = " + calMinute);
        System.out.println("calSecond = " + calSecond);

        int calActualMaximumDay = cal.getActualMaximum(Calendar.DATE);
        int calActualMinimumDay = cal.getActualMinimum(Calendar.DATE);

        int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        int actualMinimum = cal.getActualMinimum(Calendar.DAY_OF_YEAR);

        System.out.println("actualMaximum = " + actualMaximum);
        System.out.println("actualMinimum = " + actualMinimum);

        System.out.println("calActualMaximum = " + calActualMaximumDay);
        System.out.println("calActualMinimum = " + calActualMinimumDay);

        int calactualMaximumYear = cal.getActualMaximum(Calendar.YEAR);
        int calactualMaximumMonth = cal.getActualMaximum(Calendar.MONTH);

        System.out.println("calactualMaximumYear = " + calactualMaximumYear);
        System.out.println("calactualMaximumMonth = " + calactualMaximumMonth);

        int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("calDayOfWeek = " + calDayOfWeek);

        System.out.println("============================================================");

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        startDate.set(2022, 10, 24);
        endDate.set(2023, 9, 23);

        long diff = (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / 1000;
        long realDiff = diff / (24 * 60 * 60);

        System.out.println("diff = " + diff);
        System.out.println("realDiff = " + realDiff);

        System.out.println("============================================================");

        Date time1 = startDate.getTime();
        Date time2 = endDate.getTime();

        DateFormat format_1 = new SimpleDateFormat("yyyy_MM_dd HH:mm");
        DateFormat format_2 = new SimpleDateFormat("YYYY_MM_DD HH:MM");

        String format1 = format_1.format(time1);
        String format2 = format_1.format(time2);

        String format3 = format_2.format(time1);
        String format4 = format_2.format(time2);

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);
        System.out.println("format1 = " + format1);
        System.out.println("format2 = " + format2);
        System.out.println("format3 = " + format3);
        System.out.println("format4 = " + format4);

        System.out.println("============================================================");

        for (int i = 0; i < 10; i++) {

        }


    }

    public static void logicTest25() {
        String animal = "dog cat bear";
        String[] s = animal.split(" ");
        String join = String.join("/", s);
        System.out.println("join = " + join);
        StringJoiner sj = new StringJoiner("/", "[", "]");
        for (String str : s) {
            sj.add(str);
        }
        System.out.println("sj = " + sj);

    }

    public static void logicTest26() {
        // wrappper class 를 이용한 값 비교
        Double dVal1 = Double.valueOf(200.01);
        Double dVal2 = Double.valueOf(200.00);
        if (dVal1.equals(dVal2)) {
            System.out.println("dVa1값과 , dVal2값이 일치합니다.");
        } else {
            System.out.println("dVa1값과 , dVal2값이 일치 하지 않습니다.");
        }

        String strDouble = "300.0";
        double result = Double.parseDouble(strDouble);
        System.out.println("result = " + result);
    }

    public static void logicTest27() {
        String animal = "A,B";
        String[] splitAnimal = animal.split(",");
        String joinStr = String.join("-", splitAnimal);
        System.out.println("joinStr = " + joinStr);
    }

    public static void logicTest28() {
        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        List<String> temp = new ArrayList<>();
        temp.addAll(test);

        for (String str : temp) {
            System.out.println("str = " + str);
        }
    }

    public static void logicTest29() {
        double dobuleOriginData = 90.7552;
        double originDataRound = Math.round(dobuleOriginData);
        System.out.println("originDataRound = " + originDataRound);

        double doubleNewData = 90.7552 * 100.0;
        double newDataRound = Math.round(doubleNewData) / 100.0;
        System.out.println("newDataRound = " + newDataRound);
    }

    public static void logicTest30() {
        // Math Class method 사용 테스트
        for (int i = 0; i < 10; i++) {
            int mathAdd = Math.addExact(1000, 1000 * i);
            System.out.println("mathAdd = " + mathAdd);

            int mathMultiply = Math.multiplyExact(1000, 1000 * i);
            System.out.println("mathMultiply = " + mathMultiply);
        }

        int mathMax = Math.max(100, 1000);
        System.out.println("mathMax = " + mathMax);

        int mathMin = Math.min(100, 1000);
        System.out.println("mathMin = " + mathMin);

        boolean aNull = Objects.isNull(mathMin);
        System.out.println("aNull = " + aNull);
    }

    public static void logicTest31() {
        double number = 1273.14987;
        DecimalFormat df = new DecimalFormat("#######,#");
        String format = df.format(number);
        System.out.println("format = " + format);
    }

    public static void logicTest32() {
        double number = 1273.14987;
        DecimalFormat df = new DecimalFormat("000,000");
        String format = df.format(number);
        System.out.println("format = " + format);
    }

    public static void logicTest33() {
        // 변수 선언
        int temp1 = 1000;
        String temp2 = "서보인 테스트";
        double temp3 = 3.1494949498;

        // format 선언
        String format1 = String.format("값의 정수 : %10d", temp1);
        String format2 = String.format("값의 문자열 : %10s", temp2);
        String format3 = String.format("값의 실수형 : %f ", temp3);

        // 값 출력
        System.out.println("format = " + format1);
        System.out.println("format = " + format2);
        System.out.println("format3 = " + format3);
    }

    public static void logicTest34() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        Date d = df.parse("2018년 10월 3일");
        String format = df2.format(d);
        System.out.println("format = " + format);
    }

    public static void logicTest35() {
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        System.out.println("date = " + date);

        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(datePattern);

        String dateStr = format.format(date);
        System.out.println(dateStr);
    }

    public static void logicTest36() {
        LocalDate ld = LocalDate.now();
        System.out.println("ld = " + ld);

        LocalTime lt = LocalTime.now();
        System.out.println("lt = " + lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("ldt = " + ldt);

        LocalDate myBirthDate = LocalDate.of(2022, 10, 24);
        LocalTime myBirthTime = LocalTime.of(10, 10, 10);
        LocalDateTime test = LocalDateTime.of(myBirthDate, myBirthTime);
        System.out.println("test = " + test);

        System.out.println("myBirthTime = " + myBirthDate);
        System.out.println("myBirthTime = " + myBirthTime);

        LocalDate localDate1 = myBirthDate.withYear(2022);
        LocalDate localDate2 = myBirthDate.withMonth(11);
        LocalDate localDate3 = myBirthDate.withDayOfYear(91);

        System.out.println("localDate1 = " + localDate1);
        System.out.println("localDate2 = " + localDate2);
        System.out.println("localDate3 = " + localDate3);

        int i = myBirthDate.compareTo(localDate1);
        System.out.println("i = " + i);

        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
        System.out.println("nyTime = " + nyTime);
        // now() 대신 of() 사용하여 날짜&시간 지정 가능

        // Period , Duration 확인
        // Period == 날짜 - 날짜
        LocalDate date1 = LocalDate.of(2020, 10, 10);
        LocalDate localDate4 = date1.plusDays(30)
                .plusMonths(13)
                .plusYears(12);
        System.out.println("localDate4 = " + localDate4);

        LocalDate date2 = LocalDate.of(2022, 10, 10);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now();


        Period p1 = Period.between(date1, date2);

        int years = p1.getYears();
        int months = p1.getMonths();
        int days = p1.getDays();


        System.out.println("years = " + years);
        long sec = LocalDate.now().until(date1, ChronoUnit.YEARS);
        System.out.println("sec = " + sec);

        // Duration == 시간 - 시간
    }

    public static void logicTest37() {
        // 1.오늘 날짜의 객체 생성
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("1. 현재 날짜 및 시간 출력 = " + ldt);

        // 2.오늘 날짜에서
        LocalDateTime firstDayOfYear = ldt.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("2. 현재 날짜에서 첫번째 일 = " + firstDayOfYear);

        LocalDateTime firstDayOfMonth = ldt.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("3. 현재 날짜에서 해당 달의 첫번째 일 = " + firstDayOfMonth);

        LocalDateTime firstDayOfNextMonth = ldt.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("4. 현재 날짜에서 다음달의 첫번째 일 = " + firstDayOfNextMonth);

        LocalDateTime firstInMonth = ldt.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("5. 현재 날짜에서  " + firstInMonth);

    }

    public static void logicTest38() {
        BigDecimal bd1 = BigDecimal.valueOf(3.14);
        BigDecimal bd2 = BigDecimal.valueOf(6.14);
        BigDecimal bd3 = BigDecimal.valueOf(3.14);
        BigDecimal bd4 = BigDecimal.valueOf(2.14);

        boolean equals1 = bd1.equals(bd2);
        boolean equals2 = bd1.equals(bd3);
        boolean equals3 = bd1.equals(bd4);

        System.out.println("equals1 = " + equals1);
        System.out.println("equals2 = " + equals2);
        System.out.println("equals3 = " + equals3);

        int i1 = bd1.compareTo(bd2);
        int i2 = bd1.compareTo(bd3);
        int i3 = bd1.compareTo(bd4);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }

    public static void logicTest39() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String strDate1 = "2022-11-07";
        String strdate2 = "2022-11-08";

        Date date1 = sdf.parse(strDate1);
        Date date2 = sdf.parse(strdate2);

        if (date1.before(date2)) {
            System.out.println("date1이 date2 보다 전에 날짜 입니다.");
        } else if (date1.after(date2)) {
            System.out.println("date1이 date2 보다 후에 날짜 입니다.");
        } else if (date1.equals(date2)) {
            System.out.println("date1이 date2와 같은 날짜 입니다.");
        }

    }

    public static void logicTest40() throws ParseException {
        String testDate1 = "20221108";
        String testDate2 = "2022-11-09";

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.now();
        System.out.println("ld1 = " + ld1);
        System.out.println("ld2 = " + ld2);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        Date parse1 = sdf1.parse(testDate1);
        Date parse2 = sdf1.parse(testDate2);

        System.out.println("parse1 = " + parse1);
        System.out.println("parse2 = " + parse2);

        String format1 = sdf2.format(parse1);
        String format2 = sdf2.format(parse2);

        System.out.println("format1 = " + format1);
        System.out.println("format2 = " + format2);

        // Date 타입을 Calendar 타입으로 변환
        Date date3 = new Date();
        Calendar c3 = Calendar.getInstance();
        c3.setTime(date3);

        // Calendar 타입을 Date 타입으로 변환
        Calendar c4 = Calendar.getInstance();
        Date date4 = c4.getTime();
        String format = sdf1.format(date4);
        System.out.println("format = " + format);

        LocalDateTime ldt1 = LocalDateTime.now();

        String ldt1Format = ldt1.format(DateTimeFormatter.ofPattern("MM월 dd일"));
        System.out.println("ldt1Format = " + ldt1Format);

        LocalDateTime ltd2 = LocalDateTime.now();
        LocalDateTime localDateTime = ltd2.withYear(2002).withMonth(8).withDayOfMonth(12);
        String yy = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss"));
        System.out.println("yy = " + yy);


        LocalDateTime ldt_1 = LocalDateTime.of(2012, 8, 1, 0, 2, 3);
        LocalDateTime ldt_2 = LocalDateTime.of(2019, 7, 5, 12, 3, 4);
        int year = ldt_1.getYear();
        Month month = ldt_1.getMonth();
        int dayOfMonth = ldt_1.getDayOfMonth();
        LocalDate ld_1 = LocalDate.of(year, month, dayOfMonth);
        LocalDate ld_2 = LocalDate.of(year + 1, month, dayOfMonth);

        long until = ld_1.until(ld_2, ChronoUnit.YEARS);
        System.out.println("until = " + until);

        Period between = Period.between(ld_1, ld_2);
        int years = between.getYears();
        System.out.println("years = " + years);
        int months = between.getMonths();
        System.out.println("months = " + months);
        int days = between.getDays();
        System.out.println("days = " + days);
    }

    public static void logicTest41() {
        Calendar c = Calendar.getInstance();
        c.set(1, 10, 24);
        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        System.out.println("format = " + format);
    }

    public static void logicTest42() {
        ValuesEnum[] values = ValuesEnum.values();
        for (ValuesEnum v : values) {
            System.out.println("v = " + v);
        }
        ValuesEnum test1 = ValuesEnum.valueOf("TEST1");
        test1.systemOut1();
        test1.systemOut2();
    }

    public static void logicTest43() {
        int[] a = new int[3]; // 1
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        List<int[]> ints = Arrays.asList(a); // 1 // 2 -> 1
        a[0] = 3;

        for (int temp : a) {
            System.out.println("temp = " + temp);
        }
    }

    public static void logicTest44() {
        Object o;
        o = new BigDecimal("1");
        o = 2;
        Number o1 = (Number) o;
        System.out.println("o1 = " + o1);
    }

    public static void logicTest45() {
        // 외부 클래스 객체 생성
        outer o = new outer();
        // 외부 클래스 method 실행
        o.outerMethod();
        // 내부 클래스 객체 생성
        outer.inner oi = o.new inner();
        // 내부 클래스 method 실행
        oi.innerMethod();
    }

    public static void logicTest46() {
        outer.stInner os = new outer.stInner();
        os.stinnerMethod();
    }

    public static void logicTest47() {
        List<Map<String, Object>> listMap = new ArrayList<>();

        Map<String, Object> testMap1 = new HashMap<>();
        testMap1.put("성별", "남자");
        testMap1.put("나이", "28");
        testMap1.put("사이즈", "180");

        Map<String, Object> testMap2 = new HashMap<>();
        testMap2.put("성별", "여자");
        testMap2.put("나이", "24");
        testMap2.put("사이즈", "163");

        listMap.add(testMap1);
        listMap.add(testMap2);

        List<personDto> personDtoList = listMap.stream()
                .filter(s -> Integer.parseInt(String.valueOf(s.get("나이"))) > 25)
                .map(s -> new personDto(
                        String.valueOf(s.get("성별"))
                        , String.valueOf(s.get("나이"))
                        , String.valueOf(s.get("사이즈"))))
                .collect(Collectors.toList());

        for (personDto psd : personDtoList) {
            System.out.println("psd = " + psd);
        }
    }

    public static void logicTest48() {
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2023, 12, 30);

        Period between = Period.between(ld1, ld2);

        int years = between.getYears();
        System.out.println("years = " + years);
        int months = between.getMonths();
        System.out.println("months = " + months);
        int days = between.getDays();
        System.out.println("days = " + days);

        LocalDate testDate = LocalDate.of(years, months, days);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM/dd");
        String format = df.format(testDate);
        System.out.println("format = " + format);

        String s = "2022-10-24";
        LocalDate parseStr = LocalDate.parse(s);
        System.out.println("parseStr = " + parseStr);

        String format1 = df.format(parseStr);
        System.out.println("format1 = " + format1);


        String dateStr = "2011-10-24";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(dateStr);
            String format2 = sdf.format(parse);
            System.out.println("format2 = " + format2);
        } catch (ParseException e) {
            e.printStackTrace();
            e.getMessage();
        }

        String testDateStr = "2022-10-22";
        SimpleDateFormat sdfsdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Date -> Calendar
            Date parse = sdfsdf.parse(testDateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(parse);
            System.out.println("c = " + c.getTime());

            Calendar cc = Calendar.getInstance();
            cc.add(Calendar.YEAR, 2);
            Date d = cc.getTime();
            System.out.println("d = " + d);


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logicTest49() {

        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("총균쇄", "제레미 다이아몬드", "문학사상", 2005));
        list.add(new Book("총균쇄", "제레미 다이아몬드", "문학사상", 2000));
        list.add(new Book("파타고니아, 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2020));
        list.add(new Book("파타고니아, 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2010));
        list.add(new Book("코스모스", "칼 세이건", "사이언스북스", 2010));
        list.add(new Book("코스모스", "칼 세이건", "사이언스북스", 2001));
        list.add(new Book("죽은 자의 집 청소", "김완", "김영사", 2020));
        list.add(new Book("동물농장", "조지 오웰", "민음사", 2007));
        list.add(new Book("동물농장", "조지 오웰", "민음사", 1988));
        list.add(new Book("침묵의 봄", "레이첼 카슨", "에코리브르", 2011));
        list.add(new Book("불안", "알랭 드 보통", "은행나무", 2012));
        list.add(new Book("불안", "알랭 드 보통", "은행나무", 2018));
        list.add(new Book("싯다르타", "헤르만 헤세", "민음사", 2002));
        list.add(new Book("싯다르타", "헤르만 헤세", "민음사", 2005));
        list.add(new Book("호모데우스", "유발 하라리", "김영사", 2017));

//        List<Book> collect = list.stream()
//                .sorted(Comparator.comparing(Book::getTitle))
//                .collect(Collectors.toList());

        // 람다로 표현가능
        Comparator<Book> c = (o1, o2) -> {
            if (o1.getYear() > o2.getYear()) {
                return 1;
            } else if (o1.getYear() < o2.getYear()) {
                return -1;
            } else {
                return 0;
            }
        };

        Collections.sort(list, c);

        for (Book b : list) {
            System.out.println("b = " + b);
        }

        Map<String, Object> m = new HashMap<>();
        m.put("1", 1);
    }

    public static void logicTest50() throws CloneNotSupportedException {
        personDto pd1 = new personDto();
        pd1.setAge("18");
        pd1.setSize("20");
        pd1.setSex("male");

        personDto clone = pd1.clone();

        clone.setAge("11");

        System.out.println("pd1 = " + pd1);
        System.out.println("clone = " + clone);
    }

    public static void logicTest51() {
        // 테스트 personDto 객체 생성 10개
        personDto person1 = personDto.createPerson("male", "27", "20");
        personDto person2 = personDto.createPerson("male", "27", "20");
        personDto person3 = personDto.createPerson("female", "27", "30");
        personDto person4 = personDto.createPerson("female", "28", "40");
        personDto person5 = personDto.createPerson("male", "28", "60");
        personDto person6 = personDto.createPerson("female", "28", "60");
        personDto person7 = personDto.createPerson("male", "28", "60");
        personDto person8 = personDto.createPerson("male", "31", "80");
        personDto person9 = personDto.createPerson("male", "31", "90");
        personDto person10 = personDto.createPerson("male", "32", "100");

        // 테스트 personList 변수 선언
        List<personDto> personList = new ArrayList<>();

        // personList 변수에 , personDto 객체 10개 할당
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);
        personList.add(person9);
        personList.add(person10);

        // personList 변수에 , 나이 내림차순 , 사이즈 오름차순 정렬
        List<personDto> sortedPersonList = personList.stream()
                .sorted(Comparator.comparing(personDto::getAge)
                        .thenComparing(personDto::getSize))
                .collect(Collectors.toList());

        // 줄 공백 선언
        System.out.println("============================== sortedPersonList ===============================");

        // 정렬된 변수 출력 및 확인
        for (personDto pd : sortedPersonList) {
            System.out.println("pd.toString() = " + pd.toString());
        }

        // groupingBy test 진행
        System.out.println("============================== groupingPersonList (iterator) ===============================");
        Map<String, Map<String, List<personDto>>> groupingPersonList = personList.stream().
                collect(Collectors.groupingBy(personDto::getAge,
                        Collectors.groupingBy(personDto::getSize)));

        Iterator<String> firstMapKeys = groupingPersonList.keySet().iterator();
        while (firstMapKeys.hasNext()) {
            String firstKey = firstMapKeys.next();
            Map<String, List<personDto>> stringListMap = groupingPersonList.get(firstKey);
            Iterator<String> secondMapKeys = stringListMap.keySet().iterator();
            while (secondMapKeys.hasNext()) {
                String secondKey = secondMapKeys.next();
                List<personDto> personDtos = stringListMap.get(secondKey);
                for (personDto pd : personDtos) {
                    System.out.println("pd = " + pd);
                }
                System.out.println("");
            }
        }

        System.out.println("============================== groupingPersonList (keySet) ===============================");
        Set<String> groupingFirstKeys = groupingPersonList.keySet();
        for (String groupingFirstKey : groupingFirstKeys) {
            Map<String, List<personDto>> groupingPersonListGetMap = groupingPersonList.get(groupingFirstKey);
            Set<String> groupingSecondKeys = groupingPersonListGetMap.keySet();
            for (String groupingSecondKey : groupingSecondKeys) {
                List<personDto> personDtos = groupingPersonListGetMap.get(groupingSecondKey);
                for (personDto pd : personDtos) {
                    System.out.println("pd = " + pd);
                }
                System.out.println("");
            }
        }
    }

    public static void logicTest52() {
        String[] strArray = new String[3];
        strArray[0] = "서보인";
        strArray[1] = "안진형";
        strArray[2] = "박수영";

        List<String> strings = Arrays.asList(strArray);
        List<String> filterStrings = strings.stream()
                .filter(o -> o.equals("서보인"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        for (String str : filterStrings) {
            System.out.println("str = " + str);
        }
    }

    public static void logicTest56() {
        String startDate = "202212301430";
        String endDate = "202212301430";

        int startYear = Integer.parseInt(startDate.substring(0, 4));
        int startMonth = Integer.parseInt(startDate.substring(4, 6));
        int startDay = Integer.parseInt(startDate.substring(6, 8));
        int startMinute = Integer.parseInt(startDate.substring(8, 10));
        int startSecond = Integer.parseInt(startDate.substring(10, 12));

        System.out.println("startYear = " + startYear);
        System.out.println("startMonth = " + startMonth);
        System.out.println("startDay = " + startDay);
        System.out.println("startMinute = " + startMinute);
        System.out.println("startSecond = " + startSecond);

        int endYear = Integer.parseInt(endDate.substring(0, 4));
        int endMonth = Integer.parseInt(endDate.substring(4, 6));
        int endDay = Integer.parseInt(endDate.substring(6, 8));
        int endMinute = Integer.parseInt(endDate.substring(8, 10));
        int endSecond = Integer.parseInt(endDate.substring(10, 12));

        System.out.println("endYear = " + endYear);
        System.out.println("endMonth = " + endMonth);
        System.out.println("endDay = " + endDay);
        System.out.println("endMinute = " + endMinute);
        System.out.println("endSecond = " + endSecond);

        LocalDateTime startLocalDateTime = LocalDateTime.of(startYear, startMonth, startDay, startMinute, startSecond);
        LocalDateTime endLocalDatetime = LocalDateTime.of(endYear, endMonth, endDay, endMinute, endSecond);


        boolean comparDateTime = startLocalDateTime.isAfter(endLocalDatetime);
        System.out.println("after = " + comparDateTime);
    }
    public static void logicTest57() {
        LocalDate ld1 = LocalDate.of(2022,22,12);

    }
}

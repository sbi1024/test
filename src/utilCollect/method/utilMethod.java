package utilCollect.method;

import classCollect.person.female;
import classCollect.person.male;
import classCollect.person.personCommon;
import interfaceCollect.personable;
import utilCollect.enumclass.statusEnumDouble;

/**
 * 1. util 관련 method 들이 집합되어 있는 class
 */
public class utilMethod {

    public static void extracted(personCommon p) {
        if (p.getSex().equals(statusEnumDouble.STATUS_MALE_DOUBLE.getSex())) {
            statusEnumDouble.STATUS_MALE_DOUBLE.soutSexAndCode();
        } else if (p.getSex().equals(statusEnumDouble.STATUS_UNKNOWN_DOUBLE.getSex())) {
            statusEnumDouble.STATUS_FEMALE_DOUBLE.soutSexAndCode();
        } else {
            statusEnumDouble.STATUS_UNKNOWN_DOUBLE.soutSexAndCode();
        }
    }

    /**
     * 인터페이스를 매개변수 타입으로 받아서
     * 메소드 실행
     */
    public static void executeMethod(personable pa) {
        pa.eat();
        pa.fight();
        pa.sleep();
        pa.walk();
    }


    /**
     * ver02_method
     */
    public static personCommon fixReBuild(personCommon p) {
        personCommon personCommon = null;

        if (p.getSex().equals("male")) {
            personCommon = new male(p);
        } else if (p.getSex().equals("female")) {
            personCommon = new female(p);
        } else {
            System.out.println("조건문에 부합하지 않는 , 성별 입니다. ====> ");
        }

        return personCommon;
    }


    /**
     * ver01_method
     */
    public static Object refBuild(personCommon p) {
        Object returnData = null;
        if (p.getSex().equals("male")) {
            returnData = refmBinding(p);
        } else if (p.getSex().equals("female")) {
            returnData = reffBinding(p);
        } else {
            System.out.println("조건문에 부합하지 않는 , 성별 입니다. ====> ");
        }
        return returnData;
    }

    private static male refmBinding(personCommon p) {
        male m = new male(p);
        return m;
    }

    private static female reffBinding(personCommon p) {
        female f = new female(p);
        return f;
    }


}

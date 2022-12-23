package interfaceCollect;
/**
 * 1. personCommon class를 상속받는 자손 클래스에서 사용할 interface
 * 2. 공통 메소드만 추출
 */
public interface personable {
    /**
     * 걷기
     */
    void walk();
    /**
     * 먹기
     */
    void eat();    
    /**
     * 잠자기
     */
    void sleep();
    /**
     * 싸우기
     */
    void fight();

    static void test1(){
        System.out.println("true = " + true);
    }

    default void test2(){
        System.out.println("true = " + true);
    }
}

package classCollect.generic;

public class className <E>{
    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    // 제네릭 메소드
    public <T> T genericMethod(T o){
       return o;
    }

    public static <T> T staGenericMethod(T t){
        return t;
    }
}

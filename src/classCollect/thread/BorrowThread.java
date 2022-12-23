package classCollect.thread;

public class BorrowThread extends Thread{
    @Override
    public void run(){
        try{
            Library.student.brrowBook();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("학생이 빌린 총 책의 갯수 : " + Library.student.getBookCount());
    }
}

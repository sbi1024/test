package classCollect.thread;

public class ReturnThread extends Thread {
    @Override
    public void run() {
        try {
            Library.student.returnBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("학생이 빌린 총 책의 갯수 : " + Library.student.getBookCount());
    }
}

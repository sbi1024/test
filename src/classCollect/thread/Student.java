package classCollect.thread;

public class Student {
    int bookCount = 5;

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public synchronized void brrowBook() throws Exception {
        int m = bookCount;
        Thread.sleep(2000);
        bookCount = m + 1;
        System.out.println("대출 완료");
    }

    public synchronized void returnBook() throws Exception {
        int m = bookCount;
        Thread.sleep(3000);
        bookCount = m - 1;
        System.out.println("반납 완료");
    }
}

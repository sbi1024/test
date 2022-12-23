package classCollect.comparable;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String company;
    private int year;

    public Book(String a, String b, String c, int d) {
		this.title = a;
		this.author = b;
		this.company = c;
		this.year = d;
	}

    public String getTitle() {
		return title;
	}

    public int getYear() {
		return year;
	}

//    @Override
//    public int compareTo(Book obj) {
//        if (this.year == obj.year) {
//            return 0;
//            // 현재 객체 == 파라미터로 넘어온 객체 ==> 0 리턴
//        } else if (this.year < obj.year) {
//            return -1;
//            // 현재 객체 < 파라미터로 넘어온 객체 ==> 음수 리턴  ==> 자리 바뀌지 X ==> 오름차순
//        } else {
//            return 1;
//            // 현재 객체 > 파라미터로 넘어온 객체 ==> 양수 리턴 ==> 자리 바뀌지 O ==> 오름차순
//        }
//    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", company='" + company + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return year == book.year
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(company, book.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, company, year);
    }
}

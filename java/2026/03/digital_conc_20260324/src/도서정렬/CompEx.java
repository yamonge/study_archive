package 도서정렬;

import java.util.Comparator;
import java.util.TreeSet;

public class CompEx {
    public static void main(String[] args) {
        //리스트 생성
        TreeSet<Book> books = new TreeSet<>(new PriceComparator());
        // 10개의 도서 객체 생성
        books.add(new Book("Java Programming", "Author A", 30000, 2020));
        books.add(new Book("Python Programming", "Author B", 25000, 2019));
        books.add(new Book("C++ Programming", "Author C", 35000, 2021));
        books.add(new Book("JavaScript Programming", "Author D", 20000, 2018));
        books.add(new Book("Data Structures", "Author E", 40000, 2022));
        books.add(new Book("Algorithms", "Author F", 45000, 2020));
        books.add(new Book("Database Systems", "Author G", 32000, 2019));
        books.add(new Book("Operating Systems", "Author H", 28000, 2021));
        books.add(new Book("Computer Networks", "Author I", 27000, 2018));
        books.add(new Book("Software Engineering", "Author J", 33000, 2022));

        // 가격 오름차순으로 정렬 후 출력
        for(Book book : books){
            System.out.println(book);
        }
        // 최신 출판 순 정렬 후 출력
        TreeSet<Book> booksByYear = new TreeSet<>(new YearComparator());
        booksByYear.addAll(books); // 기존 책들을 새로운 TreeSet에 추가하여 정렬
        System.out.println("\n출판 연도 내림차순으로 정렬:");
        for(Book book : booksByYear) {
            System.out.println(book);
        }
    }
}

class Book{
    // 제목 저자 가격 출판연도
    String title;
    String author;
    int price;
    int year;

    // 매개변수가 전부 있는 생성자
    public Book(String title, String author, int price, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }
    // toString 오버라이딩
    @Override
    public String toString() {
        return title + " " + author + " " + price + " " + year;
    }
}

// 가격 오름차순 : Comparator<Book>
class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.price - b2.price; // 가격이 낮은 순으로 정렬
    }
}
// 출판 연도 내림차순 : Comparator<Book>
class  YearComparator implements Comparator<Book>{
    @Override
    public int compare(Book b1, Book b2){
        return b2.year - b1.year; // 최신 출판 순으로 정렬
    }
}


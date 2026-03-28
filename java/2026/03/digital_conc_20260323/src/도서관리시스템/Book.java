package 도서관리시스템;

public class Book {
    int isbn;
    String title;
    String author;

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public int hashCode() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + "] \n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book){
            Book book = (Book) obj;
            return this.isbn == book.isbn;
        }else{
            return false;
        }
    }

    public void showBook(Book book){
        System.out.println(book);
    }
}

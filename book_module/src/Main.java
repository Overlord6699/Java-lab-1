import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "Ilya Maglich", 100, 1);
        Book book2 = new Book("Harry Potter", "Ilya Maglich", 100, 1);

        System.out.println(book1.compareTo(book1));
        System.out.println(book1.compareTo(book2));

        Book book3 = (Book) book2.clone();
        System.out.println(book3.compareTo(book2));

        System.out.println(book1.hashCode());

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book3);
        books.add(book1);
        books.add(book2);

        Book last = new Book("Money", "Elon Musk", 100000, 2);
        books.add(last);

        System.out.println(books);

        Collections.sort(books);
        System.out.println(books);

        //comparators
        BookTitleComparator comp1 = new BookTitleComparator();
        BookTitleAuthorComparator comp2 = new BookTitleAuthorComparator();
        BookAuthorTitleComparator comp3 = new BookAuthorTitleComparator();
        BookAuthorTitlePriceComparator comp4 = new BookAuthorTitlePriceComparator();

        System.out.println("Компаратор 1:");
        Collections.sort(books, comp1);
        System.out.println(books);

        System.out.println("Компаратор 2:");
        Collections.sort(books, comp2);
        System.out.println(books);

        System.out.println("Компаратор 3:");
        Collections.sort(books, comp3);
        System.out.println(books);

        System.out.println("Компаратор 4:");
        Collections.sort(books, comp4);
        System.out.println(books);
    }
}
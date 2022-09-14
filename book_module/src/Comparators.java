import java.util.Comparator;

class BookTitleComparator implements Comparator<Book> {
    public int compare(Book a, Book b)
    {
        return a.getTitle().compareTo(b.getTitle());
    }
}

class BookTitleAuthorComparator implements  Comparator<Book>
{
    public int compare(Book a, Book b)
    {
        int result = a.getTitle().compareTo(b.getTitle());
        if(result == 0)
            result = a.getAuthor().compareTo(b.getAuthor());

        return result;
    }
}

class BookAuthorTitleComparator implements  Comparator<Book>
{
    public int compare(Book a, Book b)
    {
        int result = a.getAuthor().compareTo(b.getAuthor());
        if(result == 0)
            result = a.getTitle().compareTo(b.getTitle());

        return result;
    }
}

class BookAuthorTitlePriceComparator implements  Comparator<Book>
{
    public int compare(Book a, Book b)
    {
        int result = a.getAuthor().compareTo(b.getAuthor());
        if(result == 0)
            result = a.getTitle().compareTo(b.getTitle());
        if(result == 0)
            result = a.getPrice() - b.getPrice();

        return result;
    }
}

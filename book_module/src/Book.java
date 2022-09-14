public class Book implements Comparable<Book>{
    private int isbn;
    private static int currentIsbn = 0;

    private String title;
    private String author;
    private int price;
    private int edition;

    public  Book()
    {
        isbn = currentIsbn++;
    }

    public Book(final String title,final String author, final int price, final int edition)
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;

        isbn = currentIsbn++;
    }

    public  String getTitle()
    {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(final int price)
    {
        this.price = price;
    }

    public  String getAuthor()
    {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return (
                (title != null && title.equals(book.title))
                        && (author != null && author.equals(book.author))
                        && (price == book.price) && (edition == book.edition)

        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + price;
        result = prime * result +
                ((author == null) ? 0 : author.hashCode());
        result = prime * result + edition;

        return result;
    }

    @Override
    public String toString()
    {
        String result = "";
        result += "title: "+title + "\n"+
                "author: " + author + "\n" +
                "price: " + price + "\n" +
                "edition: " + edition + "\n" +
                "isbn: " + isbn + "\n";

        return result;
    }

    @Override
    public Object clone()
    {
        Book book = new Book();
        book.title = this.title;
        book.author = this.author;
        book.price = this.price;
        book.edition = this.edition;

        return book;
    }

    public int compareTo(Book book)
    {
        return isbn - book.isbn;
    }
}

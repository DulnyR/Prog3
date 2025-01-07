package Model;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        } else {
            return b1.getBookName().compareTo(b2.getBookName());
        }
    }

}

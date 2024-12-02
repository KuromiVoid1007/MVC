
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<String> books;

    public Model(){
        books = new ArrayList<>();
    }

    public void addBooks(String book){
        books.add(book);
    }

    public boolean removeBook(String book){
        return books.remove(book);
    }

    public List<String> getBooks(){
        return new ArrayList<>(books);
    }

    public String searchBook(String title){
        for(String book : books){
            if (book.equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }
}

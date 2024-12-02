import java.util.List;

public class View {
    public void displayBooks(List<String> books){
        if (books.isEmpty()){
            System.out.println("Магазин пуст.");
        }else {
            System.out.println("Список книг в магазине:");
            for(String book : books){
                System.out.println("/ " + book);
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

}

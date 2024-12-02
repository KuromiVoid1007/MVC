
import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private final Scanner scanner;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running){
            view.displayMessage("\nВыберите действие:\n" +
                    "1. Добавить книгу\n" +
                    "2. Удалить книгу\n" +
                    "3. Показать все книги\n" +
                    "4. Найти книгу\n" +
                    "5. Выйти");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> addBook();
                    case "2" -> removeBook();
                    case "3" -> displayAllBooks();
                    case "4" -> searchBook();
                }
        }


    }

    private void searchBook() {
        view.displayMessage("Введите название книги для поиска:");
        String title = scanner.nextLine();
        String foundBook = model.searchBook(title);
        if(foundBook != null){
            view.displayMessage("Найдена книга: \"" + foundBook);
        } else {
            view.displayMessage("Книга \"" + title + "\" не найдена.");
        }
    }

    private void displayAllBooks() {
        view.displayBooks(model.getBooks());
    }

    private void removeBook() {
        view.displayMessage("Введите название книги для удаления:");
        String book = scanner.nextLine();
        if (model.removeBook(book)){
            view.displayMessage("Книга \"" + book + "\" успешно удалена.");
        }else {
            view.displayMessage("Книга \"" + book + "\" не найдена.");
        }
    }

    private void addBook() {
        view.displayMessage("Введите название книги для добавления:");
        String book = scanner.nextLine();
        model.addBooks(book);
        view.displayMessage("Книга \"" + book + "\" успешно добавлена.");
    }
}

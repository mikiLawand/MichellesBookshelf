import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //inicializando a lista de livros da biblioteca
        List<Books> bookshelf = new ArrayList<>();
        //inicializando o scanner para receber dados 
        Scanner scanner = new Scanner(System.in);
        int choice;

        do { //faça,
            showMenu(); //mostre menu
            choice = scanner.nextInt(); //leia a escolha do usuario
            scanner.nextLine(); //lê a proxima linha de entrada

            switch (choice) {
                case 1:
                  addBook(scanner, bookshelf);
                  break;
                case 2:
                  searchBook(scanner, bookshelf);
                  break;
                case 3:
                  readingList(scanner, bookshelf);
                  break;
                case 0:
                  System.out.println("Exiting menu...");
                  break;
                default:
                  System.out.println("Invalid option!");
                  break;
            }

            System.out.println();
        } while (choice != 0);

          scanner.close();
    }

    public static void showMenu() { //vizualizando o menu
        System.out.println("Welcome to Michelle's bookshelf <3 ");
        System.out.println("Choose an option: ");
        System.out.println("1.Add a new book");
        System.out.println("2.Search for an book");
        System.out.println("3.Visualize reading list");
        System.out.println("0.Exit menu");
    }

    //passando a lista da biblioteca como parametro 
    //para que ela possa ser usada dentro desse metodo
    private static void addBook(Scanner scanner, List<Books> bookshelf) {

        System.out.println("Type book title: ");
        String title = scanner.nextLine();
        //lendo o a variavel do tipo string que o usuario digitou

        System.out.println("Type author's name: ");
        String author = scanner.nextLine();

        System.out.println("Type genre: ");
        String genre = scanner.nextLine();

        System.out.println("Type number of pages:  ");
        //se o usuario insere um dado que não seja uma int
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input."); //ele recebe essa mensagem 
            scanner.next();
        }
        int pages = scanner.nextInt();

        Books books = new Books(title, author, genre, pages);
        bookshelf.add(books);
        //adicionando o novo livro na lista 

        System.out.println("Book added successfully!");
    }

    private static void searchBook(Scanner scanner, List<Books> bookshelf) {

        System.out.println("Enter book title or author's name to be searched: ");
        String userSearch = scanner.nextLine();

        List<Books> BooksFound = new ArrayList<>();
        //inicalizando uma nova lista de livros encontrados pela pesquisa 

        for (Books books : bookshelf) {
            if (books.getTitle().equalsIgnoreCase(userSearch) ||
            //compara o titulo inserido com os dos livros da lista de livros
                 books.getAuthor().equalsIgnoreCase(userSearch)) {
                    BooksFound.add(books);
                 }
        }

       if (BooksFound.isEmpty()) {
            System.out.println("No books found with the search term" + userSearch);
        } else {
            System.out.println("Books found:");
            for (Books books : BooksFound) {
                System.out.println("Title: " + books.getTitle());
                System.out.println("Author: " + books.getAuthor());
                System.out.println("Genre: " + books.getGenre());
                System.out.println("Number of pages: " + books.getPages());
            }
        }
    }

    private static void readingList(Scanner scanner, List<Books> bookshelf) {

       if (bookshelf.isEmpty()) {
        System.out.println("The bookshelf is empty!");
       } else {
          System.out.println("Books on the shelf: ");
          for (Books books : bookshelf) {
                System.out.println("Title: " + books.getTitle());
                System.out.println("Author: " + books.getAuthor());
                System.out.println("Genre: " + books.getGenre());
                System.out.println("Number of pages: " + books.getPages());
          }
       }
    } 

    public static class Books {
    
        private String title;
        private String author;
        private String genre;
        private int pages;
        
        public Books(String title, String author, String genre, int pages) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.pages = pages;
        }
        
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public void setAuthor(String author) {
            this.author = author;
        }
    
        public String getGenre() {
            return genre;
        }
    
        public void setGenre(String genre) {
            this.genre = genre;
        }
    
        public int getPages() {
            return pages;
        }
    
        public void setPages(int pages) {
            this.pages = pages;
        }
     
    
    }

  }




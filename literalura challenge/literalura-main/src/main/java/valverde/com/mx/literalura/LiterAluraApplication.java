package valverde.com.mx.literalura;

import valverde.com.mx.literalura.models.Author;
import valverde.com.mx.literalura.models.Book;
import valverde.com.mx.literalura.models.LanguageT;
import valverde.com.mx.literalura.services.AuthorService;
import valverde.com.mx.literalura.services.BookService;
import valverde.com.mx.literalura.services.LanguageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import valverde.com.mx.literalura.util.Colors;

import java.util.*;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    private final BookService bookService;

    private final AuthorService authorService;

    private final LanguageService languageService;

    private static final String LINE_SEPARATOR = "\n============================================================================";

    public LiterAluraApplication(BookService bookService, AuthorService authorService, LanguageService languageService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.languageService = languageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            printMenuPrincipal();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    printSubmenuConsultar(scanner);
                    break;
                case 2:
                    printSubmenuInsertar(scanner);
                    break;
                case 3:
                    printSubmenuEstadisticas(scanner);
                    break;
                case 0:
                    System.out.println("Salir del programa. Adios!");
                    exit = true;
                    break;
                default:
                    System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa una opción valida"+ Colors.ANSI_RESET);
                    return;
            }

        }
    }

    private void printHeader() {
        System.out.println(Colors.ANSI_GREEN +"\n+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN +"|-----------------            Bienvenid@ al            --------------------|"+ Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN +"|-----------------         Programa de la Libreria     --------------------|"+ Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN +"|-----------------            Menu Principal           --------------------|"+ Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
    }

    private void printMenuPrincipal() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printHeader();
            System.out.println(LINE_SEPARATOR);
            System.out.println(Colors.ANSI_BLUE +"\nSelecciona una opción: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"1) Consultar"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"2) Insertar"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"3) Estadísticas"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"0) Salir"+ Colors.ANSI_RESET);
            System.out.println(LINE_SEPARATOR);
            
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    printSubmenuConsultar(scanner);
                    break;
                case 2:
                    printSubmenuInsertar(scanner);
                    break;
                case 3:
                    printSubmenuEstadisticas(scanner);
                    break;
                case 0:
                    System.out.println("\n"+ Colors.ANSI_YELLOW +"Gracias por utilizar el programa ... saliendo. Adios!"+ Colors.ANSI_RESET);
                    System.exit(-1);
                default:
                    System.out.println("\n"+ Colors.ANSI_PURPLE+"Opción invalida, intenta de nuevo"+ Colors.ANSI_RESET);
            }
        }
        scanner.close();
    }

    private void printSubmenuConsultar(Scanner scanner) throws Exception {
        boolean exit = false;
        while(!exit){
            System.out.println(LINE_SEPARATOR);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"|-----------------            Submenu Consultar            ----------------|"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"\nSelecciona una opción: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"1) Consulta Libro por título"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"2) Consulta todos los Libros"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"3) Consulta todos los Autores"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"4) Consulta de autores vivos en un determinado año"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"5) Consulta Libro en un determinado idioma"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"6) Consulta Autor por nombre"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"7) Consulta Autores por año de nacimiento"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"8) Consulta Autores por año de fallecimiento"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"0) Regresar al menú principal"+ Colors.ANSI_RESET);
            System.out.println(LINE_SEPARATOR);

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta Libro por su título: " + Colors.ANSI_RESET);
                    String title = scanner.nextLine();
                    if(!title.isEmpty() || title != null){
                        Book book = bookService.findBookByTitle(title);
                        if(book == null){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado: " + book);
                        }
                    } else {
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa un valor, intenta de nuevo"+ Colors.ANSI_RESET);
                    }
                    break;
                case 2:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta todos los libros: " + Colors.ANSI_RESET);
                    String allBooks = bookService.findAllBooks();
                    if(allBooks == null || allBooks.isEmpty()){
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                    } else {
                        System.out.println("Resultado: " + allBooks);
                    }
                    break;
                case 3:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta todos los Autores: " + Colors.ANSI_RESET);
                    List<Author> authors = authorService.getAllAuthors();
                    if(authors.isEmpty()){
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                    } else {
                        System.out.println("Resultado: " + authors);
                    }
                    break;
                case 4:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta de autores vivos en un determinado año: " + Colors.ANSI_RESET);
                    String aliveYear = scanner.nextLine();
                    if(aliveYear != null) {
                        List<Author> authorsAliveInYear = authorService.getAuthorsAliveInYear(Integer.parseInt(aliveYear));
                        if(authorsAliveInYear.isEmpty()){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado de autores vivos en el año seleccionado: " + authorsAliveInYear);
                        }
                    } else {
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa un valor, intenta de nuevo"+ Colors.ANSI_RESET);
                    }
                    break;
                case 5:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta por uno o dos idiomas del libro separados por coma, ejemplo: en,es: " + Colors.ANSI_RESET);
                    String languages = scanner.nextLine();
                    if (languages != null) {
                        String booksByLanguage = bookService.findBooksByLanguages(languages);
                        if(booksByLanguage == null){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado de libros por su idioma: " + booksByLanguage);
                        }
                    } else {
                        System.out.println("\n" + Colors.ANSI_PURPLE + "Ingresa 2 valores en formato de idioma en,es" + Colors.ANSI_RESET);
                    }
                    break;
                case 6:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta autor por nombre: " + Colors.ANSI_RESET);
                    String name = scanner.nextLine();
                    if(!name.isEmpty() || name != null) {
                        List<Author> authorsByName = authorService.getAuthorsByName(name);
                        if(authorsByName.isEmpty()){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado: " + authorsByName);
                        }
                    } else {
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa un valor, intenta de nuevo"+ Colors.ANSI_RESET);
                    }
                    break;
                case 7:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta autor por año de nacimiento: " + Colors.ANSI_RESET);
                    String birthYear = scanner.nextLine();
                    if(birthYear.isEmpty() || birthYear == null){
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa un valor, intenta de nuevo"+ Colors.ANSI_RESET);
                    } else {
                        List<Author> birthYearAuthors = authorService.getAuthorsByBirthYear(Integer.parseInt(birthYear));
                        if(birthYearAuthors.isEmpty()){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado: " + birthYearAuthors);
                        }
                    }
                    break;
                case 8:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Consulta autor por año de fallecimiento: " + Colors.ANSI_RESET);
                    String deathYear = scanner.nextLine();
                    if(deathYear.isEmpty() || deathYear == null){
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"Ingresa un valor, intenta de nuevo"+ Colors.ANSI_RESET);
                    } else {
                        List<Author> deathYearAuthors = authorService.getAuthorsByDeathYear(Integer.parseInt(deathYear));
                        if(deathYearAuthors.isEmpty()){
                            System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                        } else {
                            System.out.println("Resultado: " + deathYearAuthors);
                        }
                    }
                    break;
                default:
                    System.out.println("\n" + Colors.ANSI_PURPLE + "Opción invalida, intenta de nuevo" + Colors.ANSI_RESET);
            }

        }

    }

    private void printSubmenuInsertar(Scanner scanner) {
        boolean exit = false;
        while(!exit){
            System.out.println(LINE_SEPARATOR);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"|-----------------            Submenu Insertar         --------------------|"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"\nSelecciona una opción: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"1) Insertar Libro: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"0) Regresar al menú principal"+ Colors.ANSI_RESET);
            System.out.println(LINE_SEPARATOR);

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("\n" + Colors.ANSI_CYAN + "Insertar los datos del libro y del autor: " + Colors.ANSI_RESET);
                    Book book = getBook();
                    bookService.saveBook(book);
                    break;
                default:
                    System.out.println("\n" + Colors.ANSI_PURPLE + "Opción invalida, intenta de nuevo" + Colors.ANSI_RESET);
            }

        }
    }

    private void printSubmenuEstadisticas(Scanner scanner) throws Exception {
        boolean exit = false;
        while(!exit){
            System.out.println(LINE_SEPARATOR);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"|-----------------            Submenu Estadísticas     --------------------|"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_GREEN +"+--------------------------------------------------------------------------+"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"\nSelecciona una opción: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"1) Top 10 libros más descargados: "+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE +"0) Regresar al menú principal"+ Colors.ANSI_RESET);
            System.out.println(LINE_SEPARATOR);

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    List<Book> books = bookService.findTop10MostDownloadedBooks();
                    if(books == null || books.isEmpty()){
                        System.out.println("\n"+ Colors.ANSI_PURPLE+"No se encontraron registros"+ Colors.ANSI_RESET);
                    } else {
                        System.out.println("Top 10 de los libros más descargados: ");
                        books.forEach(book ->
                                System.out.println(book.getTitle() + " - Descargas: " + book.getDownloadCount()));
                    }
                    break;
                default:
                    System.out.println("\n" + Colors.ANSI_PURPLE + "Opción invalida, intenta de nuevo" + Colors.ANSI_RESET);
            }

        }
    }

    private Book getBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Ingresa el titulo: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Ingresa el idioma: ");
        LanguageT language = new LanguageT();
        language.setCode(scanner.nextLine());
        List<LanguageT> languages = new ArrayList<>();
        languages.add(language);
        languageService.saveLanguage(language);
        book.setLanguages(languages);
        System.out.print("El libro tiene copyright? (true/false): ");
        book.setCopyright(scanner.nextBoolean());
        System.out.print("Ingresa el número de descargas: ");
        book.setDownloadCount(scanner.nextInt());

        scanner.nextLine();
        Author author = new Author();
        System.out.print("Ingresa el nombre del autor: ");
        author.setName(scanner.nextLine());
        System.out.print("Ingresa el año de nacimiento del autor: ");
        author.setBirthYear(scanner.nextInt());
        System.out.print("Ingresa el año de fallecimiento del autor: ");
        author.setDeathYear(scanner.nextInt());
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authorService.saveAuthor(author);
        book.setAuthors(authors);
        return book;
    }

}

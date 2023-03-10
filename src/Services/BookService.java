package Services;

import Models.Book;
import Repositories.Interfaces.IBookRepository;
import Services.Interfaces.IBookService;
import UnitOfWork.UnitOfWork;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
    private IBookRepository bookRepository;
    public BookService(UnitOfWork unitOfWork) {
        this.bookRepository = unitOfWork.getBookRepository();
    }

    public int addBook(String title, String author, String publisher, String ISBN, String releaseYear) {
        var book = new Book(title, author, publisher, ISBN, releaseYear);
        return bookRepository.addBook(book);
    }

    public void editBook(int id, String title, String author, String publisher, String ISBN, String releaseYear){
        var book = new Book(id, title, author, publisher, ISBN, releaseYear);
        bookRepository.updateBook(book);
    }

    public void deleteBook(int bookID){
        bookRepository.deleteBook(bookID);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }
}

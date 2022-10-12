package Com.Book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Com.Book.Dao.BookRepo;
import Com.Book.Entity.Book;
import Com.Book.Exception.BookNotFoundException;


@Service
public class BookService {
	@Autowired
	BookRepo bookRepo;

	public Book createbook(Book book) {
		return this.bookRepo.save(book);
	}

	public List<Book> savebooks(List<Book> books) {
		return this.bookRepo.saveAll(books);
	}

	public List<Book> getBooks() {
		return this.bookRepo.findAll();
	}

	public Book getBookById(int book_Id) {
		

		return this.bookRepo.findById(book_Id)
				.orElseThrow(() -> new BookNotFoundException("Book Not Found","ID :",book_Id));
	}

	public Optional<Book> deleteBook(Book book, int book_Id) {
		book.setBook_Id(book_Id);
		Optional<Book> existingbook = bookRepo.findById(book.getBook_Id());
		if (existingbook.isPresent()) {
			bookRepo.deleteById(book_Id);
		} else {

			throw new BookNotFoundException("Book Not Found", "ID:", book.getBook_Id());
		}
		return existingbook;
	}


	public Book updateBook(Book book)  {
		if (bookRepo.existsById(book.getBook_Id())) {
			return bookRepo.save(book);
		}
		else {
			throw new BookNotFoundException("Book Not Found", "ID",book.getBook_Id());
		}	
     }
}
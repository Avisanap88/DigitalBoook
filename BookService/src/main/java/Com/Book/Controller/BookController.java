package Com.Book.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Book.Entity.Book;
import Com.Book.Service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {
	  @Autowired
	  private BookService bkService;

	    @PostMapping("/createbook")
	    public Book addBook(@RequestBody Book book) {
	        return this.bkService.createbook(book);
	    }

	    @PostMapping("/createlistBooks")
	    public List<Book> addBooks(@RequestBody List<Book> books) {
	        return this.bkService.savebooks(books);
	    }

	    @GetMapping("/getbooks")
	    public List<Book> findAllBooks() {
	        return this.bkService.getBooks();
	    }

	    @GetMapping("/bookById/{book_Id}")
	    public Book findBookById(@PathVariable int book_Id) {
	        return this.bkService.getBookById(book_Id);
	    }

	    @PutMapping("/update")
	    public Book updateBook(@RequestBody Book book)
	    {
	        return this.bkService.updateBook(book);
	    }
	    
	    @DeleteMapping("/delete/{book_Id}")
	    public Optional<Book> deleteBook(@RequestBody Book book,@PathVariable("book_Id") int book_Id) {
	        return this.bkService.deleteBook(book, book_Id);
	    }
	    
	 

}

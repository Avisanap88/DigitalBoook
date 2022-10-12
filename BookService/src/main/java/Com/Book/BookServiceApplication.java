package Com.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Com.Book.Service.BookService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class BookServiceApplication implements CommandLineRunner {
	@Autowired
	private BookService service;

	@Override
	public void run(String... args) throws Exception {

	}
 

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}

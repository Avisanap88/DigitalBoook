package com.digitalbook.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.digitalbook.models.BookEntity;


import feign.Headers;

@FeignClient(name="BookService",url="localhost:9091")
public interface BookServiceClient {
	
	@GetMapping("/api/v1/digitalbooks/getbooks")
	List<BookEntity> getBooks();
	
	@PostMapping("/api/v1/digitalbooks/createbook")
	@Headers("Content-Type: application/json")
	BookEntity SaveBook(BookEntity book);
	
	@PutMapping("/api/v1/digitalbooks/update")
    @Headers("Content-Type: application/json")
	BookEntity updateBook(BookEntity book);
	
	
}

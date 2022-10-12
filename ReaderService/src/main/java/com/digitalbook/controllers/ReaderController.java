package com.digitalbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.Payloads.Response;
import com.digitalbook.entities.Reader;
import com.digitalbook.services.ReaderService;

@RestController
@RequestMapping("/api/v1/reader")
public class ReaderController {
	@Autowired
	ReaderService readerService;

	
	@PostMapping("/")
	public ResponseEntity<Reader> createReader(@RequestBody Reader reader){
		Reader createReader=this.readerService.createReader(reader);
		return new ResponseEntity<>(createReader,HttpStatus.CREATED);	
	}
	@PutMapping("/{readerid}")
	public ResponseEntity<Reader> updateReader(@RequestBody Reader reader,@PathVariable ("readerid")Integer rid){
		Reader updatedReader=this.readerService.updateReader(reader, rid);
		return ResponseEntity.ok(updatedReader);
	}
	@GetMapping("/")
	public ResponseEntity<List<Reader>> getAllReaders(){
		return ResponseEntity.ok(this.readerService.getAllReader());
	}
	
   @GetMapping("/{readerid}")
	public ResponseEntity<Reader> getSingleReader(@PathVariable int readerid){
	   return ResponseEntity.ok(this.readerService.getReaderById(readerid));

	}
   
   @DeleteMapping("/{readerid}")
   public ResponseEntity<?> deleteReader(@PathVariable ("readerid") int rid){
	   this.readerService.deleteReader(rid);
	   return new ResponseEntity<Response>(new Response("Reader Deleted Succesfully",true),HttpStatus.OK);
			   
   }
   
}
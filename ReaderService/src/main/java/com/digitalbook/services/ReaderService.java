package com.digitalbook.services;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.repositories.ReaderServiceRepository;
import  com.digitalbook.entities.Reader;
import com.digitalbook.exception.ReaderServiceException;


@Service
public class ReaderService {
	
	@Autowired
	ReaderServiceRepository readerrepo;

	public Reader createReader(Reader reader) {
		Reader savedreader=this.readerrepo.save(reader);
		return (savedreader);
	}

	public Reader updateReader(Reader reader,Integer readerid) {
		Reader oldreader=null;
		Optional<Reader>optional=this.readerrepo.findById(readerid);
	 if(optional.isPresent()) 
	        {
		 oldreader=optional.get();
		 oldreader.setReaderid(readerid);
		 oldreader.setName(reader.getName());
		 oldreader.setEmail(reader.getEmail());
		
				readerrepo.save(oldreader);
	}else {
		return new Reader();
	}
	return oldreader;
}



	public Reader getReaderById(Integer readerid) {
		return  this.readerrepo.findById(readerid).
                orElseThrow(()->new ReaderServiceException("Reader Not Found","readerid",readerid));
	
	}

	public List<Reader> getAllReader() {
		List<Reader> readers=this.readerrepo.findAll();
		return readers;
	}

	public void deleteReader(Integer readerid) {
		Optional<Reader> book=this.readerrepo.findById(readerid);
		if(book.isPresent())
		{
			Reader Rtb = book.get();
			this.readerrepo.delete(Rtb);
		}else {

		 throw new ReaderServiceException("Reader Not Found", "readerid", readerid);
		
	}
	}
}
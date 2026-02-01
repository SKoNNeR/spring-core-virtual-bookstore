package dev.fjlamela.springcore.service;

import java.util.List;
import java.util.Optional;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.repository.BookRepository;
import dev.fjlamela.springcore.service.exception.DuplicateBookException;

public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository= bookRepository;
	}
	
	public void addBook(Book book) {
		if (book == null) throw new IllegalArgumentException("ERROR: Book cannot be null");
		if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) throw new DuplicateBookException("ERROR: Book already exist");
		bookRepository.save(book);
	}
	
	public Optional<Book> findBookByIsbn(String isbn){
		return bookRepository.findByIsbn(isbn);
	}
	
	public List<Book> listBooks(){
		return bookRepository.findAll();
	}
}

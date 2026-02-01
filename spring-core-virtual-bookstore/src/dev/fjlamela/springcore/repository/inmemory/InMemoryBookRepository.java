package dev.fjlamela.springcore.repository.inmemory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.repository.BookRepository;

public class InMemoryBookRepository implements BookRepository {
	
	private Map<String, Book> books= new HashMap<>();
	
	
	@Override
	public Book save(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Optional<Book> findByIsbn(String isbn) {
		return Optional.ofNullable(books.get(isbn));
	}

	@Override
	public void deleteByIsbn(String isbn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

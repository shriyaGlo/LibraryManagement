package com.globallogic.LibraryManagement.dao;

import java.util.List;

import com.globallogic.LibraryManagement.entity.Book;

public interface BookDAO {
	
	public List<Book> getBookList();

	public void saveBook(Book book);

	public Book getBook(int id);

	public void deleteBook(int id);
}

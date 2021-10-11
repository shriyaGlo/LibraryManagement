package com.globallogic.LibraryManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.LibraryManagement.dao.BookDAO;
import com.globallogic.LibraryManagement.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDao;

	@Override
	@Transactional
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	@Transactional
	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}

	@Override
	@Transactional
	public Book getBook(int id) {
		return bookDao.getBook(id);
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}
}

package com.globallogic.LibraryManagement.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.LibraryManagement.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookList() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> root = cq.from(Book.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveBook(Book book) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(book);
	}

	@Override
	public Book getBook(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Book book = currentSession.get(Book.class, id);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

}

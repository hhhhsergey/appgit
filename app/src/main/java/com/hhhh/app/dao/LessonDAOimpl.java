package com.hhhh.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.hhhh.app.entity.Lesson;

@Component
public class LessonDAOimpl implements LessonDAO<Lesson> {

	// java ee pattern
	private EntityManager entityManager;

	public LessonDAOimpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Lesson findById(int id_math) {
		return Optional.ofNullable(entityManager.find(Lesson.class, id_math)).get();
	}

	@Override
	public List<Lesson> listAll() {
		Query query = entityManager.createQuery("SELECT e FROM Lesson e");
		return query.getResultList();
	}

	@Override
	public void save(Lesson lesson) {
		executeInsideTransaction(entityManager -> entityManager.persist(lesson));

	}

	// https://www.baeldung.com/java-dao-pattern

	@Override
	public void create(Lesson lesson) {
		// TODO Автоматически созданная заглушка метода

	}

	@Override
	public void delete(Lesson lesson) {
		// TODO Автоматически созданная заглушка метода

	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}

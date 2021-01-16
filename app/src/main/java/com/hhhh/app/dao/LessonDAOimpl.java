package com.hhhh.app.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hhhh.app.entity.Lesson;

@Repository
@Transactional
public class LessonDAOimpl implements LessonDAO<Lesson> {

	// java ee pattern
	private EntityManager entityManager;

	public LessonDAOimpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//not use
	public Lesson findById(int id_math) {
		return Optional.ofNullable(entityManager.find(Lesson.class, id_math)).get();
	}

	//use
	public List<Lesson> listAlllessonsByUsername(int id_user) {
		List <Lesson>allLessons = entityManager.createQuery("SELECT e FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Lesson.class).setParameter("id_user", id_user).getResultList();
		return allLessons;
//		List<Lesson> resultList = (List<Lesson>)query.getResultList();
//		return resultList;
	}

	//update
	@Override
	//not use
	public void save(Lesson lesson) {
		executeInsideTransaction(entityManager -> entityManager.persist(lesson));
	}

	@Override
	//use
	public void create(double rank,double rank_total,int id_user) {
		Date date=new Date();
		Lesson lesson=new Lesson(rank,rank_total,date,id_user);
		entityManager.persist(lesson);

	}

	//not use
	public void delete(Lesson lesson) {

	}

	//not use
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
	
	//use для создания урока (тотал лессон)
	//работает, при отсутствии lesson в базе возвращает пустой lesson
	public Lesson getLastLessonById_user(int id_user) {
		//		int lessonsNumber=entityManager.createQuery("SELECT COUNT(*) FROM math_table WHERE e.id_user=:id_user",Integer.class).setParameter("id_user", id_user).getSingleResult();
		long b=entityManager.createQuery("SELECT COUNT(*) FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Long.class)
				.setParameter("id_user", id_user).setMaxResults(1).getSingleResult();
		int a=(int)b;//query return type [class java.lang.Long]
		Lesson lesson=new Lesson();
		if (a>0)
			lesson=entityManager.createQuery("SELECT e FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Lesson.class)
			.setParameter("id_user", id_user).setMaxResults(1).getSingleResult();
		return lesson;
	}

	//use
	//для отображения в меню
	public List<Lesson> getLastFiveLessonsById_user(int id_user) {
		List<Lesson>lastlessons;
		long b=entityManager.createQuery("SELECT COUNT(*) FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Long.class)
				.setParameter("id_user", id_user).setMaxResults(1).getSingleResult();//TODO сингл результ и макс результ(1) не тафталогия?
		int a=(int)b;//query return type [class java.lang.Long]
		if (a>5) {
			a=5;
			lastlessons=entityManager.createQuery("SELECT e FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Lesson.class)
					.setParameter("id_user", id_user).setMaxResults(a).getResultList();
		}
		lastlessons=entityManager.createQuery("SELECT e FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Lesson.class)
				.setParameter("id_user", id_user).setMaxResults(a).getResultList();
		return lastlessons;
	}
	
	//use 
	//для расчета тотал ранк
	public int getLessonNumberById_user(int id_user) {
		long b=entityManager.createQuery("SELECT COUNT(*) FROM Lesson e WHERE e.id_user=:id_user order by id_math desc",Long.class)
				.setParameter("id_user", id_user).setMaxResults(1).getSingleResult();
		int a=(int)b;//query return type [class java.lang.Long]
		return a;
	}

}

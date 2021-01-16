package com.hhhh.app.dao;

public interface LessonDAO<Lesson> {

	void save(Lesson lesson);

	void create(double rank,double rank_total,int id_user);

}

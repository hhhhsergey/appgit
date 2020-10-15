package com.hhhh.app.dao;

import java.util.List;
import java.util.Optional;

public interface LessonDAO<Lesson> {

	Lesson findById(int id_math);

	List<Lesson>listAll();

	//or udpate
	void save(Lesson lesson);

	//or add
	void create(Lesson lesson);

	void delete(Lesson lesson);
}

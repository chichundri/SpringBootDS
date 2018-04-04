package com.mystore.dao;

import java.util.List;

import com.mystore.entities.Student;

public interface MyDao {

	List<Student> select(int id, String fromDate, String toDate);

}

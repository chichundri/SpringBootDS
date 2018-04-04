package com.mystore.service;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mystore.dao.MyDao;
import com.mystore.entities.Student;


@Service
public class MyServiceImpl implements MyService {

    @Inject
    private MyDao myDao;

    @Override
    public void handleProcess(int id, String fromDate, String toDate) {
         List<Student> myList = myDao.select(id,fromDate, toDate);
         for (Iterator<Student> iterator = myList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.getId());
			System.out.println(student.getName());
		}
    }

	@Override
	public void handleException(String fromDate, String toDate, Exception e) {
		System.out.println(e);
	}
}
package com.mystore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.mystore.entities.Student;

@Repository
@Transactional
public class MyDaoImpl implements MyDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> select(int id, String fromDate, String toDate){

        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByKey", Student.class);
        query.setParameter("id", id);
        List<Student> list = query.getResultList();
        return CollectionUtils.isEmpty(list) ? null : list;
    }

}
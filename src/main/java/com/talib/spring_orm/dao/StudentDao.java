package com.talib.spring_orm.dao;

import com.talib.spring_orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student) {
        Integer isInserted = (Integer) hibernateTemplate.save(student);
        return isInserted;
    }

    public Student getStudent(int studentId) {
        Student student = hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> students = hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Transactional
    public void delete(int studentId) {
        Student student = hibernateTemplate.get(Student.class, studentId);
        hibernateTemplate.delete(student);
    }

    @Transactional
    public void update(Student student) {
        hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}

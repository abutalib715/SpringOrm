package com.talib;

import com.talib.spring_orm.dao.StudentDao;
import com.talib.spring_orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        Student student = new Student(223, "Hasan", "Dhaka");
        studentDao.insert(student);

        System.out.println("Insertion done");
    }
}

package com.talib;

import com.talib.spring_orm.dao.StudentDao;
import com.talib.spring_orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);
        System.out.println("****** WELCOME TO SPRING ORM CONSOLE APP ******");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;
        while (go) {
            System.out.println("Press 1 for add new student");
            System.out.println("Press 2 for display all students");
            System.out.println("Press 3 for get single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 to exit");

            try {
                int input = Integer.parseInt(bufferedReader.readLine());
                switch (input) {
                    case 1:
                        // add new student
                        System.out.println("Insert student id: ");
                        int sid = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Insert student name: ");
                        String name = bufferedReader.readLine();
                        System.out.println("Insert student city: ");
                        String city = bufferedReader.readLine();

                        Student student = new Student(sid, name, city);
                        int count = studentDao.insert(student);

                        System.out.println(count + " student added");
                        System.out.println("****************************");
                        System.out.println();
                        break;
                    case 2:
                        // get all students

                        List<Student> students = studentDao.getAllStudents();
                        for (Student item : students)
                            System.out.println(item);

                        System.out.println("****************************");
                        System.out.println();
                        break;
                    case 3:
                        // get single student
                        System.out.println("Insert student id: ");
                        int studentId = Integer.parseInt(bufferedReader.readLine());

                        Student st = studentDao.getStudent(studentId);
                        System.out.println(st);

                        System.out.println("****************************");
                        System.out.println();
                        break;
                    case 4:
                        // delete student
                        System.out.println("Insert student id: ");
                        int studentId1 = Integer.parseInt(bufferedReader.readLine());
                        studentDao.delete(studentId1);

                        System.out.println("Student deleted successfully");
                        System.out.println("****************************");
                        System.out.println();
                        break;
                    case 5:
                        // update student

                        System.out.println("Insert student id: ");
                        int stId = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Insert student name: ");
                        String stName = bufferedReader.readLine();
                        System.out.println("Insert student city: ");
                        String stCity = bufferedReader.readLine();

                        Student student2 = new Student(stId, stName, stCity);
                        studentDao.update(student2);

                        System.out.println("Student updated successfully");
                        System.out.println("****************************");
                        System.out.println();
                        break;
                    case 6:
                        //exit
                        go = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input, please try again!");
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thank you for using my application");

//        Student student = new Student(223, "Hasan", "Dhaka");
//        studentDao.insert(student);
//        System.out.println("Insertion done");
    }
}

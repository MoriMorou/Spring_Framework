package ru.morou;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = null;

        Scanner in = new Scanner(System.in);

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            String msg = in.nextLine();
            if (msg.startsWith(Command.STUDENTS_COURSES.getText())) {
                String stud = msg.substring(Command.STUDENTS_COURSES.getText().length() + 1);
                int stud_id = Integer.parseInt(stud);
                Student student = session.get(Student.class, stud_id);
                System.out.println(student);
                session.getTransaction().commit();
            } else if (msg.startsWith(Command.COURSE_STUDENTS.getText())) {
                String curs = msg.substring(Command.COURSE_STUDENTS.getText().length() + 1);
                int curs_id = Integer.parseInt(curs);
                Course course = session.get(Course.class, curs_id);
                System.out.println(course);
                session.getTransaction().commit();
            } else if (msg.startsWith(Command.DELETE_ST.getText())) {
                String stud = msg.substring(Command.DELETE_ST.getText().length() + 1);
                int stud_id = Integer.parseInt(stud);
                Student student = session.get(Student.class, stud_id);
                session.delete(student);
                session.getTransaction().commit();
            } else if (msg.startsWith(Command.DELETE_COURSE.getText())) {
                String curs = msg.substring(Command.DELETE_COURSE.getText().length() + 1);
                int curs_id = Integer.parseInt(curs);
                Course course = session.get(Course.class, curs_id);
                session.delete(course);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
            factory.close();
        }
    }
}

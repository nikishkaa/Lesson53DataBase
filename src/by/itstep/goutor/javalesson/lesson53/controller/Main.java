package by.itstep.goutor.javalesson.lesson53.controller;

import by.itstep.goutor.javalesson.lesson53.dal.StudentDAO;
import by.itstep.goutor.javalesson.lesson53.model.entity.Group;
import by.itstep.goutor.javalesson.lesson53.model.entity.Student;
import by.itstep.goutor.javalesson.lesson53.model.logic.StudentManager;

public class Main {
    public static void main(String[] args) {
//        Student student1 = new Student("alex", 20, 9);
//        Student student2 = new Student("qwerty", 20, 7);
//        Student student3 = new Student("dsf", 20, 5);
//        Student student4 = new Student("frgtfg", 20, 3);
//        Student student5 = new Student("dfghttrqwaf", 20, 10);
//
//        Group group = new Group();
//        group.getList().add(student1);
//        group.getList().add(student2);
//        group.getList().add(student3);
//        group.getList().add(student4);
//        group.getList().add(student5);

        StudentDAO studentDAO = new StudentDAO();
        Group group = studentDAO.getAll();

        System.out.println(group);

        double avg = studentDAO.getAverageMark();
        System.out.print("Student avg mark " + avg + ".");



    }
}

package by.itstep.goutor.javalesson.lesson53.model.logic;

import by.itstep.goutor.javalesson.lesson53.model.entity.Group;
import by.itstep.goutor.javalesson.lesson53.model.entity.Student;

public class StudentManager {
    public static double calcAverageMark(Group group) {
        double avg = 0;
        for (Student student : group.getList()) {
            avg += student.getAvgMark();
        }

        return avg / group.getList().size();
    }
}

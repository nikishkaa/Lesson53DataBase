package by.itstep.goutor.javalesson.lesson53.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> list;

    public Group() {
        list = new ArrayList<>();
    }

    public Group(List<Student> list) {
        this.list = list;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Student student : list) {
            builder.append("\n").append(student);
        }

        return builder.toString();
    }
}

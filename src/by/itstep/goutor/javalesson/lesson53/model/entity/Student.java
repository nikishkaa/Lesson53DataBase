package by.itstep.goutor.javalesson.lesson53.model.entity;

public class Student {

    private String name;
    private int age;
    private double avgMark;

    public Student() {
        name = "ni name";
        age = 16;
        avgMark = 4;
    }

    public Student(String name, int age, double avgMark) {
        this.name = name;
        this.age = age;
        this.avgMark = avgMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public String toString() {
        return "Student { " +
                "name = " + name +
                ", age = " + age +
                ", avgMark = " + avgMark +
                '}';
    }
}

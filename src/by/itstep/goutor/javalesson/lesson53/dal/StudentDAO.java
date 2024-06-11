package by.itstep.goutor.javalesson.lesson53.dal;

import by.itstep.goutor.javalesson.lesson53.model.entity.Group;
import by.itstep.goutor.javalesson.lesson53.model.entity.Student;

import java.sql.*;

public class StudentDAO {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "11n11n11n";
    public static final String GET_ALL_SQL = "SELECT * FROM students ORDER BY name;";

    public void add(Student student) {


    }

    public void edit(int id, Student student) {


    }

    public void remove(int id) {


    }

    public Student get(int id) {

        return new Student();
    }

    public Group getAll() {
        Connection connection = null;
        Group group = new Group();

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);

            while (resultSet.next()) {
                Student student = new Student();

                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAvgMark(resultSet.getFloat("avg_mark"));

                group.getList().add(student);
            }

        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.out.println(exception);
                }
            }
        }


        return group;
    }

    public double getAverageMark() {

        return 0;
    }
}

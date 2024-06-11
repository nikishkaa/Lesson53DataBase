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
    public static final String GET_AVG_MARK = "SELECT AVG(avg_mark) as Average FROM students";
    public static final String REMOVE_STUDENT = "DELETE FROM students WHERE id_students = ?";
    public static final String ADD_STUDENT = "INSERT INTO students(name, age, avg_mark) values(?,?,?);";

    private Connection connection;

    public StudentDAO() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }


    public void add(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_STUDENT);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setDouble(3, student.getAvgMark());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public void edit(int id, Student student) {
        remove(id);
        add(student);

    }

    public void remove(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(REMOVE_STUDENT);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public Student get(int id) {

        return new Student();
    }

    public Group getAll() {
        Group group = new Group();

        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);

            while (resultSet.next()) {
                Student student = new Student();

                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAvgMark(resultSet.getFloat("avg_mark"));

                group.getList().add(student);
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }


        return group;
    }

    public double getAverageMark() {
        double avg = 0;
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_AVG_MARK);

            if (resultSet.next()) {
                avg = resultSet.getFloat("Average");
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }


        return avg;
    }

    protected void finalize() throws Throwable {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }

}

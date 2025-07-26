package dao;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // ✅ Registration: Save student name, roll number, password into the database
    public static boolean registerStudent(Student student) {
        boolean success = false;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO students (name, roll_no, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getRollNo());
            ps.setString(3, student.getPassword());
            ps.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // ✅ Login: Authenticate student using roll number and password
    public static Student loginStudent(String rollNo, String password) {
        Student student = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM students WHERE roll_no = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rollNo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getString("roll_no"));
                student.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}

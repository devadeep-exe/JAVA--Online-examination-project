package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Student;

public class ResultDAO {

    public static boolean saveResult(Student student, int score, double percentage) {
        String sql = "INSERT INTO results (id, name, roll_no, score, percentage) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getRollNo());
            ps.setInt(4, score);
            ps.setDouble(5, percentage);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

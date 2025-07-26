package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField rollNoField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login - Online Examination");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel headingLabel = new JLabel("Login");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(headingLabel, gbc);

        gbc.gridwidth = 1;

        JLabel rollNoLabel = new JLabel("Roll Number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(rollNoLabel, gbc);

        rollNoField = new JTextField(20);
        gbc.gridx = 1;
        add(rollNoField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String rollNo = rollNoField.getText();
            String password = new String(passwordField.getPassword());
            Student student = StudentDAO.loginStudent(rollNo, password);
            if (student != null) {
                dispose();
                new ExamFrame(student);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Roll Number or Password");
            }
        });

        setVisible(true);
    }
}

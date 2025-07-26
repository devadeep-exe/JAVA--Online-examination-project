
package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;

public class SignUpFrame extends JFrame {
    public SignUpFrame() {
        setTitle("Online Examination - Sign Up");
        setSize(400, 300);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 100, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 150, 25);
        add(nameField);

        JLabel rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(50, 70, 100, 25);
        add(rollLabel);

        JTextField rollField = new JTextField();
        rollField.setBounds(150, 70, 150, 25);
        add(rollField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 150, 25);
        add(passField);

        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(130, 170, 100, 30);
        add(signUpBtn);

        signUpBtn.addActionListener(e -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            String pass = new String(passField.getPassword());
            if (StudentDAO.registerStudent(new Student(name, roll, pass))) {
                JOptionPane.showMessageDialog(this, "Sign Up Successful!");
                dispose();
                new LoginFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Register.");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

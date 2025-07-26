package gui;

import javax.swing.*;

public class ResultFrame extends JFrame {
    public ResultFrame(int score, double percentage) {
        setTitle("Online Examination - Result");
        setSize(300, 200);
        setLayout(null);

        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(100, 30, 100, 25);
        add(scoreLabel);

        JLabel percentLabel = new JLabel("Percentage: " + String.format("%.2f", percentage) + "%");
        percentLabel.setBounds(80, 70, 150, 25);
        add(percentLabel);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(100, 120, 100, 30);
        add(logoutBtn);

        logoutBtn.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

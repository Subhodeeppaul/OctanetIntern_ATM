package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUser {

    JTextField pinField, atmField;
    Random random = new Random();

    public void addView() throws SQLException {
        Commons commons = new Commons();
        JFrame frame = new JFrame("Add User");
        Font txt = new Font("Arial", Font.BOLD, 16);
        SQLManage manage = new SQLManage();
        Success success = new Success();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 250)); 

        JLabel name = new JLabel("Name:");
        name.setFont(txt);
        name.setBounds(50, 30, 100, 25);
        JTextField nmField = new JTextField(20);
        nmField.setFont(txt);
        nmField.setBounds(50, 60, 300, 30);

        JLabel atmno = new JLabel("ATM Card Number:");
        atmno.setFont(txt);
        atmno.setBounds(50, 100, 200, 25);
        atmField = new JTextField(20);
        atmField.setEditable(false);
        atmField.setFont(txt);
        atmField.setBounds(50, 130, 300, 30);

        JLabel atmpin = new JLabel("ATM Card PIN:");
        atmpin.setFont(txt);
        atmpin.setBounds(50, 170, 200, 25);
        pinField = new JTextField(4);
        pinField.setEditable(false);
        pinField.setFont(txt);
        pinField.setBounds(50, 200, 150, 30);

        JLabel bal = new JLabel("Balance:");
        bal.setFont(txt);
        bal.setBounds(250, 170, 200, 25);
        JTextField balField = new JTextField(10);
        balField.setFont(txt);
        balField.setBounds(250, 200, 100, 30);

        auto();

        JButton sbmt = new JButton("Submit");
        sbmt.setFont(txt);
        sbmt.setBounds(50, 250, 150, 50);
        sbmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nmField.getText().isEmpty()) {
                    if (balField.getText().isEmpty())
                        balField.setText("0");
                    try {
                        manage.adding(atmField.getText(), pinField.getText(), nmField.getText(), balField.getText());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    success.detailView(atmField.getText(), pinField.getText());
                    balField.setText("");
                    nmField.setText("");
                    auto();
                }
            }
        });

        JButton closeBtn = new JButton("Close");
        closeBtn.setFont(txt);
        closeBtn.setBounds(250, 250, 100, 50);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(name);
        panel.add(nmField);
        panel.add(atmno);
        panel.add(atmField);
        panel.add(atmpin);
        panel.add(pinField);
        panel.add(bal);
        panel.add(balField);
        panel.add(sbmt);
        panel.add(closeBtn);

        frame.add(panel);
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void auto() {
        String str = "";
        for (int i = 0; i < 16; i++) {
            str += random.nextInt(9 - 0 + 1) + 0;
        }
        atmField.setText(str);
        str = "";
        for (int i = 0; i < 4; i++) {
            str += random.nextInt(9 - 0 + 1) + 0;
        }
        pinField.setText(str);
    }
}

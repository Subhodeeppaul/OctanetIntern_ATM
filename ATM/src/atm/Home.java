package atm;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home {
    public void homeView(int id) throws SQLException {
        Operations operations = new Operations();
        Font txt = new Font("", Font.BOLD, 32); 
        Commons commons = new Commons();
        JFrame frame = (JFrame) commons.Frame();
        frame.getContentPane().setBackground(java.awt.Color.BLACK);

       JLabel quick = new JLabel("< Transaction");
quick.setBounds(20, 20, 200, 30);
quick.setFont(new Font("", Font.BOLD, 18)); 
quick.setForeground(java.awt.Color.WHITE);

JLabel withdraw = new JLabel("Withdraw >");
withdraw.setBounds(300, 20, 200, 30); 
withdraw.setHorizontalAlignment(JLabel.RIGHT);
withdraw.setFont(new Font("", Font.BOLD, 18)); 
withdraw.setForeground(java.awt.Color.WHITE);

JLabel deposit = new JLabel("< Deposit");
deposit.setBounds(20, 60, 200, 30);
deposit.setFont(new Font("", Font.BOLD, 18)); 
deposit.setForeground(java.awt.Color.WHITE);

JLabel sts = new JLabel("Transaction History >");
sts.setBounds(300, 60, 200, 30);
sts.setHorizontalAlignment(JLabel.RIGHT);
sts.setFont(new Font("", Font.BOLD, 18)); 
sts.setForeground(java.awt.Color.WHITE);

JLabel bal = new JLabel("< Balance Enquiry");
bal.setBounds(20, 100, 200, 30);
bal.setFont(new Font("", Font.BOLD, 18)); 
bal.setForeground(java.awt.Color.WHITE);

JLabel pinchange = new JLabel("Change Pin >");
pinchange.setBounds(300, 100, 200, 30); 
pinchange.setHorizontalAlignment(JLabel.RIGHT);
pinchange.setFont(new Font("", Font.BOLD, 18));
pinchange.setForeground(java.awt.Color.WHITE);

JButton quitButton = new JButton("Quit");
quitButton.setBounds(20, 140, 120, 40); 
quitButton.setFont(new Font("", Font.BOLD, 18)); 


        frame.add(quick);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(sts);
        frame.add(bal);
        frame.add(pinchange);
        frame.add(quitButton); 
        frame.setSize(700, 300);
        frame.setLayout(null); 
        frame.setVisible(true);

        // Add action listener for the Quit button
        quitButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                frame.dispose();
            }
        });

        quick.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Quick qk = new Quick();
                try {
                    qk.quickView(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        withdraw.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Withdraw Amount", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        deposit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Deposit Amount", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        sts.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Statements state = new Statements();
                try {
                    state.stateView(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        bal.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("Balance", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        pinchange.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    operations.opView("New PIN", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
    }
}

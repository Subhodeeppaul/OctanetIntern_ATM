package atm;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fail {
	public void failView(String str) {
		Commons commons = new Commons();
		JFrame frame =(JFrame) commons.Frame();
		JLabel fail = new JLabel("YOUR TRANSACTIONS FAILED!!!");
		fail.setBounds(0, 280, 600, 50);
		fail.setHorizontalAlignment(JLabel.CENTER);
		fail.setFont(new Font("Rockwell", Font.BOLD, 25));
                frame.getContentPane().setBackground(java.awt.Color.BLACK);
		JLabel st = new JLabel(str);
		st.setBounds(0, 320, 600, 50);
		st.setHorizontalAlignment(JLabel.CENTER);
		st.setFont(new Font("Rockwell", Font.BOLD, 25));
		frame.add(st);
		frame.add(fail);
		
		frame.setVisible(true);
	}
}
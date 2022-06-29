package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel{
	private MainFrame start;
	private JLabel user, userMessage, wMessage;
	private JButton update, logout;
	
	public UserPanel(MainFrame start) {
		this.start = start;
		setLayout(null);
		
		JLabel user = new JLabel("학번/이름" + "님");

		user.setFont(new Font("Arial", Font.ITALIC, 50));
		user.setBounds(380, 220, 250, 60);
		add(user);
		
		JLabel wMessage = new JLabel("환영합니다 (ง˙∇˙)ว");
		wMessage.setFont(new Font("Arial", Font.ITALIC, 80));
		wMessage.setBounds(210, 320, 600, 80);
		add(wMessage);
		
		
		String updateButton = "Update";
		update = new JButton(updateButton);
		update.setBounds(300, 470, 150, 50);
		update.addActionListener(loginListener);
		add(update);
		
		
		String logoutButton = "Logout";
		logout = new JButton(logoutButton);
		logout.setBounds(530, 470, 150, 50);
		logout.addActionListener(loginListener);
		add(logout);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Update")) {
        		start.change("UpdateInfoPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        	else if(input.equals("Logout")) {
        		start.change("LoginPanel");
        	}
        }
    };
}

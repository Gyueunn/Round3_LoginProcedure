package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserPanel extends JPanel{
	private JLabel user, userMessage, wMessage;
	private JButton update, logout;
	static String[] userInfo  = new String [4];
	
	public UserPanel() {
		setLayout(null);
		
		JLabel user = new JLabel(MainFrame.userId + "님");

		user.setFont(new Font("Arial", Font.ITALIC, 50));
		user.setBounds(380, 220, 300, 60);
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
		MainFrame.frame.add(this);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Update")) {
        		userInfo = ConnectMysql.selectUser(MainFrame.userId);
        		new UpdateInfoPanel();
        		UserPanel.this.setVisible(false);
        		System.out.println(userInfo[0] +userInfo[1] + userInfo[2] + userInfo[3]);
        	}
        	else if(input.equals("Logout")) {
        		MainFrame.userId = "";
        		JOptionPane.showMessageDialog(null, "Logout 되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		new LoginPanel();
        		UserPanel.this.setVisible(false);
        	}
        }
    };
}

package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPanel extends JPanel {
	private JLabel title;
	private JPanel content;
	private JTextField inputUser;
	private JButton deleteUser, logout;
	
	public AdminPanel() {
		setLayout(null);
		
		title = new JLabel("Adamin Page");
		title.setFont(new Font("Arial", Font.ITALIC, 60));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(250, 50, 500, 100);
		add(title);
		
		
		content = new JPanel();
		content.setBounds(250, 50, 500, 100);
		content.setBackground(Color.CYAN);
		add(content);
		
		
		inputUser = new JTextField();
		inputUser.setBounds(330, 560, 150, 50);
		add(inputUser);
		

		deleteUser = new JButton("계정 삭제");
		deleteUser.setBounds(530, 560, 150, 50);
		deleteUser.addActionListener(loginListener);
		add(deleteUser);
		
		logout = new JButton("Logout");
		logout.setBounds(430, 615, 150, 25);
		logout.addActionListener(loginListener);
		add(logout);
		MainFrame.frame.add(this);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("계정 삭제")) {
        		int var = JOptionPane.showConfirmDialog(null, "정말로 계정을 삭제하시겠습니까?", "MESSAGE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
				if(var==0) {
					ConnectMysql.deleteUser(inputUser.getText());
					JOptionPane.showMessageDialog(null, "계정이 삭제되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					MainFrame.userId = "";
				}
				else JOptionPane.showMessageDialog(null, "계정이 삭제를 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				
        	}
        	else if(input.equals("Logout")) {
        		inputUser.setText(null);
        		JOptionPane.showMessageDialog(null, "Logout 되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		new LoginPanel();
        		AdminPanel.this.setVisible(false);
        	}
        }
    };
}

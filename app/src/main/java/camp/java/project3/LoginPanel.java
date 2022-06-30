package camp.java.project3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	private int attemptCount = 0;
	private JLabel findPW;
	private JTextField idField;
	private JPasswordField pwField;
	private JButton loginButton, findPwButton, signUpButton;
	
	public LoginPanel() {
		setLayout(null);
		findPW = new JLabel("Login");
		findPW.setFont(new Font("Arial", Font.ITALIC, 80));
		findPW.setHorizontalAlignment(JLabel.CENTER);
		findPW.setBounds(250, 160, 500, 100);
		add(findPW);
		
		//학번 
		JLabel studentID = new JLabel("Student ID : ");
		studentID.setBounds(280, 290, 100, 40);
		add(studentID);
		
		idField = new JTextField();
		idField.setBounds(480, 290, 240, 40);
		add(idField);
		
		//이름 
		JLabel pw = new JLabel("PW : ");
		pw.setBounds(280, 340, 100, 40);
		add(pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(480, 340, 240, 40);
		add(pwField);
		
		//버튼 
		String loginString = "Login";
		loginButton = new JButton(loginString);
		loginButton.setBounds(350, 410, 300, 50);
		loginButton.addActionListener(loginListener);
		add(loginButton);
		
		String findPwString = "Find PW";
		findPwButton = new JButton(findPwString);
		findPwButton.setBounds(320, 470, 150, 30);
		findPwButton.addActionListener(loginListener);
		add(findPwButton);
		
		String signUpString = "Sign Up";
		signUpButton = new JButton(signUpString);
		signUpButton.setBounds(520, 470, 150, 30);
		signUpButton.addActionListener(loginListener);
		add(signUpButton);
		this.setVisible(true);
		MainFrame.frame.add(this);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Login")) {
        		if(idField.getText().isEmpty() || pwField.getText().isEmpty()) {
            		JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            	}
        		else {
        			ConnectMysql.select(idField.getText(), pwField.getText());
        			if(MainFrame.userId.equals("Adminid")) {
        				
        				
        				
        				
        				
        				
        				JOptionPane.showMessageDialog(null, "관리자로 로그인 되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        				idField.setText(null);
            			pwField.setText(null);
        				new AdminPanel();
        				LoginPanel.this.setVisible(false);
        			}
        			else {
        				if(ConnectMysql.loginSuccess == 1) {
            				MainFrame.userId = idField.getText();
            				JOptionPane.showMessageDialog(null, "로그인 되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            				idField.setText(null);
                			pwField.setText(null);
                			new UserPanel();
                			LoginPanel.this.setVisible(false);
            			}
            			else {
            				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            			}
        			}
        		}
        	}
        	else if(input.equals("Find PW")) {
        		idField.setText(null);
    			pwField.setText(null);
    			new FindPwPanel();
    			LoginPanel.this.setVisible(false);
        	}
        	else if(input.equals("Sign Up")) {
        		idField.setText(null);
    			pwField.setText(null);
    			new JoinPanel();
    			LoginPanel.this.setVisible(false);
        	}
        }
    };
}

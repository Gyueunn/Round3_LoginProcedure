package camp.java.project3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ChangePwPanel extends JPanel{
	private MainFrame start;
	
	private JLabel chagePW;
	private JPasswordField pwField, cpwField;
	private JLabel check;
	private JButton ok, pwCheck;
	
	public ChangePwPanel(MainFrame start) {
		this.start = start;
		setLayout(null);
		
		chagePW = new JLabel("Change PW");
		chagePW.setFont(new Font("Arial", Font.ITALIC, 60));
		chagePW.setHorizontalAlignment(JLabel.CENTER);
		chagePW.setBounds(250, 140, 500, 100);
		add(chagePW);
		
		//비밀번호 
		JLabel pw = new JLabel("PW : ");
		pw.setBounds(280, 270, 100, 40);
		add(pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(480, 270, 240, 40);
		add(pwField);
		
		//비밀번호 확인 
		JLabel confirmPW = new JLabel("Confirm PW : ");
		confirmPW.setBounds(280, 330, 100, 40);
		add(confirmPW);
		
		cpwField = new JPasswordField();
		cpwField.setBounds(480, 330, 240, 40);
		add(cpwField);
		
		String pwCheckButton = "확인";
		pwCheck = new JButton(pwCheckButton);
		pwCheck.setBounds(730, 330, 40, 40);
		pwCheck.addActionListener(loginListener);
		add(pwCheck);
		
		//확인이 맞는지 확인 
		check = new JLabel("입력하세요");
		check.setBounds(500, 365, 240, 40);
		add(check);
		
		String okButton = "Okey";
		ok = new JButton(okButton);
		ok.setBounds(420, 450, 150, 50);
		ok.addActionListener(loginListener);
		add(ok);
	}
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("확인")) {
        		start.change("LoginPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        	else if(input.equals("Okey")) {
        		start.change("LoginPanel");
        	}
        }
    };
}

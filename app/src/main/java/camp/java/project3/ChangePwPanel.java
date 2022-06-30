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

public class ChangePwPanel extends JPanel{
	private JLabel chagePW;
	private JPasswordField pwField, cpwField, newPwField;
	private JLabel check;
	private JButton ok, pwCheck;
	private boolean pwDuplicate = false;
	
	public ChangePwPanel() {
		setLayout(null);
		
		chagePW = new JLabel("Change PW");
		chagePW.setFont(new Font("Arial", Font.ITALIC, 60));
		chagePW.setHorizontalAlignment(JLabel.CENTER);
		chagePW.setBounds(250, 140, 500, 100);
		add(chagePW);
		
		JLabel pw = new JLabel("PW : ");
		pw.setBounds(280, 250, 100, 40);
		add(pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(480, 250, 240, 40);
		add(pwField);
		
		
		
		//비밀번호 
		JLabel newPw = new JLabel("New PW : ");
		newPw.setBounds(280, 310, 100, 40);
		add(newPw);
		
		newPwField = new JPasswordField();
		newPwField.setBounds(480, 310, 240, 40);
		add(newPwField);
		
		//비밀번호 확인 
		JLabel confirmPW = new JLabel("Confirm PW : ");
		confirmPW.setBounds(280, 370, 100, 40);
		add(confirmPW);
		
		cpwField = new JPasswordField();
		cpwField.setBounds(480, 370, 240, 40);
		add(cpwField);
		
		String pwCheckButton = "확인";
		pwCheck = new JButton(pwCheckButton);
		pwCheck.setBounds(730, 370, 40, 40);
		pwCheck.addActionListener(loginListener);
		add(pwCheck);
		
		//확인이 맞는지 확인 
		check = new JLabel("입력하세요");
		check.setBounds(500, 400, 240, 40);
		add(check);
		
		String okButton = "Okey";
		ok = new JButton(okButton);
		ok.setBounds(420, 450, 150, 50);
		ok.addActionListener(loginListener);
		add(ok);
		MainFrame.frame.add(this);
	}
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if((e.getSource() == pwCheck)){
                	String pw = new String(pwField.getPassword());
                	String cpw = new String(cpwField.getPassword());
            		if(!pw.equals(cpw)) {
            			check.setText("불일치합니다.");
            			cpwField.setText(null);
            			pwField.setText(null);
            		}
            		else {
            			check.setText("일치합니다.");
            			pwDuplicate=true;
            		}
        	}
        	else if(input.equals("Okey")) {
        		if(pwDuplicate==true) {
        			pwField.setText(null);
        			cpwField.setText(null);
        			JOptionPane.showMessageDialog(null, "PW를 변경했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        			new LoginPanel();
        			ChangePwPanel.this.setVisible(false);
        		}
        	}
        }
    };
}

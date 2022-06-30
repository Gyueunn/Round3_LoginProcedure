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
	private JTextField idField;
	private JPasswordField cpwField, newPwField;
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
		
		JLabel id = new JLabel("Student ID : ");
		id.setBounds(280, 250, 100, 40);
		add(id);
		
		idField = new JTextField();
		idField.setBounds(480, 250, 240, 40);
		add(idField);

		
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
                	String nPw = new String(newPwField.getPassword());
                	String cpw = new String(cpwField.getPassword());
            		if(!nPw.equals(cpw)) {
            			check.setText("불일치합니다.");
            			cpwField.setText(null);
            			idField.setText(null);
            			newPwField.setText(null);
            		}
            		else {
            			check.setText("일치합니다.");
            			pwDuplicate=true;
            		}
        	}
        	else if(input.equals("Okey")) {
        		ConnectMysql.select(idField.getText()); //아이디가 존재하는지 확인 필요 
    			if(pwDuplicate == false || idField.getText().isEmpty()) {
    				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
    			}
    			else {
    				if(ConnectMysql.selectId==1) {
						ConnectMysql.updateInfo(idField.getText(),newPwField.getText());
						JOptionPane.showMessageDialog(null, "PW 변경이 완료되었습니다!", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
						cpwField.setText(null);
						idField.setText(null);
						check.setText("입력하세요");
						newPwField.setText(null);
						new LoginPanel();
						pwDuplicate=false;
						ChangePwPanel.this.setVisible(false);
    				}
    				else {
    					JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
    					cpwField.setText(null);
						idField.setText(null);
						pwDuplicate=false;
						check.setText("입력하세요");
						newPwField.setText(null);
    				}
    			}

        	}
        }
    };
}

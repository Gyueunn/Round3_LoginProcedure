package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateInfoPanel extends JPanel{
private MainFrame start;
	
	private JTextField emailField, nameField;
	private JPasswordField pwField, cpwField;
	private JButton cancel, update, pwCheck, dropOut;
	private JLabel idField, birthField, correct;
	JComboBox<String> majorBox;
	private boolean pwDuplicate = false;
	private String[] user  = new String [4];
	
	public UpdateInfoPanel() {
		setLayout(null);
		user = UserPanel.userInfo;
		JLabel sign = new JLabel("Update Info");
		sign.setFont(new Font("Arial", Font.ITALIC, 60));
		sign.setHorizontalAlignment(JLabel.CENTER);
		sign.setBounds(250, 50, 500, 100);
		add(sign);
		
		//학번 
		JLabel studentID = new JLabel("Student ID : ");
		studentID.setBounds(280, 160, 100, 40);
		add(studentID);
		
		idField = new JLabel(MainFrame.userId);
		idField.setBounds(480, 160, 240, 40);
		add(idField);
		
		//이름 
		JLabel name = new JLabel("Name : ");
		name.setBounds(280, 210, 100, 40);
		add(name);
		
		nameField = new JTextField(user[0]);
		nameField.setBounds(480, 210, 240, 40);
		add(nameField);
		
		//비밀번호 
		JLabel pw = new JLabel("PW : ");
		pw.setBounds(280, 260, 100, 40);
		add(pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(480, 260, 240, 40);
		add(pwField);
		
		//비밀번호 확인 
		JLabel confirmPW = new JLabel("Confirm PW : ");
		confirmPW.setBounds(280, 320, 100, 40);
		add(confirmPW);
		
		cpwField = new JPasswordField();
		cpwField.setBounds(480, 320, 240, 40);
		add(cpwField);
		
		String pwCheckButton = "확인";
		pwCheck = new JButton(pwCheckButton);
		pwCheck.setBounds(730, 320, 40, 40);
		pwCheck.addActionListener(loginListener);
		add(pwCheck);
		
		//확인이 맞는지 확인 
		correct = new JLabel("입력하세요");
		correct.setBounds(500, 350, 240, 40);
		add(correct);
				 
		//생년월일 
		JLabel birth = new JLabel("Date of Birth (YYMMDD) : ");
		birth.setBounds(280, 400, 170, 40);
		add(birth);
		
		birthField = new JLabel(user[1]);
		birthField.setBounds(480, 400, 240, 40);
		add(birthField);
		
		//학부 
		JLabel major = new JLabel("Major : ");
		major.setBounds(280, 440, 100, 40);
		add(major);
		
		
		String majorCombo[] = {"선택...", "글로벌 리더십학부", "국제어문학부", "경영경제학부", "법학부", "커뮤니케이션학부", "공간환경시스템공학부", "기계제어공학부", "콘텐츠융합디자인학부", "생명과학부", "전산전자공학부", "상담심리사회복지학부", "ICT창업학부", "창의융합교육원", "AI융합교육원"};
		majorBox = new JComboBox<>();
		
		for(int i = 0; i<majorCombo.length; i++) {
			majorBox.addItem(majorCombo[i]);
		}
		majorBox.setBounds(480, 440, 150, 50);
		majorBox.setBackground(Color.WHITE);
		majorBox.setSelectedItem(user[2]);
		add(majorBox);
		
		//이메일 
		JLabel email = new JLabel("Email : ");
		email.setBounds(280, 500, 100, 40);
		add(email);
		
		emailField = new JTextField(user[3]);
		emailField.setBounds(480, 500, 240, 40);
		add(emailField);
		
		//버튼 
		String cancelButton = "Canel";
		cancel = new JButton(cancelButton);
		cancel.setBounds(330, 560, 150, 50);
		cancel.addActionListener(loginListener);
		add(cancel);
		
		String updateButton = "Update";
		update = new JButton(updateButton);
		update.setBounds(530, 560, 150, 50);
		update.addActionListener(loginListener);
		add(update);
		
		String dropOutButton = "DropOut";
		dropOut = new JButton(dropOutButton);
		dropOut.setBounds(430, 615, 150, 25);
		dropOut.addActionListener(loginListener);
		add(dropOut);
		MainFrame.frame.add(this);
	}
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if((e.getSource() == pwCheck)){
            	String pw = new String(pwField.getPassword());
            	String cpw = new String(cpwField.getPassword());
        		if(!pw.equals(cpw)) {
        			correct.setText("불일치합니다.");
        			cpwField.setText(null);
        			pwField.setText(null);
        		}
        		else {
        			correct.setText("일치합니다.");
        			pwDuplicate=true;
        		}
        	}
        	else if(input.equals("Canel")) {
        		cpwField.setText(null);
    			pwField.setText(null);
    			majorBox.setSelectedItem("선택...");
				emailField.setText(null);
				JOptionPane.showMessageDialog(null, "정보 변경을 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				new UserPanel();
				UpdateInfoPanel.this.setVisible(false);
        	}
        	else if(input.equals("Update")) {
        		if(pwDuplicate == false || cpwField.getText().isEmpty() || majorBox.getSelectedItem().equals("선택...")) {
            		JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            	}
				else {
					if(!emailField.getText().isEmpty()) ConnectMysql.updateInfo(MainFrame.userId, nameField.getText(), cpwField.getText(), majorBox.getSelectedItem().toString(), emailField.getText());
					else ConnectMysql.updateInfo(MainFrame.userId, nameField.getText(), pwField.getText(), majorBox.getSelectedItem().toString());
					
					JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					cpwField.setText(null);
	    			pwField.setText(null);
	    			majorBox.setSelectedItem("선택...");
					emailField.setText(null);
	        		new UserPanel();
	        		UpdateInfoPanel.this.setVisible(false);
				}
        	}
        	else if(input.equals("DropOut")) {
        		cpwField.setText(null);
    			pwField.setText(null);
    			majorBox.setSelectedItem("선택...");
				emailField.setText(null);
				int var = JOptionPane.showConfirmDialog(null, "정말로 계정을 삭제하시겠습니까?", "MESSAGE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
				if(var == 0) {
					ConnectMysql.deleteUser(MainFrame.userId);
					MainFrame.userId = "";
					JOptionPane.showMessageDialog(null, "계정이 삭제되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
	        		new LoginPanel();
	        		UpdateInfoPanel.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "계정이 삭제를 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
        		
        	}
        }
    };
}

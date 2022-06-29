package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateInfoPanel extends JPanel{
private MainFrame start;
	
	private JTextField emailField;
	private JPasswordField pwField, cpwField;
	private JButton cancel, update, pwCheck, dropOut;
	private JLabel idField, nameField, birthField, correct;
	
	public UpdateInfoPanel(MainFrame start) {
		this.start = start;
		setLayout(null);
		
		JLabel sign = new JLabel("Update Info");
		sign.setFont(new Font("Arial", Font.ITALIC, 60));
		sign.setHorizontalAlignment(JLabel.CENTER);
		sign.setBounds(250, 50, 500, 100);
		add(sign);
		
		//학번 
		JLabel studentID = new JLabel("Student ID : ");
		studentID.setBounds(280, 160, 100, 40);
		add(studentID);
		
		idField = new JLabel("22100271");
		idField.setBounds(480, 160, 240, 40);
		add(idField);
		
		//이름 
		JLabel name = new JLabel("Name : ");
		name.setBounds(280, 210, 100, 40);
		add(name);
		
		nameField = new JLabel("박규은");
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
		JLabel birth = new JLabel("Date of Birth : ");
		birth.setBounds(280, 400, 100, 40);
		add(birth);
		
		birthField = new JLabel("20020823");
		birthField.setBounds(480, 400, 240, 40);
		add(birthField);
		
		//학부 
		JLabel major = new JLabel("Major : ");
		major.setBounds(280, 440, 100, 40);
		add(major);
		
		JComboBox<String> majorBox;
		String majorCombo[] = {"글로벌 리더십학부", "국제어문학부", "경영경제학부", "법학부", "커뮤니케이션학부", "공간환경시스템공학부", "기계제어공학부", "콘텐츠융합디자인학부", "생명과학부", "전산전자공학부", "상담심리사회복지학부", "ICT창업학부", "창의융합교육원", "AI융합교육원"};
		majorBox = new JComboBox<>();
		
		for(int i = 0; i<majorCombo.length; i++) {
			majorBox.addItem(majorCombo[i]);
		}
		majorBox.setBounds(480, 440, 150, 50);
		majorBox.setBackground(Color.WHITE);
		add(majorBox);
		
		//이메일 
		JLabel email = new JLabel("Email : ");
		email.setBounds(280, 500, 100, 40);
		add(email);
		
		emailField = new JTextField();
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
		dropOut.setBounds(430, 610, 150, 25);
		dropOut.addActionListener(loginListener);
		add(dropOut);
	}
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Canel")) {
        		start.change("UserPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        	else if(input.equals("Update")) {
        		start.change("UpdateInfoPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        	else if(input.equals("DropOut")) {
        		start.change("LoginPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        }
    };
}

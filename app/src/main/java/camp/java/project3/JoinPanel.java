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

class JoinPanel extends JPanel{
	private MainFrame start;
	
	private JTextField idField, nameField, birthField, emailField;
	private JPasswordField pwField, cpwField;
	private JButton cancel, signUp, ok, pwCheck;
	private JLabel check = new JLabel();
	private JLabel sign = new JLabel();
	
	public JoinPanel(MainFrame start) {
		this.start = start;
		setLayout(null);
		
		sign.setText("SignUp");
		sign.setFont(new Font("Arial", Font.ITALIC, 60));
		sign.setHorizontalAlignment(JLabel.CENTER);
		sign.setBounds(250, 50, 500, 100);
		add(sign);
		
		//학번 
		JLabel studentID = new JLabel("Student ID : ");
		studentID.setBounds(280, 160, 100, 40);
		add(studentID);
		
		idField = new JTextField();
		idField.setBounds(480, 160, 240, 40);
		add(idField);
		
		String okButton = "확인";
		ok = new JButton(okButton);
		ok.setBounds(730, 160, 40, 40);
		ok.addActionListener(loginListener);
		add(ok);
		
		//이름 
		JLabel name = new JLabel("Name : ");
		name.setBounds(280, 210, 100, 40);
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(480, 210, 240, 40);
		add(nameField);
		
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
		check.setBounds(500, 365, 240, 40);
		check.setText("입력하세요");
		add(check);
		 
		//생년월일 
		JLabel birth = new JLabel("Date of Birth : ");
		birth.setBounds(280, 400, 100, 40);
		add(birth);
		
		birthField = new JTextField();
		birthField.setBounds(480, 400, 240, 40);
		add(birthField);
		
		//학부 
		JLabel major = new JLabel("Major : ");
		major.setBounds(280, 450, 100, 40);
		add(major);
		
		JComboBox<String> majorBox;
		String majorCombo[] = {"글로벌 리더십학부", "국제어문학부", "경영경제학부", "법학부", "커뮤니케이션학부", "공간환경시스템공학부", "기계제어공학부", "콘텐츠융합디자인학부", "생명과학부", "전산전자공학부", "상담심리사회복지학부", "ICT창업학부", "창의융합교육원", "AI융합교육원"};
		majorBox = new JComboBox<>();
		
		for(int i = 0; i<majorCombo.length; i++) {
			majorBox.addItem(majorCombo[i]);
		}
		majorBox.setBounds(480, 450, 150, 50);
		majorBox.setBackground(Color.WHITE);
		add(majorBox);
		
		//이메일 
		JLabel email = new JLabel("Email : ");
		email.setBounds(280, 510, 100, 40);
		add(email);
		
		emailField = new JTextField();
		emailField.setBounds(480, 510, 240, 40);
		add(emailField);
		
		//버튼 
		String cancelButton = "Canel";
		cancel = new JButton(cancelButton);
		cancel.setBounds(330, 580, 150, 50);
		cancel.addActionListener(loginListener);
		add(cancel);
		
		String signUpButton = "Check";
		signUp = new JButton(signUpButton);
		signUp.setBounds(530, 580, 150, 50);
		signUp.addActionListener(loginListener);
		add(signUp);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Check")) {
        		start.change("LoginPanel");//정보들이 맞다면 사용자 페이지 아니라면 원래 로그인 페이지 
        	}
        	else if(input.equals("Canel")) {
        		start.change("LoginPanel");
        	}
        }
    };
}

package camp.java.project3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	public static JPanel allLogin = new JPanel();
	private MainFrame start;
	
	public JLabel hgu = new JLabel();
	public JPanel r = new JPanel();//위에 글씨와 아이디,비밀번호 페널을 담을 패널 
	public JPanel b = new JPanel(); //버튼들의 패널을 담을 패널 
	public JPanel main = new JPanel();
	public JButton login = new JButton();
	public JPanel buttonPanel = new JPanel();
	public JPanel input = new JPanel();
	public JPanel option = new JPanel();
	
	public LoginPanel(MainFrame start){
		this.start = start;
		setLayout(null);
		allLogin.setBounds(0, 0, 1000, 700);
		allLogin.setLayout(null);
		main.setBounds(200, 200, 600, 400);
		main.setLayout(new GridLayout(2, 1));
		setInputButton();
		main.add(r);	
		setLoginButton();
		optionButton();
		b.add(buttonPanel);
		main.add(b);		
		buttonPanel.setLayout(new GridLayout(2, 1));
		this.add(main);
	}

	void setInputButton() {
		r.setLayout(new GridLayout(2, 1));
		hgu.setText("Login");
		hgu.setFont(new Font("Arial", Font.ITALIC, 80));
		hgu.setHorizontalAlignment(JLabel.CENTER);
		r.add(hgu);
		input.setLayout(new GridLayout(2, 1));
		JTextField idText = new JTextField(10);
		JLabel id = new JLabel("ID : ");
		id.setFont(new Font("Arial", Font.ITALIC, 20));
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		idPanel.add(id);
		idPanel.add(idText);
		input.add(idPanel);
		
		JPasswordField pwdText = new JPasswordField(10);
		JLabel pwd = new JLabel("PW : ");
		JPanel pwdPanel = new JPanel();
		pwd.setFont(new Font("Arial", Font.ITALIC, 20));
		pwdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		pwdPanel.add(pwd);
		pwdPanel.add(pwdText);
		input.add(pwdPanel);
		r.add(input);
	}
	
	void setLoginButton() {
		String button = "Login";
		login = new JButton(button);
		login.addActionListener(loginListener);
		buttonPanel.add(login);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Login")) {
        		start.change("UserPanel"); //사용자 페이지로 
        	}
        }
    };
	
	void optionButton() {
		option.setLayout(new GridLayout(1, 2));
		String[] button = {"Find PW", "Sign Up"};
		JButton[] bt = new JButton[button.length];
		for(int i=0; i<button.length; i++) {
			bt[i] = new JButton(button[i]);
			option.add(bt[i]);
			bt[i].addActionListener(optionListener);
		}
		buttonPanel.add(option);
	}
	ActionListener optionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Sign Up")) {
        		start.change("JoinPanel");
        	}
        	if(input.equals("Find PW")) {
        		start.change("FindPwPanel");
        	}
        }
    };
	
}

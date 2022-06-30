package camp.java.project3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPwPanel extends JPanel{
	private JLabel findPW;
	private JTextField idField, nameField, birthField;
	private JButton cancel, check;
	
	public FindPwPanel() {
		setLayout(null);
		
		findPW = new JLabel("Find PW");
		findPW.setFont(new Font("Arial", Font.ITALIC, 60));
		findPW.setHorizontalAlignment(JLabel.CENTER);
		findPW.setBounds(250, 140, 500, 100);
		add(findPW);
		
		//학번 
		JLabel studentID = new JLabel("Student ID : ");
		studentID.setBounds(280, 260, 100, 40);
		add(studentID);
		
		idField = new JTextField();
		idField.setBounds(480, 260, 240, 40);
		add(idField);
		
		//이름 
		JLabel name = new JLabel("Name : ");
		name.setBounds(280, 320, 100, 40);
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(480, 320, 240, 40);
		add(nameField);
		
		//생년월일 
		JLabel birth = new JLabel("Date of Birth (YYMMDD) : ");
		birth.setBounds(280, 380, 170, 40);
		add(birth);
		
		birthField = new JTextField();
		birthField.setBounds(480, 380, 240, 40);
		add(birthField);
		
		//버튼 
		String cancelButton = "Canel";
		cancel = new JButton(cancelButton);
		cancel.setBounds(350, 450, 150, 50);
		cancel.addActionListener(loginListener);
		add(cancel);
		
		String checkButton = "Change PW";
		check = new JButton(checkButton);
		check.setBounds(550, 450, 150, 50);
		check.addActionListener(loginListener);
		add(check);
		MainFrame.frame.add(this);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	if(input.equals("Canel")) {
        		idField.setText(null);
        		nameField.setText(null);
        		birthField.setText(null);
        		JOptionPane.showMessageDialog(null, "PW 찾기를 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		new LoginPanel();
        		FindPwPanel.this.setVisible(false);
        	}
        	else if(input.equals("Change PW")) {
        		if(idField.getText().isEmpty() || nameField.getText().isEmpty() || birthField.getText().isEmpty()) JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		else {
        			ConnectMysql.select(idField.getText(), nameField.getText(), birthField.getText());
        			idField.setText(null);
            		nameField.setText(null);
            		birthField.setText(null);
            		if(!ConnectMysql.findPWSuccess.equals("")) {
            			JOptionPane.showMessageDialog(null, "PW를 찾았습니다.\n" +ConnectMysql.findPWSuccess , "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            			new ChangePwPanel();
                		FindPwPanel.this.setVisible(false);
            		}
            		else JOptionPane.showMessageDialog(null, "PW를 찾지 못했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		}
        	}
        }
    };
}

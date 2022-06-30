package camp.java.project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class AdminPanel extends JPanel {
	private JLabel title;
	private JPanel content;
	private JTextField inputUser;
	private JButton delete, logout, truncate;
	private JTable jt;
	int row;
	
	
	
	static ArrayList<List<String>> info = new ArrayList<List<String>>();
	
	private String data[][];
	private String column[] = {"Id", "Name", "Pw", "Dob", "Major", "Email", "Regidate"};
	
	public AdminPanel() {
		
		data = new String[info.size()][info.get(0).size()];
		for(int i = 0; i < info.size(); i++) {
			for(int j = 0; j < info.get(i).size(); j++) {
				data[i][j] = info.get(i).get(j);
			}
		}
		
		setLayout(null);
		
		title = new JLabel("Adamin Page");
		title.setFont(new Font("Arial", Font.ITALIC, 60));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(100, 30, 800, 100);
		add(title);

		jt = new JTable(data, column);
		JScrollPane scrollPane = new JScrollPane(jt);
		
		scrollPane.setBounds(15, 140, 970, 400);
		add(scrollPane);
		
		
		delete = new JButton("Delete");
		delete.setBounds(280, 570, 200, 70);
		delete.addActionListener(loginListener);
		add(delete);
		
		
		truncate = new JButton("Truncate");
		truncate.setBounds(550, 570, 200, 70);
		truncate.addActionListener(loginListener);
		add(truncate);
		
		logout = new JButton("Logout");
		logout.setBounds(420, 650, 200, 50);
		logout.addActionListener(loginListener);
		add(logout);
		
		MainFrame.frame.add(this);
	}
	
	ActionListener loginListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String input = e.getActionCommand();
        	row = jt.getSelectedRow();
        	if(input.equals("Delete")) {
        		if(row == -1) {
        			JOptionPane.showMessageDialog(null, "계정을 먼저 선택하세요.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		}
        		else{
        			String userId = (String) jt.getValueAt(row, 0);
        			int var = JOptionPane.showConfirmDialog(null, "정말로 계정을 삭제하시겠습니까?", "MESSAGE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
    				if(var == 0) {
    					ConnectMysql.deleteUser(userId);
    					JOptionPane.showMessageDialog(null, "계정이 삭제되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
    					info.clear();
    					new LoginPanel();
    	        		AdminPanel.this.setVisible(false);
    				}
    				else {
    					JOptionPane.showMessageDialog(null, "계정이 삭제를 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
    				}
        		}
        	}
        	else if(input.equals("Truncate")) {
        		int var = JOptionPane.showConfirmDialog(null, "정말로 전체를 삭제하시겠습니까?", "MESSAGE", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
				if(var == 0) {
					ConnectMysql.truncate();
					JOptionPane.showMessageDialog(null, "삭제되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					info.clear();
					new LoginPanel();
	        		AdminPanel.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "계정이 삭제를 취소했습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
        	}
        	else if(input.equals("Logout")) {
        		JOptionPane.showMessageDialog(null, "Logout 되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
        		info.clear();
        		new LoginPanel();
        		AdminPanel.this.setVisible(false);
        	}
        	
        }
    };
}

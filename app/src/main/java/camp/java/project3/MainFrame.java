package camp.java.project3;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public LoginPanel loginPanel = null;
	public JoinPanel joinPanel = null;
	public FindPwPanel findPwPanel = null;
	public ChangePwPanel changePwPanel = null;
	public UpdateInfoPanel updateInfoPanel = null;
	public UserPanel userPanel = null;
	
	public void change(String panelName) {
		if((panelName.equals("JoinPanel"))) {
			getContentPane().removeAll();
			getContentPane().add(joinPanel);
			revalidate();
			repaint();
		}
		else if((panelName.equals("FindPwPanel"))) {
			getContentPane().removeAll();
			getContentPane().add(findPwPanel);
			revalidate();
			repaint();
		}
		else if((panelName.equals("ChangePwPanel"))) {
			getContentPane().removeAll();
			getContentPane().add(changePwPanel);
			revalidate();
			repaint();
		}
		else if((panelName.equals("UpdateInfoPanel"))) {
			getContentPane().removeAll();
			getContentPane().add(updateInfoPanel);
			revalidate();
			repaint();
		}
		else if((panelName.equals("UserPanel"))) {
			getContentPane().removeAll();
			getContentPane().add(userPanel);
			revalidate();
			repaint();
		}
		else {
			getContentPane().removeAll();
			getContentPane().add(loginPanel);
			revalidate();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		MainFrame start = new MainFrame();
		start.loginPanel = new LoginPanel(start);
		start.joinPanel = new JoinPanel(start);
		start.findPwPanel = new FindPwPanel(start);
		start.changePwPanel = new ChangePwPanel(start);
		start.updateInfoPanel = new UpdateInfoPanel(start);	
		start.userPanel = new UserPanel(start);	
		
		start.add(start.loginPanel);
		
		start.setTitle("HGU Login Procedure");
		start.setSize(1000, 800);
		start.setVisible(true);
		
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

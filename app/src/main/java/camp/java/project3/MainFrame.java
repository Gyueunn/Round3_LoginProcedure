package camp.java.project3;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	static JFrame frame = new JFrame();
	static String userId = "";
	MainFrame(){
		frame.setTitle("HGU Login Procedure");
		frame.setSize(1000, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {	
		LoginPanel loginPanel = new LoginPanel();
		MainFrame mainFrame = new MainFrame();
	}
}

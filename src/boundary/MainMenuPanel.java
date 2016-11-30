package boundary;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controllers.ThemeMenuButtonController;
import model.Model;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class MainMenuPanel extends JPanel{
	
	//setcondentpane
	//revalidate
	
	/*
	 * 	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderGUI window = new LevelBuilderGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	private Application a;
	private Model m;
	
	private JButton btnPuzzle;
	private JButton btnLightning;
	private JButton btnTheme;
	private JButton btnDeleteLevel;
	private JLabel lblMainMenu;



	/**
	 * Create the application.
	 */
	public MainMenuPanel(Application a, Model m) {
		initialize(a, m);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Application a, Model m) {
		this.a = a;
		this.m = m;
		initializeViews();
		initializeControllers();
	}
	
	private void initializeViews(){
		
		btnPuzzle = new JButton("Puzzle");
		btnPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnPuzzle.setBounds(200, 147, 200, 50);
		add(btnPuzzle);
		this.setLayout(null);
		
		lblMainMenu = new JLabel("MAIN MENU");
		lblMainMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblMainMenu.setBounds(150, 25, 300, 100);
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMainMenu);
		
		
		btnLightning = new JButton("Lightning");
		btnLightning.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnLightning.setBounds(200, 210, 200, 50);
		add(btnLightning);
		
		btnTheme = new JButton("Theme");
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTheme.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnTheme.setBounds(200, 273, 200, 50);
		add(btnTheme);
		
		btnDeleteLevel = new JButton("Delete Level");
		btnDeleteLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnDeleteLevel.setBounds(371, 391, 200, 50);
		add(btnDeleteLevel);
	}
	
	private void initializeControllers(){
		btnTheme.addMouseListener(new ThemeMenuButtonController(this, a, m));
	}
}
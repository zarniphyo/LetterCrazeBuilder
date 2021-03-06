package boundary;
import java.awt.EventQueue;
import model.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import controller.PreviewLevelController;
import controller.SaveLevelController;
import controller.ToMainMenuController;
import model.Model;

import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class PuzzleBuilderPanel extends JPanel{
	
	private Application a;
	private Model m;

	public JTextField textField;
	public JTextField textFieldW;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JToggleButton[] toggleButtonArray;
	
	JLabel lblPuzzle;
	JButton btnMainMenu;
	JLabel lblLevel;
	JLabel lblLimit;
	JButton btnPrev;
	JButton btnSave;
	
	JLabel star_1;
	JLabel star_2;
	JLabel star_3;
	JLabel star_4;
	JLabel star_5;
	JLabel star_6;
	

	/**
	 * Create the application.
	 */
	public PuzzleBuilderPanel(Application a, Model m) {
		this.a = a;
		this.m = m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeView();
		initializeControllers();
	}
		/*
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		*/
	private void initializeView(){
		
		this.setLayout(null);
		
		toggleButtonArray = new JToggleButton[36];
		for (int i = 0; i < 36; i++){
			toggleButtonArray[i] = new JToggleButton("");
			int x_pos = 20 + 70 * (i % 6);
			int y_pos = 62 + 70 * (i / 6);
			toggleButtonArray[i].setBounds(x_pos, y_pos, 70, 70);
			add(toggleButtonArray[i]);
		}	
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(545, 13, 175, 52); //13
		btnMainMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		add(btnMainMenu);
		
		lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblPuzzle.setBounds(25, 13, 107, 36);
		add(lblPuzzle);
		
		lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblLevel.setBounds(500, 115, 70, 28);
		add(lblLevel);
		
		textField = new JTextField();
		textField.setBounds(570, 118, 100, 25);
		add(textField);
		textField.setColumns(10);
		
		lblLimit = new JLabel("Limit:");
		lblLimit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblLimit.setBounds(500, 175, 70, 28);
		add(lblLimit);
		
		textFieldW = new JTextField();
		textFieldW.setBounds(570, 180, 100, 25);
		add(textFieldW);
		textFieldW.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(657, 226, 46, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(657, 255, 46, 22);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(657, 284, 46, 22);
		add(textField_3);
		
		btnPrev = new JButton("Preview");
		btnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnPrev.setBounds(533, 393, 130, 36);
		add(btnPrev);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnSave.setBounds(539, 442, 118, 36);
		add(btnSave);
		
		star_1 = new JLabel("New label");
		star_1.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_1.setBounds(615, 229, 16, 16);
		add(star_1);
		
		star_2 = new JLabel("New label");
		star_2.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_2.setBounds(615, 258, 16, 16);
		add(star_2);
		
		star_3 = new JLabel("New label");
		star_3.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_3.setBounds(587, 258, 16, 16);
		add(star_3);
		
		star_4 = new JLabel("New label");
		star_4.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_4.setBounds(615, 287, 16, 16);
		add(star_4);
		
		star_5 = new JLabel("New label");
		star_5.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_5.setBounds(587, 287, 16, 16);
		add(star_5);
		
		star_6 = new JLabel("New label");
		star_6.setIcon(new ImageIcon
				(PuzzleBuilderPanel.class.getResource("/resources/STAR.png")));
		star_6.setBounds(559, 287, 16, 16);
		add(star_6);	
	}
	
	private void initializeControllers(){
		btnMainMenu.addMouseListener(new ToMainMenuController(this.a, this.m));
		btnSave.addMouseListener(new SaveLevelController(this.a, this.m));
		btnPrev.addMouseListener(new PreviewLevelController(this.a, this.m));
	}

	public JTextField getLevelNumber() {
		return this.textField;
	}
	
	public JTextField getForOneStar() {
		return this.textField_1;
	}
	
	public JTextField getForTwoStar() {
		return this.textField_2;
	}
	
	public JTextField getForThreeStar() {
		return this.textField_3;
	}
	
	// Checks what buttons were selected(i.e. what buttons should be disabled in new board)
	public boolean getBoardShape(int butNum) {
		return toggleButtonArray[butNum].isSelected();
	}

	public JTextField getLimit() {
		return this.textFieldW;
	}
	
	// Mark tile at position i as selected 
	public void setSelectedTiles(int i) {
		toggleButtonArray[i].setSelected(true);
		repaint();
	}
	
	public void setLevelNumber(int lvl) {
		this.textField.setText(lvl+"");
		repaint();
	}
	
	public void setLimit(int wordLimit) {
		this.textFieldW.setText(wordLimit+"");
	}
	
	public void setOneStar(int thresh1) {
		this.textField_1.setText(thresh1+"");
	}
	
	public void setTwoStar(int thresh2) {
		this.textField_2.setText(thresh2+"");
	}
	
	public void setThreeStar(int thresh3) {
		this.textField_3.setText(thresh3+"");
	}
	
}
